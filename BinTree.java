public class BinTree {
    /**
     * A tree is a data structure that consists of elements called nodes, joined together using edges
     * The nodes without a child are called leafs
     * The node at the top of the tree is called a root, it is the entry point of the tree
     * 
     * Binary tree is a tree with at most 2 children. or 0.
     * 
     * A binary search tree is a special type of tree of which the nodes at the left side of any node have keys that are less than its key. 
     * And the nodes at the right of it have keys with values greater that its key.
     * 
     * By making a tree a binary search tree we can perform different operations on it like search
     * insert, delete and update easily.
     */

    private Integer key;
    private BinTree leftChild;
    private BinTree rightChild;

    BinTree(int key){
        this.key = key;
        this.leftChild = null;
        this.rightChild = null;
    }

    BinTree(Integer key, BinTree left, BinTree right){
        this.key = key;
        this.leftChild = left;
        this.rightChild = right;
    }

    public BinTree getLeftChild(){
        return this.leftChild;
    }

    public void setLeftChild(BinTree leftChild){
        this.leftChild = leftChild;
    }

    public BinTree getRightChild(){
        return this.rightChild;
    }

    public void setRightChild(BinTree rightChild){
        this.rightChild = rightChild;
    }

    public Integer getKey(){
        return this.key;
    }

    public void setKey(Integer key){
        this.key = key;
    }

    public static void preOrderTraverse(BinTree bt){
        /**
         * Preorder traverse goes in order root-left-right
         */
        if(bt == null) return;
        System.out.println(bt.getKey());
        preOrderTraverse(bt.getLeftChild());
        preOrderTraverse(bt.getRightChild());
    }

    public static void inOrderTraversal(BinTree bt){
        /**
         * In order traversal starts with left-root-right
         */

        if(bt == null) return;
        inOrderTraversal(bt.getLeftChild());
        System.out.println(bt.getKey());
        inOrderTraversal(bt.getRightChild());
    }

    public static void postOrderTraversal(BinTree bt){
        /**
         * left-right-root
         */
        if(bt == null) return;
        postOrderTraversal(bt.getLeftChild());
        postOrderTraversal(bt.getRightChild());
        System.out.println(bt.getKey());
    }

    public static BinTree copyTree(BinTree bt){
        /**
         * Return a copy of a tree
         */
        if(bt == null) return null; // cannot return void must return null
        BinTree left = copyTree(bt.getLeftChild());
        BinTree right = copyTree(bt.getRightChild());
        return new BinTree(bt.getKey(), left, right);
    }

    public static BinTree find(Comparable<Integer> key, BinTree bst){
        /**
         * Find a key and return its node if not found return null
         */

        if(bst == null) return null;

        else if(key.compareTo(bst.getKey()) <= -1)
            // if the value is less than the key of that node
            return find(key, bst.getLeftChild());

        else if(key.compareTo(bst.getKey()) >= 1)
            // if the value is greater than the key of that node go to right
            return find(key, bst.getRightChild());

        else return bst;
    }

    public static BinTree min(BinTree bst){
        /**
         * Returns a node with the minimum value/key in the tree
         * Goes as far left as possible
         */
        if (bst == null) return null;
        if (bst.getLeftChild() != null) return min(bst.getLeftChild());
        return bst;
    }

    public static BinTree max(BinTree bst){
        /**
         * Returns a node with the maximum value/key in the tree
         * Goes as far right as possible
         */
        if (bst == null) return null;
        if (bst.getRightChild() != null) return max(bst.getRightChild());
        return bst;
    }

    public BinTree add(Integer key, BinTree bt){
        /**
         * Adds a node to the tree.
         * Algorithm:
         * Proceed down the tree as if it is finding it.
         * When found do nothing. As it is already there
         * If not found insert to the last spot on the path traversed
         */
        if(bt == null) return new BinTree(key);

        if (key.compareTo(bt.getKey()) > 0){
            if(bt.getRightChild() == null){
                BinTree addedNode = new BinTree(key);
                bt.setRightChild(addedNode);
                return addedNode;
            }
            return add(key, bt.getRightChild());
        }

        if (key.compareTo(bt.getKey()) < 0) {
            if(bt.getLeftChild() == null){
                BinTree addedNode = new BinTree(key);
                bt.setLeftChild(addedNode);
                return addedNode;
            }
            return add(key, bt.getLeftChild());
        }
        return bt;
    }

    public static BinTree remove(Integer key, BinTree bt){
        /**
         * deletes a binary tree and returns a new tree with the deleted node gone
         * 
         * There are three cases
         * a) If a node is a leaf it is deleted immediately
         * b) If a Node has one child - replace it with the child
         * c) If a node has two children
         * - Find the succesor by finding the samllest node in the right subtree.
         * - Replace the nodes value with the successor value and delete the successor.
         */

        if (bt == null) return null;

        if(key.compareTo(bt.getKey()) < 0){
            bt.setLeftChild(remove(key, bt.getLeftChild()));
        }

        else if(key.compareTo(bt.getKey()) > 0){
            bt.setRightChild(remove(key, bt.getRightChild()));
        }

        else {
            // Loop invariant to the recursion of delete.
            // The recursion break when the element that needs to be deleted is found. i.e comparison is 0

            // Case 1: Node is a leaf
            if(bt.getLeftChild() == null && bt.getRightChild() == null){
                return null;
            }

            // Case 2a: Node has one child (right)
            if(bt.getLeftChild() == null){
                return bt.getRightChild();
            }

            // Case 2b: Node has one child (left)
            if(bt.getRightChild() == null){
                return bt.getLeftChild();
            }

            // Case 3: Two children i.e right and left are not null
            Integer minValue = min(bt.getRightChild()).getKey();
            bt.setKey(minValue);
            bt.setRightChild(remove(minValue, bt.getRightChild()));
        }
        return bt;
    }
}