package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
        ArrayList<Integer> elements = new ArrayList<>();
        return inOrderRecursive(root, elements);
    }

    public ArrayList<Integer> preOrder() {
        ArrayList<Integer> elements = new ArrayList<>();
        return preOrderRecursive(root, elements);
    }

    public ArrayList<Integer> postOrder() {
        ArrayList<Integer> elements = new ArrayList<>();
        return postOrderRecursive(root, elements);
    }

    public ArrayList<Integer> levelOrder() {
       ArrayList<Integer> elements = new ArrayList<>();
       return levelOrderQueue(root, elements);
    }

    public int height(){
        return heightRecursive(root);
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
        if(node == null || (node.getLeftChild() == null && node.getRightChild() == null)){
            return 0;
        }
        return Math.max(heightRecursive(node.getLeftChild()), heightRecursive(node.getRightChild())) + 1;
    }

    private ArrayList<Integer> preOrderRecursive(BinaryTreeNode node, ArrayList<Integer> elements){
        if(node == null) {
            return null;
        }
        elements.add(node.getElement());
        preOrderRecursive(node.getLeftChild(), elements);
        preOrderRecursive(node.getRightChild(), elements);
        return elements;
    }

    private ArrayList<Integer> postOrderRecursive(BinaryTreeNode node, ArrayList<Integer> elements) {
        if(node == null) {
            return null;
        }
        postOrderRecursive(node.getLeftChild(), elements);
        postOrderRecursive(node.getRightChild(), elements);
        elements.add(node.getElement());
        return elements;
    }

    private ArrayList<Integer> inOrderRecursive(BinaryTreeNode node, ArrayList<Integer> elements){
        if(node == null) {
            return null;
        }
        inOrderRecursive(node.getLeftChild(), elements);
        elements.add(node.getElement());
        inOrderRecursive(node.getRightChild(), elements);
        return elements;
    }

    private ArrayList<Integer> levelOrderQueue(BinaryTreeNode node, ArrayList<Integer> elements){
        if(node == null ) {
            return null;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            BinaryTreeNode currentNode = queue.poll();
            elements.add(currentNode.getElement());

            if(currentNode.getLeftChild() != null) {
                queue.add(currentNode.getLeftChild());
            }

            if(currentNode.getRightChild() != null) {
                queue.add(currentNode.getRightChild());
            }
        }
        return elements;
    }
}
