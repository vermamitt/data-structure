package binaryTrees.day_1;

import binaryTrees.BinaryTree;
import binaryTrees.BinaryTreeUtil;
import binaryTrees.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalViaQueue {
    public static void main(String[] args) {
        BinaryTree tree = BinaryTreeUtil.buildBinaryTree();
        levelOrderTraversal(tree.root);
    }

    private static void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data);
            System.out.print(" ");
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
}
