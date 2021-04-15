package tree;

import java.util.ArrayList;

public class BinarySearchTree extends BinaryTree {
    BinaryTreeNode root;

    public BinarySearchTree(BinaryTreeNode root) {
        super(root);
        this.root = root;

    }


    public void insert(int element) {
        insertRecursive(getRoot(), new BinaryTreeNode(element));
    }

    public void removeElement(int element) {
         removeElement(root, element);
    }

    public int findMin() {
        BinaryTreeNode node = getRoot();
        if (node == null) {
            return -1;
        }

        while (node.getLeftChild() != null) {
            node = node.getLeftChild();
        }
        return node.getElement();
    }

    public int findMax() {
        BinaryTreeNode node = getRoot();
        if (node == null) {
            return -1;
        }

        while (node.getRightChild() != null) {
            node = node.getRightChild();
        }
        return node.getElement();
    }


    public void rebalance() {
        int end = inOrder().size() - 1;
        setRoot(rebalance(inOrder(), 0, end));
    }

    private BinaryTreeNode rebalance(ArrayList<Integer> inOrder, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        BinaryTreeNode node = new BinaryTreeNode(inOrder.get(mid));

        node.addLeftChild(rebalance(inOrder, start, mid - 1));

        node.addRightChild(rebalance(inOrder, mid + 1, end));
        return node;
    }
//    public int rebalance(BinaryTreeNode node) {
////        if (node == null) return 0;
////        int h1 = rebalance(node.getLeftChild());
////        int h2 = rebalance(node.getRightChild());
////
////        if (h1 == -1 || h2 == -1) return -1;
////        if (Math.abs(h1 - h2) > 1) return -1;
////
////        if (h1 > h2) return h1 + 1;
////        return h2 + 1;
//    }

    private void insertRecursive(BinaryTreeNode node, BinaryTreeNode newNode) {
        if (node == null) {
            setRoot(newNode);
            return;
        }

        if (node.getElement() < newNode.getElement()) {
            if (node.getRightChild() == null) {
                node.addRightChild(newNode);
                return;
            }
            insertRecursive(node.getRightChild(), newNode);
        }

        if (node.getElement() > newNode.getElement()) {
            if (node.getLeftChild() == null) {
                node.addLeftChild(newNode);
                return;
            }
            insertRecursive(node.getLeftChild(), newNode);
        }
    }

    private BinaryTreeNode removeElement(BinaryTreeNode root, int element) {
        if(root == null)
            return null;
        if(element<root.getElement()) {
            root.addLeftChild(removeElement(root.getLeftChild(), element));
        }else if(element>root.getElement())
        {
            root.addRightChild(removeElement(root.getRightChild(), element));
        }
        else
        {
            if(root.getLeftChild() == null && root.getRightChild() == null) {
                root = null;
            }
            else if(root.getLeftChild() != null && root.getRightChild() != null)
            {
                int successor = findMinForRemove(root.getRightChild());
                root.setElement(successor);

                root.addRightChild(removeElement(root.getRightChild(), successor));
            }
            else if(root.getLeftChild() != null && root.getRightChild() == null)
                root = root.getLeftChild();
            else if(root.getRightChild() != null && root.getLeftChild() == null)
                root = root.getRightChild();
        }
        return root;
    }

    private int findMinForRemove(BinaryTreeNode node){
        if (node == null)
            return Integer.MAX_VALUE;

        int r = node.getElement();
        int lr = findMinForRemove(node.getLeftChild());
        int rr = findMinForRemove(node.getRightChild());

        if (lr < r)
            r = lr;
        if (rr < r)
            r = rr;
        return r;
//        int value = root.getElement();
//        while (root.getLeftChild() != null){
//            value = root.getLeftChild().getElement();
//            root = root.getLeftChild();
//        }
//        return value;
    }
}



















