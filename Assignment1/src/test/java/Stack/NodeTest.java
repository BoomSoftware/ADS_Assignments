package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NodeTest {

    private Node<Integer> node;
    private int item2;
    private int item3;

    @BeforeEach
    void setUp() {
        this.node = new Node<>();
        item2 = 2;
        item3 = 3;
    }

    @Test
    void testSetNodeData() {
        node.setData(item2);
        Assertions.assertEquals(node.getData(), item2);
    }

    @Test
    void testGetInstantiatedNodeData() {
        node.setData(item3);
        Assertions.assertEquals(node.getData(), item3);
    }

    @Test
    void testGetNotInstantiatedNodeData() {
        Assertions.assertNull(node.getData());
    }

    @Test
    void testSetNextNode() {
        Node<Integer> tempNode = new Node<>();
        tempNode.setData(5);

        node.setNext(tempNode);
        Assertions.assertEquals(node.getNext().getData(), tempNode.getData());
    }

    @Test
    void testGetInstantiatedNextNode() {
        Node<Integer> tempNode = new Node<>();

        node.setNext(tempNode);
        Assertions.assertEquals(node.getNext(), tempNode);
    }

    @Test
    void testGetNotInstantiatedNextNode() {
        Assertions.assertNull(node.getNext());
    }
}