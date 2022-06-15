package binaryTrees.day_30;

import binaryTrees.Node;

import java.util.ArrayList;
import java.util.List;

public class PrintAllKSumPathsInBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.left.right.left = new Node(1);
        root.right = new Node(-1);
        root.right.left = new Node(4);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(2);
        root.right.right = new Node(5);
        root.right.right.right = new Node(6);
        List<Integer> list = new ArrayList<>();
        findKPaths(root, 5, list);
    }

    private static void findKPaths(Node root, int sumToFind, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.data);
        findKPaths(root.left, sumToFind, list);
        findKPaths(root.right, sumToFind, list);
        int sum = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            sum = sum + list.get(i);
            if (sumToFind == sum) {
                for (int j = i; j < list.size(); j++) {
                    System.out.print(list.get(j) + " ");
                }
                System.out.println();
            }
        }
        list.remove(list.size() - 1);
    }
}
