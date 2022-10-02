package binarySearchTree.day_1;

import binaryTrees.Node;

public class SearchElementInBST {
    public static void main(String[] args) {
        Node node = search(buildBst(), 7);
        if (node == null) {
            System.out.println("Element is not present in BST");
        } else {
            System.out.println("Found Element " + node.data + " in BST");
        }
    }

    private static Node search(Node node, int key) {
        if (node == null || node.data == key) {
            return node;
        }
        if (node.data > key) {
            return search(node.left, key);
        }
        return search(node.right, key);
    }

    private static Node buildBst() {
        Node root = new Node(8);
        root.left = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        root.right = new Node(10);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        return root;
    }
}
