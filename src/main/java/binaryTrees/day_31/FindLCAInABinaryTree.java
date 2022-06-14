package binaryTrees.day_31;

import binaryTrees.BinaryTree;
import binaryTrees.BinaryTreeUtil;
import binaryTrees.Node;

public class FindLCAInABinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeUtil.buildBinaryTree();
        binaryTree.root.right.right.right = new Node(8);
        int lca = binaryTree(binaryTree.root, 6, 8);
        System.out.println("lca = " + lca);
        int lca1 = binaryTree(binaryTree.root, 4, 8);
        System.out.println("lca = " + lca1);
    }

    private static int binaryTree(Node root, int n1, int n2) {
        Node lca = lcaFinder(root, n1, n2);
        return lca.data;
    }

    private static Node lcaFinder(Node root, int n1, int n2) {
        if (root == null || n1 == root.data || n2 == root.data) {
            return root;
        }
        Node left = lcaFinder(root.left, n1, n2);
        Node right = lcaFinder(root.right, n1, n2);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
}
