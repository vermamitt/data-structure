package arrays.day_3;

import java.util.Arrays;

public class KthMaxMinElement {

    public static void main(String[] args) {
        int[] array = {2, 8, 4, 1, 6, 5, 3, 4, 9};
        findKthMaxMin(array, 2);
        findKthMaxMin(array, 3);
    }

    private static void findKthMaxMin(int[] array, int k) {
        Arrays.sort(array);
        /*
        Arrays.sort uses dual-pivot quick sort algorithm internally
        Typically it's faster than traditional(one pivot) quick sort implementation
        */
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println("Kth min : " + array[k - 1]);
        System.out.println("Kth max : " + array[array.length - k]);
    }
}
