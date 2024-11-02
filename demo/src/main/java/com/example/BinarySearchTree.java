    // package com.example;

    // public class BinarySearchTree {
    //     Node root;

    //     BinarySearchTree() {
    //         root = null;
    //     }

    //     public void insert(int key) {
    //         root = insertRec(root, key);
    //     }

    //     private Node insertRec(Node root, int key) {
    //         if (root == null) {
    //             root = new Node(key);
    //             return root;
    //         }
    //         if (key < root.key) {
    //                 root.left = insertRec(root.left, key);
    //         }else if (key > root.key) {
    //             root.right = insertRec(root.right, key);

    //         }
    //         return root;
    //     }
        
    //     public void inorder(Node node) {
    //         if (node != null) {
    //             inorder(node.left);
    //             System.out.print(node.key + " ");
    //             inorder(node.right);
    //         }
    //     }

    //     public void preorder(Node node) {
    //         if (node != null) {
    //             System.out.print(node.key + " ");
    //             preorder(node.left);
    //             preorder(node.right);
    //         }
    //     }
    //     public void postorder(Node node) {
    //         if (node != null) {
    //             postorder(node.left);
    //             postorder(node.right);
    //             System.out.print(node.key + " ");

    //         }
    //     }
    // }
    package com.example;

    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.List;
    
    public class BinarySearchTree {
        Node root;
    
        BinarySearchTree() {
            root = null;
        }
    
        public void insert(int key) {
            root = insertRec(root, key);
        }
    
        private Node insertRec(Node root, int key) {
            if (root == null) {
                root = new Node(key);
                return root;
            }
            if (key < root.key) {
                root.left = insertRec(root.left, key);
            } else if (key > root.key) {
                root.right = insertRec(root.right, key);
            }
            return root;
        }
    
        public void inorder(Node node) {
            // int count = 0;
            if (node != null) {
                inorder(node.left);
                System.out.print(node.key + " ");
                inorder(node.right);
            }
            // count++;
            // System.out.println("\njumlah hitungan" + count);
        }
    
        public void preorder(Node node) {
            if (node != null) {
                System.out.print(node.key + " ");
                preorder(node.left);
                preorder(node.right);
            }
        }
    
        public void postorder(Node node) {
            if (node != null) {
                postorder(node.left);
                postorder(node.right);
                System.out.print(node.key + " ");
            }
        }
    
        // Pretty print functionality
        public void printTreePretty() {
            int maxLevel = maxDepth(root); // Calculate the maximum depth of the tree
            printNodeInternal(Collections.singletonList(root), 1, maxLevel);
        }
    
        private void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
            if (nodes.isEmpty() || isAllElementsNull(nodes)) return;
    
            int floor = maxLevel - level;
            int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
            int firstSpaces = (int) Math.pow(2, (floor)) - 1;
            int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;
    
            printWhitespaces(firstSpaces);
    
            List<Node> newNodes = new ArrayList<>();
            for (Node node : nodes) {
                if (node != null) {
                    System.out.print(node.key);
                    newNodes.add(node.left);
                    newNodes.add(node.right);
                } else {
                    System.out.print(" ");
                    newNodes.add(null);
                    newNodes.add(null);
                }
                printWhitespaces(betweenSpaces);
            }
            System.out.println();
    
            for (int i = 1; i <= edgeLines; i++) {
                for (Node node : nodes) {
                    printWhitespaces(firstSpaces - i);
                    if (node == null) {
                        printWhitespaces(edgeLines + edgeLines + i + 1);
                        continue;
                    }
    
                    if (node.left != null) System.out.print("/");
                    else printWhitespaces(1);
    
                    printWhitespaces(i + i - 1);
    
                    if (node.right != null) System.out.print("\\");
                    else printWhitespaces(1);
    
                    printWhitespaces(edgeLines + edgeLines - i);
                }
                System.out.println();
            }
            printNodeInternal(newNodes, level + 1, maxLevel);
        }
    
        private void printWhitespaces(int count) {
            for (int i = 0; i < count; i++) System.out.print(" ");
        }
    
        private int maxDepth(Node node) {
            if (node == null) return 0;
            return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
        }
    
        private boolean isAllElementsNull(List<Node> list) {
            for (Object object : list) {
                if (object != null) return false;
            }
            return true;
        }

        public Node find(int key) {
            return findRec(root, key);
        }
        
        private Node findRec(Node root, int key) {
            if (root == null || root.key == key) {
                return root; 
            }
        
            if (key < root.key) {
                return findRec(root.left, key);
            }
        
            return findRec(root.right, key);
        }

        public boolean remove(int key) {
            root = removeRec(root, key);
            return (root != null);

        }

        private Node removeRec(Node root, int key) {
            if (root == null) {
                return root;
            } 

            if (key < root.key) {
                root.left = removeRec(root.left, key);
            }else if (key > root.key) {
                root.right = removeRec(root.right, key);
            }else {
                if (root.left == null && root.right == null) return null;

               
                if (root.left == null) return root.right;
                if (root.right == null) return root.left;
        
                
                root.key = minValue(root.right); 
                root.right = removeRec(root.right, root.key); 
            }
            return root;
            }

            private int minValue(Node root) {
                int minVal = root.key;
                while (root.left != null) {
                    minVal = root.left.key;
                    root = root.left;
                }
                return minVal;
            }

        }

    
        
        


