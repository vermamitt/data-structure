package binaryTrees.day_17;

import binaryTrees.Node;

public class BinaryTreeFromString {
    private static int index = 0;

    public static void main(String[] args) {
        String string = "4(2(3)(1))(6(5))";
        Node root = binaryTreeHelper(string);

        index = 0;
        String string1 = "-4314(2(3)(1))(6(5))";
        Node root2 = binaryTreeHelper(string1);
        System.out.println();
    }

    private static Node binaryTreeHelper(String string) {
        int length = string.length();
        boolean isNegative = false;
        if (string.charAt(index) == '-') {
            isNegative = true;
            index++;
        }
        int num = 0;
        while (index < length && Character.isDigit(string.charAt(index))) {
            num = num * 10 + Character.getNumericValue(string.charAt(index));
            index++;
        }
        if (isNegative) num = -num;
        Node node = new Node(num);
        if (index >= length) {
            return node;
        }
        if (index < length && string.charAt(index) == '(') {
            index++;
            node.left = binaryTreeHelper(string);
        }
        if (index < length && string.charAt(index) == ')') {
            index++;
            return node;
        }
        if (index < length && string.charAt(index) == '(') {
            index++;
            node.right = binaryTreeHelper(string);
        }
        if (index < length && string.charAt(index) == ')') {
            index++;
            return node;
        }
        return node;
    }
}
