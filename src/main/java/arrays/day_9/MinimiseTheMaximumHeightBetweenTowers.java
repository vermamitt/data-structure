package arrays.day_9;

import java.util.Arrays;

public class MinimiseTheMaximumHeightBetweenTowers {
    public static void main(String[] args) {

        int[] array = {1, 5, 8, 10};
        int[] array1 = {3, 9, 12, 16, 20};
        System.out.println("Answer = " + getMinValue(array, 2));
        System.out.println("Answer = " + getMinValue(array1, 3));
    }

    public static int getMinValue(int[] array, int k) {
        Arrays.sort(array);
        int length = array.length;
        int answer = array[length - 1] - array[0];
        int min, max;
        for (int i = 1; i <= length - 1; i++) {
            if (array[i] >= k) {
                max = Math.max(array[length - 1] - k, array[i - 1] + k);
                min = Math.min(array[0] + k, array[i] - k);
                answer = Math.min(answer, max - min);
            }
        }
        return answer;
    }
}
