import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tree.BinarySearchTree;
import tree.BinaryTreeNode;

public class BinarySearchTreeTest {

    private BinarySearchTree emptySearchTree;
    private BinarySearchTree searchTree;

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


}
