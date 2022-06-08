package binaryTrees.day_22;

import binaryTrees.BinaryTree;
import binaryTrees.BinaryTreeUtil;
import binaryTrees.Node;

public class BinaryTreeIsSumTreeOrNot {
    static boolean isSumTree = true;

    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeUtil.buildBinaryTree();
        checkIfSumTree(binaryTree.root);
        System.out.println("isSumTree = " + isSumTree);
        isSumTree = true;
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(2);
        checkIfSumTree(root);
        System.out.println("isSumTree = " + isSumTree);
    }

    private static int checkIfSumTree(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = checkIfSumTree(root.left);
        int rightSum = checkIfSumTree(root.right);
        if (!isLeaf(root) && leftSum + rightSum != root.data) {
            isSumTree = false;
        }
        return leftSum + rightSum + root.data;
    }

    private static boolean isLeaf(Node root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }
}
