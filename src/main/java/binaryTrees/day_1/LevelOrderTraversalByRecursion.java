package binaryTrees.day_1;

import binaryTrees.BinaryTree;
import binaryTrees.BinaryTreeUtil;
import binaryTrees.Node;

public class LevelOrderTraversalByRecursion {
    public static void main(String[] args) {
        BinaryTree tree = BinaryTreeUtil.buildBinaryTree();
        System.out.println("Height of the tree : " + height(tree.root));
        levelOrderTraversal(tree, height(tree.root));
    }

    private static int height(Node node) {
        if (node == null) {
            return 0;
        } else {
            int lHeight = height(node.left);
            int rHeight = height(node.right);
            if (lHeight > rHeight) {
                return lHeight + 1;
            } else {
                return rHeight + 1;
            }
        }
    }

    private static void levelOrderTraversal(BinaryTree tree, int height) {
        for (int i = 1; i <= height; i++) {
            printCurrentLevel(tree.root, i);
        }
    }

    private static void printCurrentLevel(Node node, int level) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            System.out.print(node.data);
            System.out.print(" ");
        } else if (level > 1) {
            printCurrentLevel(node.left, level - 1);
            printCurrentLevel(node.right, level - 1);
        }
    }
}
