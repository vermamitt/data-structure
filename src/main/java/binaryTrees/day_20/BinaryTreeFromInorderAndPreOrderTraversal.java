package binaryTrees.day_20;

import binaryTrees.Node;

import java.util.HashMap;

public class BinaryTreeFromInorderAndPreOrderTraversal {
    public static void main(String[] args) {
        int inOrder[] = {3, 1, 4, 0, 5, 2};
        int preOrder[] = {0, 1, 3, 4, 2, 5};
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inMap.put(inOrder[i], i);
        }
        Node node = buildTree(preOrder, 0, 4, inOrder, 0, 4, inMap);
        System.out.println("Node = " + node);
    }

    private static Node buildTree(int[] preOrder, int preStart, int preEnd,
                                  int[] inOrder, int inStart, int inEnd, HashMap<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;
        Node root = new Node(preOrder[preStart]);
        int inRoot = inMap.get(root.data);
        int numLeft = inRoot - inStart;
        root.left = buildTree(preOrder, preStart + 1, preStart + numLeft,
                inOrder, inStart, inRoot - 1, inMap);
        root.right = buildTree(preOrder, preStart + numLeft + 1, preEnd,
                inOrder, inRoot + 1, inEnd, inMap);
        return root;
    }
}