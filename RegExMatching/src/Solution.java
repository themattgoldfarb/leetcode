public class Solution {

    public boolean isMatch(String s, String p){
        p = compressStars(p);

        return isMatchHelper(s,p, countMinCharacters(p));
    }

    private int countMinCharacters(String p) {
        int pCount=0;
        for (int i = 0; i< p.length();i++){
            if(p.charAt(i)!='*' && (i+1>=p.length() || p.charAt(i+1)!='*') ){
                pCount++;
            }
        }
        return pCount;
    }

    private String compressStars(String p) {
        int j = 0;
        while(j<p.length()){
            if(
                    p.length()>=j+3
                    && p.charAt(j)=='*'
                    && p.charAt(j+2)=='*'
                    && p.charAt(j+1)==p.charAt(j-1)){
                p=p.substring(0,j).concat(p.substring(j+2,p.length()));
            }
            j++;
        }
        return p;
    }

    public boolean isMatchHelper(String s, String p, int pCount){

        if(s.length()==0){
            if(pCount>0){
                return false;
            }
            return true;
        }
        if(p.length()==0){
            return false;
        }

        if(p.length()>=2 && p.charAt(1)=='*'){
            return (
                    compareChars(s.charAt(0), p.charAt(0))
                    && (
                            isMatchHelper(s.substring(1),p.substring(2), pCount)
                            || isMatchHelper(s.substring(1), p, pCount)
                    )
                || isMatchHelper(s, p.substring(2), pCount));
        }
        return (
                compareChars(s.charAt(0), p.charAt(0))
        ) && isMatchHelper(s.substring(1),p.substring(1),pCount-1);
    }

    private boolean compareChars(char a, char b){
        return a==b || b=='.';
    }
}
