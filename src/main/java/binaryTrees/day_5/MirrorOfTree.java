package binaryTrees.day_5;

import binaryTrees.BinaryTree;
import binaryTrees.Node;

import static binaryTrees.BinaryTreeUtil.buildBinaryTree;

public class MirrorOfTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = buildBinaryTree();
        inOrderTraversal(binaryTree.root);
        mirrorOfTree(binaryTree.root);
        System.out.println();
        inOrderTraversal(binaryTree.root);
    }

    private static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data);
        System.out.print(" ");
        inOrderTraversal(root.right);
    }

    private static Node mirrorOfTree(Node root) {
        if (root == null) {
            return null;
        }
        Node left = mirrorOfTree(root.left);
        Node right = mirrorOfTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }
}
