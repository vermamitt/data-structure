package binaryTrees.day_12;

import binaryTrees.BinaryTree;
import binaryTrees.BinaryTreeUtil;
import binaryTrees.Node;

import java.util.*;

public class BottomViewOfTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeUtil.buildBinaryTree();
        bottomViewOfTree(binaryTree.root).forEach(System.out::print);
    }

    private static ArrayList<Integer> bottomViewOfTree(Node node) {
        ArrayList<Integer> bottomView = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        queue.add(new Pair(0, node));
        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            map.put(poll.horizontalDistance, poll.node.data);
            if (poll.node.left != null) {
                queue.add(new Pair(poll.horizontalDistance - 1, poll.node.left));
            }
            if (poll.node.right != null) {
                queue.add(new Pair(poll.horizontalDistance + 1, poll.node.right));
            }
        }
        map.entrySet().stream().forEach(e -> {
            bottomView.add(e.getValue());
        });
        return bottomView;
    }

    static class Pair {
        int horizontalDistance;
        Node node;

        public Pair(int horizontalDistance, Node node) {
            this.horizontalDistance = horizontalDistance;
            this.node = node;
        }
    }
}
