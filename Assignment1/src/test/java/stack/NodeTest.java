package stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    private Node<Integer> node;
    private int item1;
    private int item2;
    private int item3;

    @BeforeEach
    void setUp() {
        this.node = new Node<>();
        item1 = 1;
        item2 = 2;
        item3 = 3;
    }

    @Test
    void testSetData() {
        Assertions.assertEquals(node.getData(), 1);
        node.setData(item2);
        Assertions.assertEquals(node.getData(), 2);
    }

    @Test
    void testGetData() {
        Assertions.assertEquals(node.getData(), 1);
    }

    @Test
    void testSetNext() {
        Node<Integer> node1 = new Node<>();
        node.setNext(node1);
        Assertions.assertEquals(node.getNext().getData(), 2);
    }

    @Test
    void testGetNext() {
        Node<Integer> node1 = new Node<>();
        node.setNext(node1);
        Assertions.assertEquals(node.getNext().getData(), 2);
    }
}