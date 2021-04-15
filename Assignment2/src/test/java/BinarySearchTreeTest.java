import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tree.BinarySearchTree;
import tree.BinaryTreeNode;

import java.util.ArrayList;

public class BinarySearchTreeTest {

    private BinarySearchTree emptySearchTree;
    private BinarySearchTree searchTree;
    private BinaryTreeNode TreeRoot;
    private BinarySearchTree node;

    @BeforeEach
    public void prepareSearchTrees() {
        emptySearchTree = new BinarySearchTree(null);
        searchTree = new BinarySearchTree(new BinaryTreeNode(50));

        TreeRoot = new BinaryTreeNode(5);
        TreeRoot.addLeftChild(new BinaryTreeNode(8));
        TreeRoot.addRightChild(new BinaryTreeNode(6));

        TreeRoot.getLeftChild().addLeftChild(new BinaryTreeNode(4));
        TreeRoot.getLeftChild().addRightChild(new BinaryTreeNode(3));

        TreeRoot.getLeftChild().getLeftChild().addLeftChild(new BinaryTreeNode(1));
        TreeRoot.getLeftChild().getLeftChild().addRightChild(new BinaryTreeNode(2));

        TreeRoot.getRightChild().addLeftChild(new BinaryTreeNode(2));
        TreeRoot.getRightChild().addRightChild(new BinaryTreeNode(7));

        node = new BinarySearchTree(TreeRoot);
    }
    @Test
    public void insertElementInEmptyTreeTest(){
        int element = 50;
        emptySearchTree.insert(element);
        Assertions.assertEquals(element, emptySearchTree.getRoot().getElement());
    }

    @Test
    public void insertElementBiggerThanRootTest(){
        int element = 60;
        searchTree.insert(element);
        Assertions.assertEquals(element, searchTree.getRoot().getRightChild().getElement());
    }

    @Test
    public void insertElementSmallerThanRootTest(){
        int element = 30;
        searchTree.insert(element);
        Assertions.assertEquals(element, searchTree.getRoot().getLeftChild().getElement());
    }

    @Test
    public void insertElementWhichExistInTreeTest(){
        int element = 50;
        searchTree.insert(element);
        Assertions.assertNull(searchTree.getRoot().getLeftChild());
        Assertions.assertNull(searchTree.getRoot().getRightChild());
    }

    @Test
    public void insertManyElementsTest(){
        int[] elements = {10,1,35,3,4,15,6,7,8,9};
        for (int element : elements) {
            emptySearchTree.insert(element);
        }

        for (int element : elements) {
            Assertions.assertTrue(emptySearchTree.contains(element));
        }
    }

    @Test
    public void minInEmptyTreeTest() {
        Assertions.assertEquals(-1, emptySearchTree.findMin());
    }

    @Test
    public void minInTreeWithOneElementTest() {
        Assertions.assertEquals(50, searchTree.findMin());
    }

    @Test
    public void minInTreeWithManyElements() {
        int[] elements = {9,8,7,6,5,4,3,2,1,86,47,39};
        for (int element : elements) {
            emptySearchTree.insert(element);
        }

        Assertions.assertEquals(1, emptySearchTree.findMin());
    }

    @Test
    public void maxInEmptyTreeTest() {
        Assertions.assertEquals(-1, emptySearchTree.findMax());
    }

    @Test
    public void maxInTreeWithOneElementTest() {
        Assertions.assertEquals(50, searchTree.findMax());
    }

    @Test
    public void maxInTreeWithManyElements() {
        int[] elements = {9,8,7,6,5,4,3,2,1,86,47,39};
        for (int element : elements) {
            emptySearchTree.insert(element);
        }
        Assertions.assertEquals(86, emptySearchTree.findMax());
    }

    @Test
    public void removeLeafNode()
    {
        node.removeElement(1);
        Assertions.assertFalse(node.contains(1));
        Assertions.assertNull(TreeRoot.getLeftChild().getLeftChild().getLeftChild());
    }

    @Test
    public void removeNodeWithOneChild()
    {
        node.insert(9);
        node.removeElement(7);
        Assertions.assertFalse(node.contains(7));
        Assertions.assertEquals(9, TreeRoot.getRightChild().getRightChild().getElement());
        Assertions.assertNull(TreeRoot.getRightChild().getRightChild().getRightChild());
    }

    @Test
    public void removeNodeWithTwoChildren()
    {
        Assertions.assertEquals(2, TreeRoot.getRightChild().getLeftChild().getElement());
        node.removeElement(5);
        Assertions.assertFalse(node.contains(5));
        Assertions.assertEquals(2, TreeRoot.getElement());
        Assertions.assertEquals(6, TreeRoot.getRightChild().getElement());
        Assertions.assertNull(TreeRoot.getRightChild().getLeftChild());
        Assertions.assertEquals(7, TreeRoot.getRightChild().getRightChild().getElement());
    }

    @Test
    public void rebalance()
    {
        node.removeElement(5);
        node.rebalance();
        ArrayList<Integer> preOrder  = new ArrayList<>();
        preOrder.add(8);
        preOrder.add(4);
        preOrder.add(1);
        preOrder.add(2);
        preOrder.add(2);
        preOrder.add(3);
        preOrder.add(6);
        preOrder.add(7);
        Assertions.assertEquals(preOrder, node.preOrder());

    }

}
