package binaryTrees.day_15;

import binaryTrees.BinaryTree;
import binaryTrees.BinaryTreeUtil;
import binaryTrees.Node;

import java.util.LinkedList;
import java.util.Queue;

public class DiagonalTraversalOfTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeUtil.buildBinaryTree();
        diagonalTraversal(binaryTree.root);
    }

    private static void diagonalTraversal(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            while (poll != null) {
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                System.out.print(poll.data + " ");
                poll = poll.right;
            }
        }
    }
}
