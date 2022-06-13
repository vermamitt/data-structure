package binaryTrees.day_34;

import binaryTrees.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllDuplicateSubtreesInBinaryTree {

    static Map<String, Integer> map = new HashMap<>();
    static List<Node> list = new ArrayList<>();

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.left.left = new Node(4);
        node.right = new Node(3);
        node.right.left = new Node(2);
        node.right.left.left = new Node(4);
        node.right.right = new Node(4);
        findDuplicateSubtrees(node);
        System.out.println("list = " + list);
    }

    private static String findDuplicateSubtrees(Node node) {
        if (node == null) {
            return "$";
        }
        String leftString = findDuplicateSubtrees(node.left);
        String rightString = findDuplicateSubtrees(node.right);
        String key = node.data + "*" + leftString + "*" + rightString;
        map.putIfAbsent(key, 0);
        map.put(key, map.get(key) + 1);
        if (map.get(key) == 2) {
            list.add(node);
        }
        return key;
    }
}
