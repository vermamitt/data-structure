package arrays.day_10;

public class MinimumNumberOfJumps {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println("jump = " + minJumps(a, a.length));
    }

    private static int minJumps(int[] a, int n) {
        if (n == 1) {
            return 0;
        } else if (a[0] == 0) {
            return -1;
        } else {
            int range = a[0];
            int step = a[0];
            int jump = 1;
            for (int i = 1; i < n; i++) {
                if (n - 1 == i) {
                    return jump;
                }
                range = Math.max(a[i] + i, range);
                step--;
                if (step == 0) {
                    jump++;
                    if (range <= i) {
                        return -1;
                    }
                    step = range - i;
                }
            }
        }
        return -1;
    }
}
