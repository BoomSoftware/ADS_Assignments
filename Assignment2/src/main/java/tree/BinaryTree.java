package tree;

import java.util.ArrayList;

public class BinaryTree {

    private BinaryTreeNode root;

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root){
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return sizeRecursive(root);
    }

    public boolean contains(int element) {
        return containsRecursive(root, element);
    }

    public ArrayList<Integer> inOrder(){
        return null;
    }

    public ArrayList<Integer> postOrder() {
        return null;
    }

    public ArrayList<Integer> levelOrder() {
        return null;
    }

    public int height(){
        if(root == null){
            return 0;
        }
        int leftHigh = heightRecursive(root.getLeftChild());
        int rightHigh = heightRecursive(root.getRightChild());

        if(leftHigh > rightHigh){
            return leftHigh + 1;
        }
        return rightHigh + 1;
    }

    private int sizeRecursive(BinaryTreeNode node){
        if(node == null) {
            return 0;
        }
        return sizeRecursive(node.getLeftChild()) + sizeRecursive(node.getRightChild()) + 1;
    }

    private boolean containsRecursive(BinaryTreeNode node, int element) {
        if(node == null){
            return false;
        }
        if(node.getElement() == element) {
            return true;
        }
        return containsRecursive(node.getLeftChild(), element) || containsRecursive(node.getRightChild(), element);
    }

    private int heightRecursive(BinaryTreeNode node){
        if(node == null){
            return 0;
        }
        return sizeRecursive(node.getLeftChild()) + 1;
    }
}
