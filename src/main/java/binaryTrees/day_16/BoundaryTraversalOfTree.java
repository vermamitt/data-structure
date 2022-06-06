package binaryTrees.day_16;

import binaryTrees.BinaryTree;
import binaryTrees.BinaryTreeUtil;
import binaryTrees.Node;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversalOfTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeUtil.buildBinaryTree();
        boundaryLevelTraversal(binaryTree.root).forEach(System.out::print);
        System.out.println();
        binaryTree.root.right.left.right = new Node(8);
        binaryTree.root.left.right.left = new Node(9);
        binaryTree.root.left.right.right = new Node(10);
        boundaryLevelTraversal(binaryTree.root).forEach(System.out::print);
    }

    private static List<Integer> boundaryLevelTraversal(Node node) {
        ArrayList<Integer> boundary = new ArrayList<>();
        if (!isLeaf(node)) {
            boundary.add(node.data);
        }
        addLeftBoundary(node, boundary);
        addLeafs(node, boundary);
        addRightBoundary(node, boundary);
        return boundary;
    }

    private static void addRightBoundary(Node node, ArrayList<Integer> boundary) {
        Node current = node.right;
        List<Integer> temp = new ArrayList<>();
        while (current != null) {
            if (!isLeaf(current)) {
                temp.add(current.data);
            }
            if (current.right != null) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            boundary.add(temp.get(i));
        }
    }

    private static void addLeafs(Node node, ArrayList<Integer> boundary) {
        if (isLeaf(node)) {
            boundary.add(node.data);
        }
        if (node.left != null) addLeafs(node.left, boundary);
        if (node.right != null) addLeafs(node.right, boundary);
    }

    private static void addLeftBoundary(Node node, ArrayList<Integer> boundary) {
        if (node == null) {
            return;
        }
        Node current = node.left;
        while (current != null) {
            if (!isLeaf(current)) {
                boundary.add(current.data);
            }
            if (current.left != null) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
    }

    private static boolean isLeaf(Node node) {
        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }
}
