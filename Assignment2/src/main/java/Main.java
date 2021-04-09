import tree.BinarySearchTree;
import tree.BinaryTree;
import tree.BinaryTreeNode;

public class Main {
    public static void main(String[] args) {
//        BinaryTreeNode root = new BinaryTreeNode(105);
//        BinaryTreeNode leftChild = new BinaryTreeNode(23);
//        BinaryTreeNode leftRightChild = new BinaryTreeNode(43);
//        BinaryTreeNode leftLeftChild = new BinaryTreeNode(43);
//
//        leftLeftChild.addLeftChild(new BinaryTreeNode(100));
//
//        leftRightChild.addLeftChild(new BinaryTreeNode(93));
//        leftRightChild.addRightChild(new BinaryTreeNode(98));
//
//        leftChild.addLeftChild(new BinaryTreeNode(33));
//        leftChild.addRightChild(leftRightChild);
//
//        BinaryTreeNode rightChild = new BinaryTreeNode(66);
//        rightChild.addLeftChild(new BinaryTreeNode(55));
//        rightChild.addRightChild(leftLeftChild);
//
//        root.addLeftChild(leftChild);
//        root.addRightChild(rightChild);
//
//        BinarySearchTree binaryTree = new BinarySearchTree(null);
//        binaryTree.insert(88);
//        binaryTree.insert(88);
//        binaryTree.insert(11);
//        binaryTree.insert(3);
//        binaryTree.insert(2);
//        binaryTree.insert(1);
//        binaryTree.insert(155);
//        binaryTree.insert(35);
//        binaryTree.insert(87);
//        binaryTree.insert(55);
//        binaryTree.insert(130);
//        binaryTree.insert(123);
//


        BinaryTreeNode treeRoot = new BinaryTreeNode(22);
        treeRoot.addLeftChild(new BinaryTreeNode(41));
        treeRoot.addRightChild(new BinaryTreeNode(11));
        treeRoot.getLeftChild().addLeftChild(new BinaryTreeNode(14));
        treeRoot.getLeftChild().addRightChild(new BinaryTreeNode(16));
        treeRoot.getLeftChild().getLeftChild().addLeftChild(new BinaryTreeNode(19));
        treeRoot.getLeftChild().getLeftChild().addRightChild(new BinaryTreeNode(34));
        treeRoot.getRightChild().addLeftChild(new BinaryTreeNode(66));
        treeRoot.getRightChild().addRightChild(new BinaryTreeNode(17));

        BinaryTree binaryTree = new BinaryTree(treeRoot);

        BinaryTreePrint binaryTreePrint = new BinaryTreePrint();
        binaryTreePrint.printTree(binaryTree.getRoot());

        System.out.println("\nSIZE: " + binaryTree.size());
        System.out.println("HEIGHT: " + binaryTree.height());
//        System.out.println("MIN ELEMENT: " + binaryTree.findMin());
        System.out.println("PREORDER: " + binaryTree.preOrder().toString());
        System.out.println("POSTORDER: " + binaryTree.postOrder().toString());
        System.out.println("INORDER: " + binaryTree.inOrder().toString());
    }
}
