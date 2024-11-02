package com.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Random rand = new Random();

        System.out.println("10 Nomor Random kali ini : ");
        for (int i = 0; i < 10; i++) {
            int num = rand.nextInt(100);  
            System.out.print(num + " ");
            bst.insert(num);
        }
        System.out.println("\n");


        System.out.println("Tree visualization :");
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
