package binaryTrees.day_35;

import binaryTrees.Node;

public class TreeIsomorphismProblem {
    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.left.left = new Node(4);
        root1.right = new Node(3);

        Node root2 = new Node(1);
        root2.left = new Node(3);
        root2.right = new Node(2);
        root2.right.right = new Node(4);

        boolean isIsomorphic = isIsomorphic(root1, root2);
        System.out.println("isIsomorphic = " + isIsomorphic);

        Node root3 = new Node(1);
        root3.left = new Node(2);
        root3.left.left = new Node(4);
        root3.right = new Node(3);

        Node root4 = new Node(1);
        root4.left = new Node(3);
        root4.right = new Node(2);
        root4.left.left = new Node(4);

        boolean isIsomorphic1 = isIsomorphic(root3, root4);
        System.out.println("isIsomorphic = " + isIsomorphic1);

        boolean isIsomorphic2 = isIsomorphic(root1, root1);
        System.out.println("isIsomorphic = " + isIsomorphic2);
    }

    private static boolean isIsomorphic(Node root1, Node root2) {
        return isIsomorphicUtil(root1, root2);
    }

    private static boolean isIsomorphicUtil(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.data != root2.data) {
            return false;
        }
        boolean a = isIsomorphicUtil(root1.left, root2.left) && isIsomorphicUtil(root1.right, root2.right);
        boolean b = isIsomorphicUtil(root1.left, root2.right) && isIsomorphicUtil(root1.right, root2.left);
        return a || b;
    }
}
