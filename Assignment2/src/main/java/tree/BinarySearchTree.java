package tree;

import java.util.ArrayList;

public class BinarySearchTree extends BinaryTree {
    BinaryTreeNode root;

    public BinarySearchTree(BinaryTreeNode root) {
        super(root);
    }


    public void insert(int element) {
        insertRecursive(getRoot(), new BinaryTreeNode(element));
    }

    public BinaryTreeNode removeElement(int element) {
        return this.root = removeRecursive(this.root, element);
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


    public void rebalance()
    {
        int end = inOrder().size() - 1;
        setRoot(rebalance(inOrder(), 0, end));
    }
    private BinaryTreeNode rebalance(ArrayList<Integer> inOrder, int start, int end)
    {
        if(start > end) {
            return null;
        }
        int mid = (start + end)/2;
        BinaryTreeNode node = new BinaryTreeNode(inOrder.get(mid));

        node.addLeftChild(rebalance(inOrder, start, mid-1));

        node.addRightChild(rebalance(inOrder, mid+1, end));
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

    private BinaryTreeNode removeRecursive(BinaryTreeNode root, int element) {
        if (root == null) {
            return null;
        } else if (element < root.getElement()) {
            root.addLeftChild(removeRecursive(root.getLeftChild(), element));
        } else if (element > root.getElement()) {
            root.addRightChild(removeRecursive(root.getRightChild(), element));
        } else {
            if (root.getLeftChild() == null && root.getRightChild() == null) {
                root = null;
            }
            else if(root.getLeftChild() != null && root.getRightChild() != null)
            {
                int successor = findMin(root.getRightChild());
                root.setElement(successor);

                root.addRightChild(removeRecursive(root.getRightChild(), successor));
            }
            else if(root.getLeftChild() != null && root.getRightChild() == null)
                root = root.getLeftChild();
            else if(root.getRightChild() != null && root.getLeftChild() == null)
                root = root.getRightChild();

        }
        return root;

    }
}

//            } else if (root.getLeftChild() == null || root.getRightChild() == null) {
//                root = root.getLeftChild() == null ? root.getRightChild() : root.getLeftChild();
//            } else {
//                BinaryTreeNode parent = (findMax(root.getLeftChild()));
//                int temp = parent.getElement();
//                parent.getElement() = root.getElement();
//                root.getElement() = temp;
//                root.getLeftChild() = removeRecursive(root.getLeftChild(), parent.getElement());
//            }

















