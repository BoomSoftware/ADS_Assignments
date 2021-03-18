package Stack;

import Exceptions.EmptyListException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListTest {

    private LinkedList<Integer> linkedList;
    private int item1;
    private int item2;
    private int item3;
    private int item4;
    private int item5;

    @BeforeEach
    void setUpList()
    {
        this.linkedList = new LinkedList<>();
        item1 = 1;
        item2 = 2;
        item3 = 3;
        item4 = 4;
        item5 = 5;
    }

    @Test
    void testListIsEmptyFalse(){
        linkedList.addToFront(item1);
        Assertions.assertFalse(linkedList.isEmpty());
    }

    @Test
    void testListIsEmptyTrue(){
        Assertions.assertTrue(linkedList.isEmpty());
    }

    @Test
    void testListSizeZero(){
        Assertions.assertEquals(linkedList.size(), 0);
    }

    @Test
    void testListSizeOne(){
        linkedList.addToFront(item1);
        Assertions.assertEquals(linkedList.size(), 1);
    }

    @Test
    void testListSizeMany(){
        linkedList.addToFront(item3);
        linkedList.addToFront(item4);
        linkedList.addToFront(item5);
        Assertions.assertEquals(linkedList.size(), 3);
    }

    @Test
    void testIsEmptyAfterAddToFrontOne(){
        Assertions.assertEquals(linkedList.size(), 0);
        linkedList.addToFront(item3);
        Assertions.assertFalse(linkedList.isEmpty());
        Assertions.assertEquals(linkedList.size(), 1);
    }

    @Test
    void testIsEmptyAfterAddToFrontMany(){
        linkedList.addToFront(item4);
        linkedList.addToFront(item5);
        linkedList.addToFront(item3);
        Assertions.assertFalse(linkedList.isEmpty());
        Assertions.assertEquals(linkedList.size(), 3);
    }

    @Test
    void testRemoveFromEmptyList() {
        Assertions.assertThrows(EmptyListException.class, () ->
                linkedList.removeFirst());
    }

    @Test
    void testIsListEmptyAfterRemoveOne() throws Exception {
        Assertions.assertEquals(linkedList.size(), 0);
        linkedList.addToFront(item1);
        Assertions.assertEquals(linkedList.size(), 1);
        int removedElement = linkedList.removeFirst();
        Assertions.assertEquals(linkedList.size(), 0);
        Assertions.assertEquals(item1, removedElement);
        Assertions.assertTrue(linkedList.isEmpty());
    }

    @Test
    void testIsListEmptyAfterRemoveMany() throws Exception {
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