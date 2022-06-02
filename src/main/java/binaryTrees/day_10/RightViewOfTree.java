package binaryTrees.day_10;

import binaryTrees.BinaryTree;
import binaryTrees.BinaryTreeUtil;
import binaryTrees.Node;

public class RightViewOfTree {

    static int mainLevel = 0;

    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeUtil.buildBinaryTree();
        rightViewOfTree(binaryTree.root);

        binaryTree.root.right.right.left = new Node(8);
        binaryTree.root.right.right.right = new Node(9);
        binaryTree.root.right.right.right.right = new Node(10);
        rightViewOfTree(binaryTree.root);
    }

    private static void rightViewOfTree(Node root) {
        mainLevel = 0;
        rightViewOfTreeUtil(root, 1);
        System.out.println();
    }

    private static void rightViewOfTreeUtil(Node node, int level) {
        if (node == null) {
            return;
        }
        if (mainLevel < level) {
            System.out.print(node.data + " ");
            mainLevel = level;
        }
        rightViewOfTreeUtil(node.right, level + 1);
        rightViewOfTreeUtil(node.left, level + 1);
    }
}
