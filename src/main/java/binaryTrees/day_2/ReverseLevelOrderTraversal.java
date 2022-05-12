package binaryTrees.day_2;

import binaryTrees.BinaryTree;
import binaryTrees.BinaryTreeUtil;
import binaryTrees.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTree tree = BinaryTreeUtil.buildBinaryTree();
        reverseOrderTraversal(tree);
    }

    private static void reverseOrderTraversal(BinaryTree tree) {
        Stack<Node> stack = new Stack<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(tree.root);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            stack.push(poll);
            if (poll.right != null) {
                queue.add(poll.right);
            }
            if (poll.left != null) {
                queue.add(poll.left);
            }
        }
        while (!stack.isEmpty()) {
            Node peek = stack.peek();
            System.out.print(peek.data);
            System.out.print(" ");
            stack.pop();
        }
    }
}
