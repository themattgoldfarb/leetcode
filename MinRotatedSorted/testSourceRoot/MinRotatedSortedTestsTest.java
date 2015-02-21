import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MinRotatedSortedTestsTest {
    private Solution solution;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,3,4,5}, 1},
                {new int[]{3,4,5,1,2}, 1},
                {new int[]{1}, 1},
                {new int[]{10,12,14,15,16,17,20,22,0,3,4,5}, 0},
        });
    }

    @Parameterized.Parameter
    public int[] input;

    @Parameterized.Parameter(value = 1)
    public int smallest;


    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testIsMatch(){
        assertEquals(smallest, solution.findMin(input));
    }
}