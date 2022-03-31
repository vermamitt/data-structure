package arrays.day_6;

public class UnionIntersectionOfTwoSortedArraysHandledSameAdjacentValues {
    public static void main(String[] args) {
        int[] array1 = {1, 1, 3, 4, 5, 5, 7, 7, 7};
        int[] array2 = {2, 3, 3, 5, 6};
        //Union : {1, 2, 3, 4, 5, 6, 7}
        //Intersection : {3, 5}
        findUnion(array1, array2);
        findIntersection(array1, array2);
    }

    private static void findIntersection(int[] array1, int[] array2) {
        int i = 0;
        int j = 0;
        System.out.print("Intersection : ");
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                i++;
            } else if (array2[j] < array1[i]) {
                j++;
            } else {
                System.out.print(array1[i] + " ");
                i++;
                j++;
            }
        }
    }

    private static void findUnion(int[] array1, int[] array2) {
        int i = 0;
        int j = 0;
        System.out.print("Union : ");
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                System.out.print(array1[i] + " ");
                i++;
                i = checkIfSameAdjacentValue(array1, i);
            } else if (array2[j] < array1[i]) {
                System.out.print(array2[j] + " ");
                j++;
                j = checkIfSameAdjacentValue(array2, j);
            } else {
                System.out.print(array1[i] + " ");
                i++;
                j++;
                i = checkIfSameAdjacentValue(array1, i);
                j = checkIfSameAdjacentValue(array2, j);
            }
        }
        while (i < array1.length) {
            System.out.print(array1[i] + " ");
            i++;
            i = checkIfSameAdjacentValue(array1, i);
        }
        while (j < array2.length) {
            System.out.print(array1[j] + " ");
            j++;
            j = checkIfSameAdjacentValue(array2, j);
        }
        System.out.println();
    }

    private static int checkIfSameAdjacentValue(int[] array, int k) {
        if (k < array.length) {
            if (array[k - 1] == array[k]) {
                k++;
                k = checkIfSameAdjacentValue(array, k);
            }
        }
        return k;
    }
}
