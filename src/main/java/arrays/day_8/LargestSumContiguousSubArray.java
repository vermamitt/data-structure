package arrays.day_8;

public class LargestSumContiguousSubArray {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, -2, 5};
        System.out.println("Maximum contiguous sum is : " + maxSubArraySum(array1));
        int[] array2 = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is : " + maxSubArraySum(array2));
        int[] array3 = {-1, -2, -3, -4};
        System.out.println("Maximum contiguous sum is : " + maxSubArraySum(array3));
        int[] array4 = {-5, -3, -2, -4};
        System.out.println("Maximum contiguous sum is : " + maxSubArraySum(array4));
    }

    static int maxSubArraySum(int[] array) {
        int maxSoFar = array[0];
        int maxEndingHere = 0;
        for (int element : array) {
            maxEndingHere = maxEndingHere + element;
            if (maxSoFar < maxEndingHere) maxSoFar = maxEndingHere;
            if (maxEndingHere < 0) maxEndingHere = 0;
        }
        return maxSoFar;
    }
}
