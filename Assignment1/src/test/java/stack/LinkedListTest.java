package stack;

import Exceptions.EmptyListException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    private LinkedList<Integer> linkedList;
    private int item1;
    private int item2;
    private int item3;
    private int item4;
    private int item5;

    @BeforeEach
    void setUp()
    {
        this.linkedList = new LinkedList<>();
        item1 = 1;
        item2 = 2;
        item3 = 3;
        item4 = 4;
        item5 = 5;
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testIsEmpty(){
        Assertions.assertTrue(linkedList.isEmpty());
        Assertions.assertFalse(linkedList.isEmpty());
    }

    @Test
    void testSize0(){
        Assertions.assertEquals(linkedList.size(), 0);
    }

    @Test
    void testSize1(){
        linkedList.addToFront(item1);
        Assertions.assertEquals(linkedList.size(), 1);
    }

    @Test
    void testSizeMany(){
        linkedList.addToFront(item3);
        linkedList.addToFront(item4);
        Assertions.assertEquals(linkedList.size(), 2);
    }

    @Test
    void testAddToFront0(){
        Assertions.assertEquals(linkedList.size(), 0);
        linkedList.addToFront(item3);
        Assertions.assertFalse(linkedList.isEmpty());
        Assertions.assertEquals(linkedList.size(), 1);
    }

    @Test
    void testAddToFrontMany(){
        linkedList.addToFront(item4);
        linkedList.addToFront(item5);
        linkedList.addToFront(item3);
        Assertions.assertFalse(linkedList.isEmpty());
        Assertions.assertEquals(linkedList.size(), 3);
    }

    @Test
    void removeFirst0() {
        Assertions.assertThrows(EmptyListException.class, () ->
                linkedList.removeFirst());
    }

    @Test
    void removeFirst1() throws Exception {
        Assertions.assertEquals(linkedList.size(), 0);
        linkedList.addToFront(item1);
        Assertions.assertEquals(linkedList.size(), 1);
        int firstElement = linkedList.removeFirst();
        Assertions.assertEquals(linkedList.size(), 0);
        Assertions.assertEquals(item1, firstElement);
    }

    @Test
    void removeFirstMany() throws Exception
    {
        int firstItem;
        linkedList.addToFront(item4);
        linkedList.addToFront(item5);
        linkedList.addToFront(item2);
        Assertions.assertEquals(linkedList.size(), 3);

        firstItem = linkedList.removeFirst();
        Assertions.assertEquals(linkedList.size(), 2);
        Assertions.assertEquals(firstItem, item2);

        firstItem = linkedList.removeFirst();
        Assertions.assertEquals(linkedList.size(), 1);
        Assertions.assertEquals(firstItem, item5);

        firstItem = linkedList.removeFirst();
        Assertions.assertEquals(linkedList.size(), 0);
        Assertions.assertEquals(firstItem, item4);
    }
}