package arrays;

import java.util.HashSet;

public class LongestConsecutiveArray {
    public static void main(String[] args) {
        int a[] = {2, 6, 1, 9, 4, 5, 3};
        int res = lca(a, a.length);
        System.out.println("res = " + res);
    }

    private static int lca(int[] a, int length) {
        HashSet<Integer> set = new HashSet<>();
        for (int e : a) {
            set.add(e);
        }
        int longest = 1;
        for (Integer element : set) {
            if (!set.contains(element - 1)) {
                int count = 0;
                while (set.contains(element)) {
                    element = element + 1;
                    count++;
                }
                longest = Math.max(count, longest);
            }
        }
        return longest;
    }
}
