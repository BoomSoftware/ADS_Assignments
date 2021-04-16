import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tree.BinarySearchTree;
import tree.BinaryTreeNode;

import java.util.ArrayList;

public class BinarySearchTreeTest {

    private BinarySearchTree emptySearchTree;
    private BinarySearchTree searchTree;
    private BinaryTreeNode treeRoot;
    private BinarySearchTree tree;

    @BeforeEach
    public void prepareSearchTrees() {
        emptySearchTree = new BinarySearchTree(null);
        searchTree = new BinarySearchTree(new BinaryTreeNode(50));

        treeRoot = new BinaryTreeNode(5);
        treeRoot.addLeftChild(new BinaryTreeNode(8));
        treeRoot.addRightChild(new BinaryTreeNode(6));

        treeRoot.getLeftChild().addLeftChild(new BinaryTreeNode(4));
        treeRoot.getLeftChild().addRightChild(new BinaryTreeNode(3));

        treeRoot.getLeftChild().getLeftChild().addLeftChild(new BinaryTreeNode(1));
        treeRoot.getLeftChild().getLeftChild().addRightChild(new BinaryTreeNode(2));

        treeRoot.getRightChild().addLeftChild(new BinaryTreeNode(2));
        treeRoot.getRightChild().addRightChild(new BinaryTreeNode(7));

        tree = new BinarySearchTree(treeRoot);
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
        tree.removeElement(1);
        Assertions.assertFalse(tree.contains(1));
        Assertions.assertNull(treeRoot.getLeftChild().getLeftChild().getLeftChild());
    }

    @Test
    public void removeNodeWithOneChild()
    {
        tree.insert(9);
        tree.removeElement(7);
        Assertions.assertFalse(tree.contains(7));
        Assertions.assertEquals(9, treeRoot.getRightChild().getRightChild().getElement());
        Assertions.assertNull(treeRoot.getRightChild().getRightChild().getRightChild());
    }

    @Test
    public void removeNodeWithTwoChildren()
    {
        Assertions.assertEquals(2, treeRoot.getRightChild().getLeftChild().getElement());
        tree.removeElement(5);
        Assertions.assertFalse(tree.contains(5));
        Assertions.assertEquals(2, treeRoot.getElement());
        Assertions.assertEquals(6, treeRoot.getRightChild().getElement());
        Assertions.assertNull(treeRoot.getRightChild().getLeftChild());
        Assertions.assertEquals(7, treeRoot.getRightChild().getRightChild().getElement());
    }

    @Test
    public void rebalance()
    {
        tree.removeElement(5);
        tree.rebalance();
        ArrayList<Integer> preOrder  = new ArrayList<>();
        preOrder.add(8);
        preOrder.add(4);
        preOrder.add(1);
        preOrder.add(2);
        preOrder.add(2);
        preOrder.add(3);
        preOrder.add(6);
        preOrder.add(7);
        Assertions.assertEquals(preOrder, tree.preOrder());

    }

}
