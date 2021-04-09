import tree.BinarySearchTree;
import tree.BinaryTreeNode;

public class Main {
    public static void main(String[] args) {
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

        BinarySearchTree binarySearchTree = new BinarySearchTree(treeRoot);
        BinaryTreePrint binaryTreePrint = new BinaryTreePrint();
        binaryTreePrint.printTree(binarySearchTree.getRoot());

        System.out.println("\n\nSIZE: " + binarySearchTree.size());
        System.out.println("HEIGHT: " + binarySearchTree.height());
        System.out.println("MIN ELEMENT: " + binarySearchTree.findMin());
        System.out.println("MAX ELEMENT: " + binarySearchTree.findMax());
        System.out.println("PREORDER: " + binarySearchTree.preOrder().toString());
        System.out.println("POSTORDER: " + binarySearchTree.postOrder().toString());
        System.out.println("INORDER: " + binarySearchTree.inOrder().toString());
        System.out.println("LEVELORDER: " + binarySearchTree.levelOrder().toString());
    }
}
