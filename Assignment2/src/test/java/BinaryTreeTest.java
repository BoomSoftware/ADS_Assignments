import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tree.BinaryTree;
import tree.BinaryTreeNode;
import java.util.ArrayList;

public class BinaryTreeTest {
    private BinaryTree tree;
    private BinaryTree fullTree;
    private BinaryTree emptyTree;
    private BinaryTree treeWithOneElement;

    private BinaryTreeNode fullTreeRoot;
    private BinaryTreeNode treeRoot;
    private BinaryTreeNode treeWithOneElementRoot;

    private ArrayList<Integer> elements;

    @BeforeEach
    public void prepareTrees()
    {
        elements = new ArrayList<>();

        prepareTree();
        prepareEmptyTree();
        prepareFullTree();
        prepareTreeWithOneElement();
    }


    /*
        Get root from all types of tree
    */

    @Test
    public void getRootOfTreeTest()
    {
        Assertions.assertEquals(treeRoot, tree.getRoot());
    }

    @Test
    public void getRootOfFullTreeTest()
    {
        Assertions.assertEquals(fullTreeRoot, fullTree.getRoot());
    }

    @Test
    public void getRootOfEmptyTreeTest()
    {
        Assertions.assertNull(emptyTree.getRoot());
    }

    @Test
    public void getRootOfTreeWithOneElementTest()
    {
        Assertions.assertEquals(treeWithOneElementRoot, treeWithOneElement.getRoot());
    }


    /*
        Set root for all types of tree
    */

    @Test
    public void setRootTreeTest()
    {
        tree.setRoot(new BinaryTreeNode(1));
        Assertions.assertEquals(1, tree.getRoot().getElement());
    }

    @Test
    public void setRootEmptyTreeTest()
    {
        emptyTree.setRoot(new BinaryTreeNode(1));
        Assertions.assertEquals(1, emptyTree.getRoot().getElement());
    }

    @Test
    public void setRootTreeWithOneElementTest()
    {
        treeWithOneElement.setRoot(new BinaryTreeNode(1));
        Assertions.assertEquals(1, treeWithOneElement.getRoot().getElement());
    }

    @Test
    public void setRootFullTreeTest()
    {
        fullTree.setRoot(new BinaryTreeNode(1));
        Assertions.assertEquals(1, fullTree.getRoot().getElement());
    }


    /*
    Tests for empty methods
    */

    @Test
    public void isEmptyTrueTest()
    {
        Assertions.assertTrue(emptyTree.isEmpty());
    }

    @Test
    public void isEmptyOneElementTest()
    {
        Assertions.assertFalse(treeWithOneElement.isEmpty());
    }

    @Test
    public void isEmptyNormalTreeTest()
    {
        Assertions.assertFalse(tree.isEmpty());
    }


    /*
    Size tests
    */

    @Test
    public void treeSizeTest()
    {
        Assertions.assertEquals(9, tree.size());
    }

    @Test
    public void emptyTreeSizeTest()
    {
        Assertions.assertEquals(0, emptyTree.size());
    }

    @Test
    public void treeWithOneElementSizeTest()
    {
        Assertions.assertEquals(1, treeWithOneElement.size());
    }

    @Test
    public void fullTreeSizeTest()
    {
        Assertions.assertEquals(7, fullTree.size());
    }


    /*
    Contains method tests
    */

    @Test
    public void containsInEmptyTreeTest()
    {
        Assertions.assertFalse(emptyTree.contains(1));
    }

    @Test
    public void containsInOneElementTreeTest()
    {
        Assertions.assertTrue(treeWithOneElement.contains(50));
    }

    @Test
    public void containsInTreeTrueTest()
    {
        Assertions.assertTrue(treeWithOneElement.contains(50));
    }

    @Test
    public void containsInTreeFalseTest()
    {
        Assertions.assertFalse(treeWithOneElement.contains(100));
    }


    /*
    Height method tests
     */

    @Test
    public void heightInTreeTest()
    {
        Assertions.assertEquals(3, tree.height());
    }

    @Test
    public void heightInFullTreeTest()
    {
        Assertions.assertEquals(2, fullTree.height());
    }

    @Test
    public void heightInEmptyTreeTest()
    {
        Assertions.assertEquals(0, emptyTree.height());
    }

    @Test
    public void heightInTreeWithOneElementTest()
    {
        Assertions.assertEquals(0, treeWithOneElement.height());
    }


    /*
    InOrder tests
     */

    @Test
    public void inOrderInTreeTest()
    {
        int[] inOrder = {19, 14, 34, 41, 16, 22, 66, 11, 17};
        for(int element: inOrder){
            elements.add(element);
        }
        Assertions.assertEquals(elements, tree.inOrder());
    }

    @Test
    public void inOrderInEmptyTreeTest()
    {
        Assertions.assertNull(emptyTree.inOrder());
    }

    @Test
    public void inOrderInOneElementTreeTest()
    {
        elements.add(50);
        Assertions.assertEquals(elements, treeWithOneElement.inOrder());
    }


    /*
    PreOrder tests
     */

    @Test
    public void preOrderInTreeTest()
    {
        int[] preOrder = {22, 41, 14, 19, 34, 16, 11, 66, 17};
        for(int element: preOrder){
            elements.add(element);
        }
        Assertions.assertEquals(elements, tree.preOrder());
    }

    @Test
    public void preOrderInEmptyTreeTest()
    {
        Assertions.assertNull(emptyTree.preOrder());
    }

    @Test
    public void preOrderInOneElementTreeTest()
    {
        elements.add(50);
        Assertions.assertEquals(elements, treeWithOneElement.preOrder());
    }


    /*
    PostOrder tests
     */

    @Test
    public void postOrderInTreeTest()
    {
        int[] postOrder = {19, 34, 14, 16, 41, 66, 17, 11, 22};
        for(int element : postOrder){
            elements.add(element);
        }
        Assertions.assertEquals(elements, tree.postOrder());
    }

    @Test
    public void postOrderInEmptyTreeTest()
    {
        Assertions.assertNull(emptyTree.postOrder());
    }

    @Test
    public void postOrderInOneElementTree()
    {
        elements.add(50);
        Assertions.assertEquals(elements, treeWithOneElement.postOrder());
    }


    /*
    LevelOrder tests
     */

    @Test
    public void levelOrderTreeTest()
    {
        int[] levelOrder = {22, 41, 11, 14, 16, 66, 17, 19, 34};
        for(int element : levelOrder){
            elements.add(element);
        }
        Assertions.assertEquals(elements, tree.levelOrder());
    }

    @Test
    public void levelOrderInEmptyTreeTest()
    {
        Assertions.assertNull(emptyTree.levelOrder());
    }

    @Test
    public void levelOrderInOneElementTreeTest()
    {
        elements.add(50);
        Assertions.assertEquals(elements, treeWithOneElement.levelOrder());
    }

    /*
    Setup
     */

    private void prepareTree(){
        treeRoot = new BinaryTreeNode(22);
        treeRoot.addLeftChild(new BinaryTreeNode(41));
        treeRoot.addRightChild(new BinaryTreeNode(11));
        treeRoot.getLeftChild().addLeftChild(new BinaryTreeNode(14));
        treeRoot.getLeftChild().addRightChild(new BinaryTreeNode(16));
        treeRoot.getLeftChild().getLeftChild().addLeftChild(new BinaryTreeNode(19));
        treeRoot.getLeftChild().getLeftChild().addRightChild(new BinaryTreeNode(34));
        treeRoot.getRightChild().addLeftChild(new BinaryTreeNode(66));
        treeRoot.getRightChild().addRightChild(new BinaryTreeNode(17));

        tree = new BinaryTree(treeRoot);
    }

    private void prepareEmptyTree(){
        emptyTree = new BinaryTree(null);
    }

    private void prepareFullTree(){
        fullTreeRoot = new BinaryTreeNode(10);
        fullTreeRoot.addLeftChild(new BinaryTreeNode(2));
        fullTreeRoot.addRightChild(new BinaryTreeNode(8));
        fullTreeRoot.getLeftChild().addLeftChild(new BinaryTreeNode(3));
        fullTreeRoot.getLeftChild().addRightChild(new BinaryTreeNode(6));
        fullTreeRoot.getRightChild().addLeftChild(new BinaryTreeNode(9));
        fullTreeRoot.getRightChild().addRightChild(new BinaryTreeNode(23));

        fullTree = new BinaryTree(fullTreeRoot);
    }

    private void prepareTreeWithOneElement(){
        treeWithOneElementRoot = new BinaryTreeNode(50);
        treeWithOneElement = new BinaryTree(treeWithOneElementRoot);
    }
}
