package binaryTrees.day_18;

import binaryTrees.BinaryTree;
import binaryTrees.BinaryTreeUtil;
import binaryTrees.Node;

public class BinaryTreeToDoublyLinkedList {

    private static Node head = null;
    private static Node prev = null;

    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeUtil.buildBinaryTree();
        covertToDoublyLinkedList(binaryTree.root);
        System.out.println(head);
    }

    private static void covertToDoublyLinkedList(Node root) {
        if (root == null) {
            return;
        }
        covertToDoublyLinkedList(root.left);
        if (head == null) {
            head = root;
            prev = root;
        } else {
            prev.right = root;
            root.left = prev;
            prev = root;
        }
        covertToDoublyLinkedList(root.right);
    }
}
