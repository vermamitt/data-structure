package arrays.day_4;

public class SortArrayOf0s1s2s {
    public static void main(String[] args) {
        int array[] = {0, 2, 1, 2, 0};
        int array1[] = {0, 2, 1, 2, 0, 0, 0, 2, 2, 2, 1, 1, 1, 0, 1, 1, 0, 2};
        sortArray(array);
        sortArray(array1);
    }

    private static void sortArray(int[] array) {
        int zeroesCount = 0;
        int onesCount = 0;
        int twosCount = 0;
        for (int element : array) {
            if (element == 0) zeroesCount++;
            if (element == 1) onesCount++;
            if (element == 2) twosCount++;
        }
        swap(array, zeroesCount, 0, 0);
        swap(array, onesCount, zeroesCount, 1);
        swap(array, twosCount, zeroesCount + onesCount, 2);
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    private static void swap(int[] array, int count, int startPosition, int value) {
        while (count != 0) {
            array[startPosition] = value;
            startPosition++;
            count--;
        }
    }
}
