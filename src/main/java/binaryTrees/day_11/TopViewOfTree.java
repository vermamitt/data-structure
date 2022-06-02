package binaryTrees.day_11;

import binaryTrees.BinaryTree;
import binaryTrees.BinaryTreeUtil;
import binaryTrees.Node;

import java.util.*;

public class TopViewOfTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeUtil.buildBinaryTree();
        ArrayList<Integer> topView = rightViewOfTree(binaryTree.root);
        topView.forEach(System.out::print);
    }

    private static ArrayList<Integer> rightViewOfTree(Node node) {
        ArrayList<Integer> topView = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        queue.add(new Pair(0, node));
        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            if (!map.containsKey(poll.hd)) {
                map.put(poll.hd, poll.node.data);
            }
            if (poll.node.left != null) {
                queue.add(new Pair(poll.hd - 1, poll.node.left));
            }
            if (poll.node.right != null) {
                queue.add(new Pair(poll.hd + 1, poll.node.right));
            }
        }
        map.entrySet().stream().forEach(e -> {
            topView.add(e.getValue());
        });
        return topView;
    }

    static class Pair {
        int hd;
        Node node;

        public Pair(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }
}
