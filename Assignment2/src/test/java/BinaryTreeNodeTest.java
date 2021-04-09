import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tree.BinaryTreeNode;

public class BinaryTreeNodeTest {

    private BinaryTreeNode node;

    @BeforeEach
    public void prepareTreeNode() {
        node = new BinaryTreeNode(0);
    }


    /*
        Set element
    */

    @Test
    public void setElementTrueTest() {
        int element = 10;
        node.setElement(element);
        Assertions.assertEquals(element, node.getElement());
    }

    @Test
    public void setElementFalseTest() {
        int element = 10;
        node.setElement(element);
        Assertions.assertNotEquals(50, node.getElement());
    }


    /*
        Get element
    */

    @Test
    public void getElementTrueTest() {
        Assertions.assertEquals(0, node.getElement());
    }

    @Test
    public void getElementFalseTest() {
        Assertions.assertNotEquals(50, node.getElement());
    }


    /*
        Left child
    */

    @Test
    public void getEmptyLeftChildTest() {
        Assertions.assertNull(node.getLeftChild());
    }

    @Test
    public void addLeftChildTest() {
        BinaryTreeNode leftChild = new BinaryTreeNode(30);
        node.addLeftChild(leftChild);
        Assertions.assertEquals(leftChild, node.getLeftChild());
    }


    /*
        Right child
    */

    @Test
    public void getEmptyRightChildTest() {
        Assertions.assertNull(node.getRightChild());
    }

    @Test
    public void addRightChildTest() {
        BinaryTreeNode rightChild = new BinaryTreeNode(30);
        node.addRightChild(rightChild);
        Assertions.assertEquals(rightChild, node.getRightChild());
    }
}
