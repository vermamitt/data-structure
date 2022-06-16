package binaryTrees.day_32;

import binaryTrees.BinaryTree;
import binaryTrees.BinaryTreeUtil;
import binaryTrees.Node;

public class DistanceBetween2Nodes {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeUtil.buildBinaryTree();
        System.out.println("distance = " + findDistance(binaryTree.root, 4, 7));
        System.out.println("distance = " + findDistance(binaryTree.root, 5, 3));
        System.out.println("distance = " + findDistance(binaryTree.root, 4, 5));
        System.out.println("distance = " + findDistance(binaryTree.root, 5, 6));
    }

    private static int findDistance(Node root, int data1, int data2) {
        Node lca = findLca(root, data1, data2);
        int x = helper(lca, data1);
        int y = helper(lca, data2);
        return x + y - 2;
    }

    private static int helper(Node root, int data) {
        if (root == null) {
            return 0;
        }
        if (root.data == data) {
            return 1;
        }
        int a = helper(root.left, data);
        int b = helper(root.right, data);
        if (a == 0 && b == 0) {
            return 0;
        }
        return a + b + 1;
    }

    private static Node findLca(Node root, int data1, int data2) {
        if (root == null || root.data == data1 || root.data == data2) {
            return root;
        }
        Node left = findLca(root.left, data1, data2);
        Node right = findLca(root.right, data1, data2);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
}
