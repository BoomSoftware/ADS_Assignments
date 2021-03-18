package Stack;

import Exceptions.EmptyStackException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedStackTest {

    private LinkedStack<Integer> linkedStack;
    private int item1;
    private int item2;
    private int item3;

    @BeforeEach
    void setUpStack() {
        this.linkedStack = new LinkedStack<Integer>();
        this.item1 = 1;
        this.item2 = 2;
        this.item3 = 3;
    }

    @Test
    void testIsStackEmptyFalse() {
        linkedStack.push(item1);
        Assertions.assertFalse(linkedStack.isEmpty());
    }

    @Test
    void testIsStackEmptyTrue() {
        Assertions.assertTrue(linkedStack.isEmpty());
    }

    @Test
    void testStackPushOne() throws EmptyStackException {
        Assertions.assertTrue(linkedStack.isEmpty());
        linkedStack.push(item1);
        Assertions.assertFalse(linkedStack.isEmpty());
        Assertions.assertEquals(item1, linkedStack.pop());
    }

    @Test
    void testStackPushMany() throws EmptyStackException {
        Assertions.assertTrue(linkedStack.isEmpty());
        linkedStack.push(item1);
        linkedStack.push(item2);
        linkedStack.push(item3);
        Assertions.assertFalse(linkedStack.isEmpty());
        Assertions.assertEquals(item3, linkedStack.pop());
    }

    @Test
    void testPopFromEmptyStack() {
        Assertions.assertThrows(EmptyStackException.class, () ->
                linkedStack.pop());
    }

    @Test
    void testStackPopOne() throws Exception {
        linkedStack.push(item1);
        Assertions.assertFalse(linkedStack.isEmpty());
        Assertions.assertEquals(item1, linkedStack.pop());
    }

    @Test
    void testStackPopMany() throws Exception {
        linkedStack.push(item1);
        linkedStack.push(item2);
        linkedStack.push(item3);

        Assertions.assertEquals(item3, linkedStack.pop());
        Assertions.assertEquals(item2, linkedStack.pop());
        Assertions.assertEquals(item1, linkedStack.pop());
        Assertions.assertTrue(linkedStack.isEmpty());
    }
}