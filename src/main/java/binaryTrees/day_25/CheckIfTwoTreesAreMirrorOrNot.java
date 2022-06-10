package binaryTrees.day_25;

import java.util.HashMap;
import java.util.Stack;

public class CheckIfTwoTreesAreMirrorOrNot {
    public static void main(String[] args) {
        int n = 3, e = 2;
        int A[] = {1, 2, 1, 3};
        int B[] = {1, 3, 1, 2};
        System.out.println("isMirrorTree : " + isMirror(n, e, A, B));

        int n1 = 3, e1 = 2;
        int A1[] = {1, 2, 1, 3};
        int B1[] = {1, 2, 1, 3};
        System.out.println("isMirrorTree : " + isMirror(n1, e1, A1, B1));
    }

    private static boolean isMirror(int n, int e, int[] A, int[] B) {
        HashMap<Integer, Stack<Integer>> map = new HashMap<>();
        for (int i = 0; i < e * 2; i += 2) {
            if (!map.containsKey(A[i])) {
                Stack<Integer> stack = new Stack<>();
                stack.push(A[i + 1]);
                map.put(A[i], stack);
            } else {
                map.get(A[i]).push(A[i + 1]);
                map.put(A[i], map.get(A[i]));
            }
        }
        for (int i = 0; i < e * 2; i += 2) {
            if (map.get(B[i]).pop() != B[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
