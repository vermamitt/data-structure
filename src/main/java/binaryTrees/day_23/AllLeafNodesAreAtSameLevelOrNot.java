package binaryTrees.day_23;

import binaryTrees.BinaryTree;
import binaryTrees.BinaryTreeUtil;
import binaryTrees.Node;

public class AllLeafNodesAreAtSameLevelOrNot {
    static int leafLevel = 0;

    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeUtil.buildBinaryTree();
        boolean isAllLeafsAtSameLevel = checkIfAllLeafAtSameLevel(binaryTree.root, 1);
        System.out.println("isAllLeafsAtSameLevel = " + isAllLeafsAtSameLevel);

        leafLevel = 0;
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        System.out.println("isAllLeafsAtSameLevel = " + checkIfAllLeafAtSameLevel(node, 1));
    }

    private static boolean checkIfAllLeafAtSameLevel(Node root, int currentLevel) {
        if (root == null) {
            return true;
        }
        if (isLeaf(root)) {
            if (leafLevel == 0) {
                leafLevel = currentLevel;
                return true;
            }
            return currentLevel == leafLevel;
        }
        return checkIfAllLeafAtSameLevel(root.left, currentLevel + 1) &&
                checkIfAllLeafAtSameLevel(root.right, currentLevel + 1);
    }

    private static boolean isLeaf(Node root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }
}
