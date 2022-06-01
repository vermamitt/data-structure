package binaryTrees.day_9;

import binaryTrees.BinaryTree;
import binaryTrees.BinaryTreeUtil;
import binaryTrees.Node;

public class LeftViewOfTree {

    static int main_level = 0;

    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeUtil.buildBinaryTree();
        leftViewOfTree(binaryTree.root);
        binaryTree.root.right.right.left = new Node(8);
        binaryTree.root.right.right.right = new Node(9);
        binaryTree.root.right.right.right.right = new Node(10);
        leftViewOfTree(binaryTree.root);
    }

    private static void leftViewOfTree(Node root) {
        main_level = 0;
        leftViewOfTreeUtil(root, 1);
        System.out.println();
    }

    private static void leftViewOfTreeUtil(Node root, int level) {
        if (root == null) {
            return;
        }
        if (main_level < level) {
            System.out.print(root.data + " ");
            main_level = level;
        }
        leftViewOfTreeUtil(root.left, level + 1);
        leftViewOfTreeUtil(root.right, level + 1);
    }
}
