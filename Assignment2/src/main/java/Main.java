import tree.BinarySearchTree;
import tree.BinaryTreeNode;
import tree.BinaryTreePrint;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree(null);
        binarySearchTree.insert(88);
        binarySearchTree.insert(88);
        binarySearchTree.insert(11);
        binarySearchTree.insert(3);
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        binarySearchTree.insert(155);
        binarySearchTree.insert(24);
        binarySearchTree.insert(35);
        binarySearchTree.insert(87);
        binarySearchTree.insert(55);
        binarySearchTree.insert(130);
        binarySearchTree.insert(123);
//

//        BinaryTreeNode treeRoot = new BinaryTreeNode(22);
//        treeRoot.addLeftChild(new BinaryTreeNode(41));
//        treeRoot.addRightChild(new BinaryTreeNode(11));
//        treeRoot.getLeftChild().addLeftChild(new BinaryTreeNode(14));
//        treeRoot.getLeftChild().addRightChild(new BinaryTreeNode(16));
//        treeRoot.getLeftChild().getLeftChild().addLeftChild(new BinaryTreeNode(19));
//        treeRoot.getLeftChild().getLeftChild().addRightChild(new BinaryTreeNode(34));
//        treeRoot.getRightChild().addLeftChild(new BinaryTreeNode(66));
//        treeRoot.getRightChild().addRightChild(new BinaryTreeNode(17));



//        BinarySearchTree binarySearchTree = new BinarySearchTree(treeRoot);


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


        binarySearchTree.removeElement(1);
        binarySearchTree.removeElement(35);
        binarySearchTree.removeElement(11);
        binarySearchTree.removeElement(88);

        binaryTreePrint.printTree(binarySearchTree.getRoot());


    }
}
