import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BoardTest {

    @Test
    public void testIfNewlyCreatedBoardHasHeader(){
        //when
        Board b = new Board(5,5);

        //then
        assertEquals(b.getCell(0,0),'4');
        assertEquals(b.getCell(6,6),'4');

        //and when
        Board b2 = new Board(7,7);

        //then
        assertEquals(b2.getCell(0,0),'6');
        assertEquals(b2.getCell(8,8),'6');
    }

    @Test
    public void test(){
        //given
        Board b = new Board(5,5);

        //when
        b.insertPoint(1,1);

        //then
        assertEquals(b.getCell(3,3), 'x');
    }
}