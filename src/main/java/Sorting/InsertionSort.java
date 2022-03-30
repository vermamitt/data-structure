package Sorting;

import utils.PrintUtils;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        int[] array1 = {70, 15, 2, 51, 60};
        insertionSort(array);
        PrintUtils.printArray(array);
        insertionSort(array1);
        PrintUtils.printArray(array1);
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && j < array.length) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
                j--;
            }
        }
    }
}
