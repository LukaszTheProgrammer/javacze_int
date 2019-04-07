import org.junit.Assert;
import org.junit.Test;

public class StackTest {
    @Test
public void StackCreateTest(){
        Stack stack= new Stack();

        Assert.assertTrue(stack.isEmpty());
    }
    @Test
public void StackNotEmptyTest(){
        Stack stack=new Stack(1);

        Assert.assertFalse(stack.isEmpty());
    }
    @Test
    public void StackAddTest(){
        Stack stack=new Stack();
        stack.add(1);

        Assert.assertFalse(stack.isEmpty());
    }
    @Test(expected =RuntimeException.class)
    public void emptyStackPopExeptionTest(){
        Stack stack=new Stack();
stack.pop();

    }
    @Test
    public void StackPopFunctionTest(){
        Stack stack= new Stack(1,4);

        Assert.assertEquals(4,stack.pop());
    }
    @Test
    public void afterPopElementisRemovedTest(){
        Stack stack=new Stack(1,4);
        stack.pop();

        Assert.assertEquals(1,stack.pop());
    }

}