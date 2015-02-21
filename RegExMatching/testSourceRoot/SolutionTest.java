import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SolutionTest {
    private Solution solution;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {"a","a", true},
                {"ab","a.", true},
                {"ab","a", false},
                {"ab",".b", true},
                {"ab","..b", false},
                {"ab","b", false},
                {"b","*b", false},
                {"b","b*", true},
                {"aa",".*", true},
                {"ab",".*", true},
                {"a","ab*",true},
                {"aaa","ab*ac*a", true},
                {"aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c", false}
        });
    }

    @Parameterized.Parameter
    public String s;

    @Parameterized.Parameter(value = 1)
    public String p;

    @Parameterized.Parameter(value = 2)
    public boolean b;


    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testIsMatch() throws Exception {
        assertEquals(b, solution.isMatch(s, p));
    }
}