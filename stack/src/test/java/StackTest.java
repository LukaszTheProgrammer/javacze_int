import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StackTest {

    @Test
    public void testIfNewlyCreatedStackIsEmpty() {
        //when
        Stack<Integer> s = new Stack<>();

        //then
        assertEquals(true, s.isEmpty());
    }

    @Test
    public void testIfAddingElementsChangesEmptyState() {
        //when
        Stack<Integer> s = new Stack<>();
        s.add(5);

        //then
        assertEquals(false, s.isEmpty());
    }

    @Test
    public void testIfLastItemAddedIsTheFirstReturned() {
        //when
        Stack<Integer> s = new Stack<>();
        s.add(5);
        s.add(6);
        int top1 = s.pop();
        int top2 = s.pop();

        //then
        assertEquals(6, top1);
        assertEquals(5, top2);
    }

    @Test(expected = EmptyStackException.class)
    public void testIfPopThrowsWhenStackIsEmpty() {
        //when
        Stack<Integer> s = new Stack<>();
        s.pop();
    }
}