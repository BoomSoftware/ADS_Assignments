import Exceptions.EmptyListException;
import org.junit.jupiter.api.Test;
import stack.LinkedList;
import stack.LinkedStack;
import stack.Node;

import java.awt.*;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class PostfixCalculatorTest {

    // Unit Test for the LinkedList in stack package.
    @Test
    public <T> void testIsEmpty(){
        LinkedList<T> linkedList = new LinkedList<>();

        int result = linkedList.size();

        assertEquals(10, 5, result);
    }

    @Test
    public <T> void testSize(){
        LinkedList<T> linkedList = new LinkedList<>();
        assertTrue(linkedList.isEmpty());
        assertFalse(linkedList.isEmpty());
    }
}
