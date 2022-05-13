package binaryTrees.day_6;

import binaryTrees.BinaryTree;
import binaryTrees.BinaryTreeUtil;
import binaryTrees.Node;

public class InorderTraversal {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeUtil.buildBinaryTree();
        inOrderRecursionTraversal(binaryTree.root);
    }

    private static void inOrderRecursionTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderRecursionTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderRecursionTraversal(root.right);
    }
}