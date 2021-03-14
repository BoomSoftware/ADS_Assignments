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
        assertTrue(linkedList.isEmpty());
        assertFalse(linkedList.isEmpty());
    }

    @Test
    public <T> void testAddToFront(){
        LinkedList<T> linkedList = new LinkedList<>();

    }

    @Test
    public <T> void testRemoveFirst() {
        LinkedList<T> linkedList = new LinkedList<>();

    }

    //Unit test for the LinkedStack class in the stack package

    @Test
    public <T> void testIsEmpty2(){
        LinkedStack<T> linkedStack = new LinkedStack<>();
        assertTrue(linkedStack.isEmpty());
        assertFalse(linkedStack.isEmpty());
    }

    @Test
    public <T> void testPush(){
        LinkedStack<T> linkedStack = new LinkedStack<>();
    }

    @Test
    public void testPop(){

    }

    //Unit test for Node class in the stack package.

}
