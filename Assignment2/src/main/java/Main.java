import tree.BinarySearchTree;
import tree.BinaryTreePrint;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree(null);
        binarySearchTree.insert(1);
        binarySearchTree.insert(2);
        binarySearchTree.insert(3);
        binarySearchTree.insert(4);
        binarySearchTree.insert(5);
        binarySearchTree.insert(6);
        binarySearchTree.insert(7);
        binarySearchTree.insert(8);
        binarySearchTree.insert(9);


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

//        binarySearchTree.removeElement(7);
//        binarySearchTree.removeElement(9);
        binarySearchTree.rebalance();

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
