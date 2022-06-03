package binaryTrees.day_14;

import binaryTrees.BinaryTree;
import binaryTrees.BinaryTreeUtil;
import binaryTrees.Node;

public class CheckIfTreeIsBalancedOrNot {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeUtil.buildBinaryTree();
        boolean isBalanced = checkIfBalanced(binaryTree.root);
        System.out.println("Given Binary tree is balance : " + isBalanced);

        BinaryTree binaryTree1 = new BinaryTree();
        binaryTree1.root = new Node(1);
        binaryTree1.root.left = new Node(5);
        binaryTree1.root.left.left = new Node(10);
        boolean isBalanced1 = checkIfBalanced(binaryTree1.root);
        System.out.println("Given Binary tree is balance : " + isBalanced1);
    }

    private static boolean checkIfBalanced(Node node) {
        int height = checkHeight(node);
        return height == -1 ? false : true;
    }

    private static int checkHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int lH = checkHeight(node.left);
        if (lH == -1) return -1;
        int rH = checkHeight(node.right);
        if (rH == -1) return -1;
        if (Math.abs(lH - rH) > 1) return -1;
        return Math.max(lH, rH) + 1;
    }
}
