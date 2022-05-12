package binaryTrees.day_3;

import binaryTrees.BinaryTree;
import binaryTrees.BinaryTreeUtil;
import binaryTrees.Node;

public class HeightOfBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeUtil.buildBinaryTree();
        int height = height(binaryTree.root);
        System.out.println("Height of the tree is : " + height);
        binaryTree.root.left.left.left = new Node(8);
        System.out.println("Height of the tree is : " + height(binaryTree.root));
    }

    private static int height(Node node) {
        if (node == null) {
            return 0;
        } else {
            int lLength = height(node.left);
            int rLength = height(node.left);
            if (lLength > rLength) {
                return lLength + 1;
            } else {
                return rLength + 1;
            }
        }
    }
}
