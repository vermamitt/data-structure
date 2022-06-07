package binaryTrees.day_19;

import binaryTrees.BinaryTree;
import binaryTrees.BinaryTreeUtil;
import binaryTrees.Node;

public class TransformToSumTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeUtil.buildBinaryTree();
        transformToSumTree(binaryTree.root);

        BinaryTree binaryTree1 = buildSecondBinaryTree();
        transformToSumTree(binaryTree1.root);
        System.out.println();
    }

    private static int transformToSumTree(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = transformToSumTree(root.left);
        int rightSum = transformToSumTree(root.right);
        int totalSum = root.data + leftSum + rightSum;
        if (isLeaf(root)) {
            root.data = 0;
        } else {
            root.data = leftSum + rightSum;
        }
        return totalSum;
    }

    private static boolean isLeaf(Node root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }

    private static BinaryTree buildSecondBinaryTree() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(10);
        binaryTree.root.left = new Node(-2);
        binaryTree.root.right = new Node(6);
        binaryTree.root.left.left = new Node(8);
        binaryTree.root.left.right = new Node(-4);
        binaryTree.root.right.left = new Node(7);
        binaryTree.root.right.right = new Node(5);
        return binaryTree;
    }
}
