package binaryTrees.day_4;

import binaryTrees.BinaryTree;
import binaryTrees.Node;

import static binaryTrees.BinaryTreeUtil.buildBinaryTree;
import static binaryTrees.BinaryTreeUtil.height;

public class DiameterOfTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = buildBinaryTree();
        int diameter = diameterOfTree(binaryTree.root);
        System.out.println("Diameter of Binary Tree is : " + diameter);
        binaryTree.root.left.right.left = new Node(8);
        System.out.println("Diameter of Updated Binary Tree is : " + diameterOfTree(binaryTree.root));
    }

    private static int diameterOfTree(Node node) {
        if (node == null) {
            return 0;
        }
        int lHeight = height(node.left);
        int rHeight = height(node.right);
        int lDiameter = diameterOfTree(node.left);
        int rDiameter = diameterOfTree(node.right);
        return Math.max(lHeight + rHeight + 1, Math.max(lDiameter, rDiameter));
    }
}
