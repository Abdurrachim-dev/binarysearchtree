package com.example;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        System.out.println("10 Nomor Random kali ini : ");
        bst.insert(12);
        bst.insert(1);
        bst.insert(7);
        bst.insert(9);
        bst.insert(5);
        bst.insert(3);
        bst.insert(11);
        bst.insert(10);
        bst.insert(4);
        bst.insert(6);
        System.out.println("\n");


        System.out.println("Tree visualization :");
        bst.printTreePretty();

        System.out.println("root dihapus : " + bst.remove(9));

        bst.printTreePretty();

        
        long startTime = System.nanoTime();
        System.out.print("Inorder Traversal: ");
        bst.inorder(bst.root);
        long endTime = System.nanoTime();
        System.out.printf("\nTime taken for Inorder Traversal: %.6f seconds\n\n", (endTime - startTime) / 1_000_000_000.0);

        
        startTime = System.nanoTime();
        System.out.print("Preorder Traversal: ");
        bst.preorder(bst.root);
        endTime = System.nanoTime();
        System.out.printf("\nTime taken for Preorder Traversal: %.6f seconds\n\n", (endTime - startTime) / 1_000_000_000.0);

        
        startTime = System.nanoTime();
        System.out.print("Postorder Traversal: ");
        bst.postorder(bst.root);
        endTime = System.nanoTime();
        System.out.printf("\nTime taken for Postorder Traversal: %.6f seconds\n", (endTime - startTime) / 1_000_000_000.0);
    }
}
