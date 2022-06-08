package binaryTrees.day_21;

import binaryTrees.BinaryTree;
import binaryTrees.BinaryTreeUtil;
import binaryTrees.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumSwapToConvertBinaryTreeToBST {
    static int index = 0;

    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeUtil.buildBinaryTree();
        int minSwaps = minimumSwaps(binaryTree.root);
        System.out.println("minSwaps = " + minSwaps);
        index = 0;
        BinaryTree binaryTree1 = buildSecondTree();
        System.out.println("minSwaps1 = " + minimumSwaps(binaryTree1.root));
    }

    private static BinaryTree buildSecondTree() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(5);
        binaryTree.root.left = new Node(6);
        binaryTree.root.left.left = new Node(8);
        binaryTree.root.left.right = new Node(9);
        binaryTree.root.right = new Node(7);
        binaryTree.root.right.left = new Node(10);
        binaryTree.root.right.right = new Node(11);
        return binaryTree;
    }

    private static int minimumSwaps(Node root) {
        int swap = 0;
        List<Pair> inorderTraversal = new ArrayList<>();
        inOrderTraversalArray(root, inorderTraversal);
        Collections.sort(inorderTraversal, Collections.reverseOrder());
        for (int i = 0; i < inorderTraversal.size(); i++) {
            if (i == inorderTraversal.get(i).index) {
                continue;
            } else {
                Pair temp = inorderTraversal.get(i);
                inorderTraversal.set(i, inorderTraversal.get(inorderTraversal.get(i).index));
                inorderTraversal.set(temp.index, temp);
                i--;
                swap++;
            }
        }
        return swap;
    }

    private static void inOrderTraversalArray(Node root, List<Pair> inorderTraversal) {
        if (root == null) {
            return;
        }
        inOrderTraversalArray(root.left, inorderTraversal);
        inorderTraversal.add(new Pair(root.data, index++));
        inOrderTraversalArray(root.right, inorderTraversal);
    }

}

class Pair implements Comparable<Pair> {
    int data;
    int index;

    public Pair(int data, int index) {
        this.data = data;
        this.index = index;
    }

    public int getData() {
        return data;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(Pair pair) {
        if (pair.getData() > this.getData()) {
            return 1;
        } else if (pair.getData() < this.getData()) {
            return -1;
        }
        return 0;
    }
}
