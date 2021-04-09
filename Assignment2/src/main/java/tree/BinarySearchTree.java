package tree;

public class BinarySearchTree extends BinaryTree {


    public BinarySearchTree(BinaryTreeNode root) {
        super(root);
    }

    public void insert(int element){
        insertRecursive(getRoot(), new BinaryTreeNode(element));
    }

    public void removeElement(int element){

    }

    public int findMin(){
        BinaryTreeNode node = getRoot();
        if(node == null){
           return -1;
        }

        while(node.getLeftChild() != null){
            node = node.getLeftChild();
        }
        return node.getElement();
    }

    public int findMax() {
        return 0;
    }

    public void rebalance() {

    }

    private void insertRecursive(BinaryTreeNode node, BinaryTreeNode newNode){
        if(node == null){
            setRoot(newNode);
            return;
        }

        if(node.getElement() < newNode.getElement()){
            if(node.getRightChild() == null){
                node.addRightChild(newNode);
                return;
            }
            insertRecursive(node.getRightChild(), newNode);
        }

        if(node.getElement() > newNode.getElement()){
            if(node.getLeftChild() == null){
                node.addLeftChild(newNode);
                return;
            }
            insertRecursive(node.getLeftChild(), newNode);
        }
    }
}
