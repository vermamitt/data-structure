package binaryTrees.day_13;

import binaryTrees.BinaryTree;
import binaryTrees.BinaryTreeUtil;
import binaryTrees.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTraversalOfTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeUtil.buildBinaryTree();
        zigZagTraversal(binaryTree.root).forEach(System.out::print);
        binaryTree.root.right.right.left = new Node(8);
        binaryTree.root.right.right.right = new Node(9);
        zigZagTraversal(binaryTree.root).forEach(System.out::print);
    }

    private static ArrayList<Integer> zigZagTraversal(Node node) {
        ArrayList<Integer> zigzagTraversal = new ArrayList<>();
        if (node == null) {
            return zigzagTraversal;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        boolean isLeftTraversal = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int array[] = new int[size];
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                int index = isLeftTraversal ? i : size - 1 - i;
                array[index] = poll.data;
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            for (int e : array) {
                zigzagTraversal.add(e);
            }
            isLeftTraversal = !isLeftTraversal;
        }
        return zigzagTraversal;
    }
}
