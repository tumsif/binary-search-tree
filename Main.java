public class Main {
    public static void main(String[] args){

        BinTree root = new BinTree(7);
        root.setLeftChild(new BinTree(3));
        root.setRightChild(new BinTree(13));

        BinTree left = root.getLeftChild();
        BinTree right = root.getRightChild();

        left.setLeftChild(new BinTree(2));
        left.setRightChild(new BinTree(5));

        right.setLeftChild(new BinTree(11));
        right.setRightChild(new BinTree(17));

        // root.preOrderTraverse(root);
        // System.out.println("\n");
        // root.inOrderTraversal(root);
        // System.out.println("\n");
        // root.postOrderTraversal(root);

        /**
         * It is observed that a inorder traversal of a / binary search tree returns a sorted list
         */


        /**
         * Copying a tree
         */
        System.out.println("\nIn order traversal of the copy of a binary search tree");
        BinTree copy = BinTree.copyTree(root);
        copy.inOrderTraversal(copy);
        System.out.println();
        
        BinTree searchNode = BinTree.find(2, root);

        if(searchNode == null){
            System.out.println("Search returns null");
        }
        else System.out.println(searchNode.getKey());

        System.out.println();
        System.out.println("The minimum value in the tree is " + BinTree.min(root).getKey());
        System.out.println("The maximum value in the tree is " + BinTree.max(root).getKey());

        System.out.println();
        System.out.println("Adding a value to the tree");

        BinTree newTree = new BinTree(12);
        System.out.println("Added " + newTree.add(5, newTree).getKey() + " to the tree");
        System.out.println("Added " + newTree.add(18, newTree).getKey() + " to the tree");
        System.out.println("Added " + newTree.add(2, newTree).getKey() + " to the tree");
        System.out.println("Added " + newTree.add(9, newTree).getKey() + " to the tree");
        System.out.println("Added " + newTree.add(15, newTree).getKey() + " to the tree");
        System.out.println("Added " + newTree.add(19, newTree).getKey() + " to the tree");
        System.out.println("Added " + newTree.add(13, newTree).getKey() + " to the tree");
        System.out.println("Added " + newTree.add(17, newTree).getKey() + " to the tree");
        double startTime, endTime;

        System.out.println("\nThe in order traversal of the resulting tree is");
        startTime = System.nanoTime();
        BinTree.inOrderTraversal(newTree);
        endTime = System.nanoTime();
        System.out.println("The system took " + (endTime - startTime) + " ns");
        System.out.println("\nThe post order traversal of the resulting tree is");
        BinTree.postOrderTraversal(newTree);
        System.out.println("\nThe pre order traversal of the resulting tree is");
        BinTree.preOrderTraverse(newTree);

        System.out.println();
        System.out.println("\nDeleting a node from a tree");
        startTime = System.nanoTime();
        newTree = BinTree.remove(18, newTree);
        endTime = System.nanoTime();

        System.out.println("\nThe in order traversal of the resulting tree after deleting which took " + (endTime-startTime) + " ns");
        BinTree.inOrderTraversal(newTree);

        System.out.println();
        System.out.println(Main.fact(5));

        System.out.println("Converting a number to another base");
        System.out.print("102 to base 2 ");
        Main.convertToBase(102, 2);
        System.out.println();

        System.out.print("102 to base 9 ");
        Main.convertToBase(102, 9);
        System.out.println();

        System.out.print("678 to base 9 ");
        Main.convertToBase(678, 9);
        System.out.println();
    }

    public static long fact(int n){
        if(n <= 1) return 1;
        else return n * fact(n - 1);
    }

    public static void convertToBase(int n, int base){
        if(n >= base)
        {
            convertToBase(n / base, base);
        }
        System.out.print(n % base);
    }
}