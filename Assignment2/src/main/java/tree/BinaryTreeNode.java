package tree;

public class BinaryTreeNode {

    private int element;
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;

    public BinaryTreeNode(int element){
        this.element = element;
    }

    public void setElement(int element){
        this.element = element;
    }

    public int getElement() {
        return element;
    }

    public void addLeftChild(BinaryTreeNode node){
        this.leftChild = node;
    }

    public void addRightChild(BinaryTreeNode node) {
        this.rightChild = node;
    }

    public BinaryTreeNode getLeftChild() {
        if(leftChild == null) {
            return null;
        }
        return leftChild;
    }

    public BinaryTreeNode getRightChild() {
        if(rightChild == null) {
            return null;
        }
        return rightChild;
    }
}
