package stack;

import Exceptions.EmptyStackException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {

    private LinkedStack<Integer> linkedStack;
    private int item1;
    private int item2;
    private int item3;

    @BeforeEach
    void setUp() {
        this.linkedStack = new LinkedStack<>();
        this.item1 = 1;
        this.item2 = 2;
        this.item3 = 3;
    }

    @Test
    void testIsEmpty() {
        Assertions.assertTrue(linkedStack.isEmpty());
        Assertions.assertFalse(linkedStack.isEmpty());
    }

    @Test
    void testPush0() {
        Assertions.assertFalse(linkedStack.isEmpty());
    }

    @Test
    void testPush1() {
        Assertions.assertTrue(linkedStack.isEmpty());
        linkedStack.push(item1);
        Assertions.assertFalse(linkedStack.isEmpty());
    }

    @Test
    void testPushMany() {
        Assertions.assertTrue(linkedStack.isEmpty());
        linkedStack.push(item1);
        linkedStack.push(item2);
        linkedStack.push(item3);
        Assertions.assertFalse(linkedStack.isEmpty());
    }

    @Test
    void testPop0() {
        Assertions.assertThrows(EmptyStackException.class, () ->
                linkedStack.pop());
    }

    @Test
    void testPop1() throws Exception {
        linkedStack.push(item1);
        Assertions.assertFalse(linkedStack.isEmpty());
        Object object = linkedStack.pop();
        Assertions.assertEquals(object, 1);
    }

    @Test
    void testPopMany() throws Exception {
        linkedStack.push(item1);
        linkedStack.push(item2);
        linkedStack.push(item3);

        Object object1 = linkedStack.pop();
        Object object2 =  linkedStack.pop();
        Object object3 = linkedStack.pop();

        Assertions.assertEquals(object1, 1);
        Assertions.assertEquals(object2, 2);
        Assertions.assertEquals(object3, 3);
        Assertions.assertTrue(linkedStack.isEmpty());
    }
}