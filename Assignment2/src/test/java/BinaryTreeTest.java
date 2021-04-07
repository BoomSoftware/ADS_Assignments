import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tree.BinaryTree;
import tree.BinaryTreeNode;

public class BinaryTreeTest {
    @Test
    void testSizeForOneLevelBinaryTree(){
        BinaryTree binaryTree = createTreeWithOneLevel();
        Assertions.assertEquals(1, binaryTree.size());
    }

    @Test
    void testSizeForThreeLevelBinaryTree(){
        BinaryTree binaryTree = createTreeWithThreeLevels();
        Assertions.assertEquals(6, binaryTree.size());
    }

    @Test
    void testSizeInEmptyTree() {
        BinaryTree binaryTree = new BinaryTree(null);
        Assertions.assertTrue(binaryTree.isEmpty());
        Assertions.assertEquals(0, binaryTree.size());
    }

    @Test
    void testContainElementTrue(){
        BinaryTree binaryTree = createTreeWithThreeLevels();
        Assertions.assertTrue(binaryTree.contains(33));
    }

    @Test
    void testContainElementFalse(){
        BinaryTree binaryTree = createTreeWithThreeLevels();
        Assertions.assertFalse(binaryTree.contains(88));
    }

    @Test
    void testIsEmptyTrue(){
        BinaryTree binaryTree = new BinaryTree(null);
        Assertions.assertTrue(binaryTree.isEmpty());
    }

    @Test
    void testIsEmptyFalse(){
        BinaryTree binaryTree = createTreeWithOneLevel();
        Assertions.assertFalse(binaryTree.isEmpty());
    }

    @Test
    void testGetRoot() {
        BinaryTreeNode root = new BinaryTreeNode(5);
        BinaryTree binaryTree = new BinaryTree(root);

        Assertions.assertEquals(root, binaryTree.getRoot());
    }

    @Test
    void testSetRootInEmptyTree() {
        BinaryTreeNode root = new BinaryTreeNode(5);
        BinaryTree binaryTree = new BinaryTree(null);
        Assertions.assertTrue(binaryTree.isEmpty());
        binaryTree.setRoot(root);
        Assertions.assertEquals(root, binaryTree.getRoot());
    }

    @Test
    void testHeightOfEmptyTree(){
        BinaryTree binaryTree = new BinaryTree(null);
        Assertions.assertTrue(binaryTree.isEmpty());
        Assertions.assertEquals(0, binaryTree.height());
    }

    @Test
    void testHeightOfOneLevelTree(){
        BinaryTree binaryTree = createTreeWithOneLevel();
        Assertions.assertEquals(1, binaryTree.height());
    }

    @Test
    void testHeightOfThreeLevelTree(){
        BinaryTree binaryTree = createTreeWithThreeLevels();
        Assertions.assertEquals(3, binaryTree.height());
    }

    private BinaryTree createTreeWithThreeLevels(){
        BinaryTreeNode root = new BinaryTreeNode(5);
        BinaryTreeNode leftChild = new BinaryTreeNode(23);
        leftChild.addLeftChild(new BinaryTreeNode(33));
        leftChild.addRightChild(new BinaryTreeNode(31));

        BinaryTreeNode rightChild = new BinaryTreeNode(66);
        rightChild.addRightChild(new BinaryTreeNode(57));

        root.addLeftChild(leftChild);
        root.addRightChild(rightChild);

        return new BinaryTree(root);
    }

    private BinaryTree createTreeWithOneLevel(){
        BinaryTreeNode root = new BinaryTreeNode(5);
        return new BinaryTree(root);
    }
}
