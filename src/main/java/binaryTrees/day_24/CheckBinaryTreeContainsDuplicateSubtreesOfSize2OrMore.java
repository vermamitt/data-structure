package binaryTrees.day_24;

import binaryTrees.BinaryTree;
import binaryTrees.Node;

import java.util.HashMap;
import java.util.Map;

public class CheckBinaryTreeContainsDuplicateSubtreesOfSize2OrMore {
    static Map<String, Integer> map = new HashMap<>();
    static boolean containsDuplicateSubtree = false;

    public static void main(String[] args) {
        BinaryTree binaryTree = buildNinaryTree();
        containDuplicateSubtree(binaryTree.root);
        System.out.println("containsDuplicateSubtree = " + containsDuplicateSubtree);

        map = new HashMap<>();
        containsDuplicateSubtree = false;
        binaryTree.root.right.right.left = null;
        binaryTree.root.right.right.right.right = new Node(4);
        containDuplicateSubtree(binaryTree.root);
        System.out.println("containsDuplicateSubtree = " + containsDuplicateSubtree);
    }

    private static void containDuplicateSubtree(Node root) {
        solve(root);
        map.forEach((k, v) -> {
            if (v > 1) {
                containsDuplicateSubtree = true;
            }
        });
    }

    private static String solve(Node root) {
        if (root == null) {
            return "$";
        }
        if (isLeaf(root)) {
            return String.valueOf(root.data);
        }
        String leftString = solve(root.left);
        String rightString = solve(root.right);
        String val = root.data + leftString + rightString;
        map.putIfAbsent(val, 0);
        map.put(val, map.get(val) + 1);
        return val;
    }

    private static boolean isLeaf(Node root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }

    private static BinaryTree buildNinaryTree() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(1);
        binaryTree.root.left = new Node(2);
        binaryTree.root.left.left = new Node(4);
        binaryTree.root.left.right = new Node(5);
        binaryTree.root.right = new Node(3);
        binaryTree.root.right.right = new Node(2);
        binaryTree.root.right.right.left = new Node(4);
        binaryTree.root.right.right.right = new Node(5);
        return binaryTree;
    }
}
