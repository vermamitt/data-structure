package Arrays.day_2;

public class FindMaximumAndMinimumInArray {
    public static void main(String[] args) {
        int[] array1 = {2, 8, 4, 1, 6, 5, 3, 4};
        int[] array2 = {2, 8, 4, 1, 6, 5, 3, 4, 9};
        findMinimumAndMaximum(array1);
        findMinimumAndMaximum(array2);
    }

    private static void findMinimumAndMaximum(int[] array) {
        if (array.length == 0) {
            System.out.println("Array is Empty");
        }
        int min = array[0];
        int max = array[array.length - 1];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("min = " + min);
        System.out.println("max = " + max);
    }
}
