package Arrays.day_1;

public class ReverseTheArray {
    public static void main(String[] args) {
        int evenArray[] = {2, 8, 4, 1, 6, 5, 3, 4};
        int oddArray[] = {2, 8, 4, 1, 6, 5, 3, 4, 9};
        reverseTheArrayAndPrint(evenArray);
        reverseTheArrayAndPrint(oddArray);
    }

    private static void reverseTheArrayAndPrint(int[] array) {
        reverseArray(array, 0, array.length - 1);
        printArray(array);
    }

    private static void reverseArray(int[] array, int startPosition, int endPosition) {
        if (startPosition >= endPosition) {
            return;
        }
        int temp = array[startPosition];
        array[startPosition] = array[endPosition];
        array[endPosition] = temp;
        reverseArray(array, startPosition + 1, endPosition - 1);
    }

    private static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
