import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test(){
        //when
        int result = Solution.squaresDifference(3);
        //then
        assertEquals(22, result);

        //and when
        int result2 = Solution.squaresDifference(10);

        //then
        assertEquals(2640, result2);
    }
}