package tqs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

/**
 * Unit test for simple App.
 */
public class StackTest 
{
    private stack<Integer>  TQSatck;

    @BeforeEach
    void setup(){
        TQSatck = new stack<>();
    }

    @DisplayName("A stack is empty on construction")
    @Test
    public void stackempty()
    {
        assertTrue(TQSatck.isEmpty() );
    }

    @DisplayName("A stack has size 0 on construction")
    @Test
    public void stacksize()
    {
        assertEquals(0,TQSatck.size() );
    }

    @DisplayName("After n pushes to an empty stack, n > 0, the stack is not empty and its size is n")
    @Test
    public void stackpush()
    {
        for(int i = 0; i<10;i++){
            TQSatck.push(i);
        }
        assertFalse(TQSatck.isEmpty());
        assertEquals(10, TQSatck.size());
    }

    @DisplayName("If one pushes x then pops, the value popped is x.")
    @Test
    public void stackPopAfterPush()
    {
        TQSatck.push(10);
        assertEquals(10,TQSatck.pop());
        assertTrue(TQSatck.isEmpty());
    }

    @DisplayName("If one pushes x then peeks, the value returned is x, but the size stays the same")
    @Test
    public void stackPeekAfterPush()
    {
        TQSatck.push(10);
        assertEquals(10,TQSatck.peek());
        assertFalse(TQSatck.isEmpty());
    }

    @DisplayName("If the size is n, then after n pops, the stack is empty and has a size 0")
    @Test
    public void stackSizeAfterPops()
    {
        for(int i = 0; i<10;i++){
            TQSatck.push(i);
        }
        assertFalse(TQSatck.isEmpty());
        assertEquals(10, TQSatck.size());
    }

    @DisplayName("Pop from a empty stack")
    @Test
    public void popempty()
    {
        assertThrows( NoSuchElementException.class, () ->{
            TQSatck.pop();
        } );
    }

    @DisplayName("Peeking into an empty stack")
    @Test
    public void peekempty()
    {
        assertThrows( NoSuchElementException.class, () ->{
            TQSatck.peek();
        } );
    }

    @DisplayName("For bounded stacks only: pushing onto a full stack")
    @Test
    public void PushingBounded()
    {
        TQSatck = new stack<>(3);

        for(int i = 0; i<3; i++){
            TQSatck.push(i);
        }

        assertThrows( IllegalStateException.class, () ->{
            TQSatck.push(1);
        } );
    }
}
