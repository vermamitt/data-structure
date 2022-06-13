package binaryTrees.day_28;

import binaryTrees.BinaryTree;
import binaryTrees.BinaryTreeUtil;
import binaryTrees.Node;

public class FindLargestSubtreeSumInATree {
    static int largestSum = 0;

    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeUtil.buildBinaryTree();
        findLargestSubtreeSum(binaryTree.root);
        System.out.println("largestSum = " + largestSum);
    }

    private static int findLargestSubtreeSum(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = findLargestSubtreeSum(root.left);
        int rightSum = findLargestSubtreeSum(root.right);
        int totalSum = leftSum + rightSum + root.data;
        largestSum = Math.max(largestSum, totalSum);
        return totalSum;
    }
}
