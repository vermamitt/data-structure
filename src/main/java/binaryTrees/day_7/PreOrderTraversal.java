package binaryTrees.day_7;

import binaryTrees.BinaryTree;
import binaryTrees.BinaryTreeUtil;
import binaryTrees.Node;

public class PreOrderTraversal {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeUtil.buildBinaryTree();
        preOrderRecursionTraversal(binaryTree.root);
    }

    private static void preOrderRecursionTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderRecursionTraversal(root.left);
        preOrderRecursionTraversal(root.right);
    }
}
