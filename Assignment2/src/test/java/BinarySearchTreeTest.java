import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tree.BinarySearchTree;
import tree.BinaryTreeNode;

import java.util.ArrayList;

public class BinarySearchTreeTest {

    private BinarySearchTree emptySearchTree;
    private BinarySearchTree searchTree;
    private BinaryTreeNode root;

    @BeforeEach
    public void prepareSearchTrees() {
        emptySearchTree = new BinarySearchTree(null);
        searchTree = new BinarySearchTree(new BinaryTreeNode(50));
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
        searchTree.removeElement(1);
        Assertions.assertFalse(searchTree.contains(1));
        Assertions.assertNull(root.getLeftChild().getLeftChild().getLeftChild());
    }

    @Test
    public void removeNodeWithOneChild()
    {
        searchTree.insert(7);
        searchTree.removeElement(6);
        Assertions.assertFalse(searchTree.contains(6));
        Assertions.assertEquals(7, root.getRightChild().getRightChild().getElement());
        Assertions.assertNull(root.getRightChild().getRightChild().getRightChild());
    }

    @Test
    public void removeNodeWithTwoChildren()
    {
        Assertions.assertEquals(5, root.getRightChild().getLeftChild().getElement());
        searchTree.removeElement(4);
        Assertions.assertFalse(searchTree.contains(4));
        Assertions.assertEquals(5, root.getElement());
        Assertions.assertEquals(6, root.getRightChild().getElement());
        Assertions.assertNull(root.getRightChild().getLeftChild());
        Assertions.assertEquals(7, root.getRightChild().getRightChild().getElement());
    }

    @Test
    public void rebalance()
    {
        searchTree.removeElement(5);
        searchTree.rebalance();
        ArrayList<Integer> preOrder  = new ArrayList<>();
        preOrder.add(3);
        preOrder.add(2);
        preOrder.add(1);
        preOrder.add(2);
        preOrder.add(6);
        preOrder.add(4);
        preOrder.add(7);
        preOrder.add(8);
        Assertions.assertEquals(preOrder, searchTree.preOrder());

    }

}
