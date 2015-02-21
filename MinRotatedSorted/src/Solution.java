/**
 * Created by matt on 2/21/15.
 */
public class Solution {
    public int findMin(int[] num){
        if (num.length==1) return num[0];

        return findMinRecurse(num, 0, num.length-1);
    }


    public int findMinRecurse(int[] num, int left, int right){
        if(left+1 == right){
            if(num[right] < num[left]){
                return num[right];
            }
            return num[0];
        }

        int middle = (right-left)/2+left;
        if(num[left]<=num[middle]){
            return findMinRecurse(num, middle, right);
        }
        return findMinRecurse(num, left, middle);
    }
}
