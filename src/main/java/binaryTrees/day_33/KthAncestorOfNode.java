package binaryTrees.day_33;

import binaryTrees.BinaryTree;
import binaryTrees.BinaryTreeUtil;
import binaryTrees.Node;

public class KthAncestorOfNode {
    static int kthAncestor = 2;

    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeUtil.buildBinaryTree();
        findKthAncestor(binaryTree.root, 4);
        kthAncestor = 1;
        findKthAncestor(binaryTree.root, 4);
        kthAncestor = 0;
        findKthAncestor(binaryTree.root, 4);
    }

    private static void findKthAncestor(Node root, int nodeData) {
        helper(root, nodeData);
    }

    private static Node helper(Node root, int nodeData) {
        if (root == null) {
            return null;
        }
        Node rv = null;
        if ((root.data == nodeData) ||
                (rv != helper(root.left, nodeData)) ||
                (rv != helper(root.right, nodeData))) {
            if (kthAncestor == 0) {
                System.out.println(root.data);
                return null;
            }
            kthAncestor--;
            return rv != null ? rv : root;
        }
        return null;
    }
}
