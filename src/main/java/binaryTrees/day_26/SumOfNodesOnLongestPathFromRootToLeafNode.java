package binaryTrees.day_26;

import binaryTrees.BinaryTree;
import binaryTrees.BinaryTreeUtil;
import binaryTrees.Node;

public class SumOfNodesOnLongestPathFromRootToLeafNode {
    static int maxSum = 0;
    static int maxLevel = 0;

    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeUtil.buildBinaryTree();
        sumOfNodesOnLongestPath(binaryTree.root, 0, 0);
        System.out.println("maxSum = " + maxSum);

        maxSum = 0;
        maxLevel = 0;
        binaryTree.root.left.right.left = new Node(4);
        sumOfNodesOnLongestPath(binaryTree.root, 0, 0);
        System.out.println("maxSum = " + maxSum);
    }

    private static void sumOfNodesOnLongestPath(Node root, int currentLevel, int sum) {
        if (root == null) {
            return;
        }
        sum = sum + root.data;
        currentLevel = currentLevel + 1;
        sumOfNodesOnLongestPath(root.left, currentLevel, sum);
        sumOfNodesOnLongestPath(root.right, currentLevel, sum);
        if (maxLevel < currentLevel) {
            maxSum = sum;
            maxLevel = currentLevel;
        } else if (maxLevel == currentLevel) {
            maxSum = Math.max(sum, maxSum);
        }
    }
}
