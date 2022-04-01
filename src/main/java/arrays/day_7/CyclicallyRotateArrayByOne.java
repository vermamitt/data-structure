package arrays.day_7;

import static utils.PrintUtils.printArray;

public class CyclicallyRotateArrayByOne {
    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 4, 2, 1, 3};
        rotate(array);
        printArray(array);
    }

    private static void rotate(int[] array) {
        int lastElement = array[array.length - 1];
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = lastElement;
    }
}
