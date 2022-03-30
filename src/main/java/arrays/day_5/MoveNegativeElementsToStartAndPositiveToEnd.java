package arrays.day_5;

public class MoveNegativeElementsToStartAndPositiveToEnd {
    public static void main(String[] args) {
        int[] array = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        arrangeArray(array, 0, array.length - 1);
        printArray(array);
    }

    private static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    private static void arrangeArray(int[] array, int start, int end) {
        while (start < end) {
            if (array[start] < 0) {
                start++;
            } else {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                end--;
            }
        }
    }
}
