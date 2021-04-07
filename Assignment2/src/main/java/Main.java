import tree.BinaryTree;
import tree.BinaryTreeNode;

public class Main {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(5);
        BinaryTreeNode leftChild = new BinaryTreeNode(23);
        leftChild.addLeftChild(new BinaryTreeNode(33));
        leftChild.addRightChild(new BinaryTreeNode(31));

        BinaryTreeNode rightChild = new BinaryTreeNode(66);
        rightChild.addLeftChild(new BinaryTreeNode(55));
        rightChild.addRightChild(new BinaryTreeNode(57));

        root.addLeftChild(leftChild);
        root.addRightChild(rightChild);

        BinaryTree binaryTree = new BinaryTree(root);

        BinaryTreePrint binaryTreePrint = new BinaryTreePrint();
        binaryTreePrint.printTree(root);

        System.out.println("\nSIZE: " + binaryTree.size());
        System.out.println("HEIGHT: " + binaryTree.height());
    }
}
