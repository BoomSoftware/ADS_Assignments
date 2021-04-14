package tree;

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

    public int rebalance(BinaryTreeNode node) {
        if (node == null) return 0;
        int h1 = rebalance(node.getLeftChild());
        int h2 = rebalance(node.getRightChild());

        if (h1 == -1 || h2 == -1) return -1;
        if (Math.abs(h1 - h2) > 1) return -1;

        if (h1 > h2) return h1 + 1;
        return h2 + 1;
    }

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
            root.getLeftChild() = removeRecursive(root.getLeftChild(), element);
        } else if (element > root.getElement()) {
            root.getRightChild() = removeRecursive(root.getRightChild(), element);
        } else {
            if (root.getLeftChild() == null && root.getRightChild() == null) {
                root = null;
            } else if (root.getLeftChild() == null || root.getRightChild() == null) {
                root = root.getLeftChild() == null ? root.getRightChild() : root.getLeftChild();
            } else {
                BinaryTreeNode parent = root.getLeftChild(findMax());
                int temp = parent.getElement();
                parent.getElement() = root.getElement();
                root.getElement() = temp;
                root.getLeftChild() = removeRecursive(root.getLeftChild(), parent.getElement());
            }

        }
        return root;

    }
}
















//        Node parent = null;
//        Node curr = root;
//        while (curr != null && curr.data != key) {
//            parent = curr;
//            if (key < curr.data) {
//                curr = curr.left;
//            } else {
//                curr = curr.right;
//            }
//
//            if (curr == null) {
//                return root;
//            }
//            // Case 1: node to be deleted has no children, it is a leaf node
//            if (curr.left == null && curr.right == null) {
//                // if the node to be deleted is not a root node, then set its
//                // parent left/right child to null
//                if (curr != root) {
//                    if (parent.left == curr) {
//                        parent.left = null;
//                    } else {
//                        parent.right = null;
//                    }
//                }
//                // if the tree has only a root node, set it to null
//                else {
//                    root = null;
//                }
//            }
//
//            // Case 2: node to be deleted has two children
//            else if (curr.left != null && curr.right != null) {
//                // find its inorder successor node
//                Node successor = findMin(curr.right);
//
//                // store successor value
//                int val = successor.data;

                // recursively delete the successor. Note that the successor
                // will have at most one child (right child)
              //  removeRecursive(root, successor.data);
//
//                // copy value of the successor to the current node
//                curr.data = val;
//            }
//
//            // Case 3: node to be deleted has only one child
//            else {
//                // choose a child node
//                Node child = (curr.left != null) ? curr.left : curr.right;
//
//                // if the node to be deleted is not a root node, set its parent
//                // to its child
//                if (curr != root) {
//                    if (curr == parent.left) {
//                        parent.left = child;
//                    } else {
//                        parent.right = child;
//                    }
//                }
//
//                // if the node to be deleted is a root node, then set the root to the child
//                else {
//                    root = child;
//                }
//            }
//            return root;
//        }
//    }
//




//        if (node == null) {
//            return;
//        }
//
//        if (element.getElement() < node.getElement())
//            removeRecursive(node.getLeftChild(), element);
//        else if (element.getElement() > node.getElement())
//            removeRecursive(node.getRightChild(), element);
//
//        else {
//            if (node.getLeftChild() == null)
//                 node.getRightChild();
//            else if (node.getRightChild() == null)
//                 node.getLeftChild();
//
//            findMin(node.getRightChild());




//    Node deleteRec(Node root, int key)
//    {
//        /* Base Case: If the tree is empty */
//        if (root == null)
//            return root;
//
//        /* Otherwise, recur down the tree */
//        if (key < root.key)
//            root.left = deleteRec(root.left, key);
//        else if (key > root.key)
//            root.right = deleteRec(root.right, key);
//
//            // if key is same as root's
//            // key, then This is the
//            // node to be deleted
//        else {
//            // node with only one child or no child
//            if (root.left == null)
//                return root.right;
//            else if (root.right == null)
//                return root.left;
//
//            // node with two children: Get the inorder
//            // successor (smallest in the right subtree)
//            root.key = minValue(root.right);
//
//            // Delete the inorder successor
//            root.right = deleteRec(root.right, root.key);
//        }
//
//        return root;
//    }