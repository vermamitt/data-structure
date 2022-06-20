package binaryTrees.day_29;

import binaryTrees.BinaryTree;
import binaryTrees.BinaryTreeUtil;
import binaryTrees.Node;

import java.util.HashMap;
import java.util.Map;

public class MaximumSumOfNodesSuchThatNoTwoAreAdjacent {
    static Map<Node, Integer> dp;

    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeUtil.buildBinaryTree();
        dp = new HashMap<>();
        int max = findMaximum(binaryTree.root);
        System.out.println("max = " + max);

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        dp = new HashMap<>();
        int max1 = findMaximum(root);
        System.out.println("max1 = " + max1);
    }

    private static int findMaximum(Node root) {
        if (root == null) {
            return 0;
        }
        if (dp.containsKey(root)) {
            return dp.get(root);
        }
        int include = root.data;
        if (root.left != null) {
            include += findMaximum(root.left.left);
            include += findMaximum(root.left.right);
        }
        if (root.right != null) {
            include += findMaximum(root.right.left);
            include += findMaximum(root.right.right);
        }
        int exclude = findMaximum(root.left) + findMaximum(root.right);
        dp.put(root, Math.max(include, exclude));
        return dp.get(root);
    }
}
