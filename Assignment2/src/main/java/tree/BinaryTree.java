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
        return false;
    }

    public int size(){
        return 0;
    }

    public boolean contains(int element) {
        return false;
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
        return 0;
    }
}
