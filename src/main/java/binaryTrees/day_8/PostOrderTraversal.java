package binaryTrees.day_8;

import binaryTrees.BinaryTree;
import binaryTrees.BinaryTreeUtil;
import binaryTrees.Node;

public class PostOrderTraversal {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeUtil.buildBinaryTree();
        postOrderRecursionTraversal(binaryTree.root);
    }

    private static void postOrderRecursionTraversal(Node root) {
        if (root == null) {
            return;
        }
        postOrderRecursionTraversal(root.left);
        postOrderRecursionTraversal(root.right);
        System.out.print(root.data + " ");
    }
}
