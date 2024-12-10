package array_linked_list.diff_array;

// Car Pooling
public class Solution1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for (int[] trip : trips) {
            increment(trip[1], trip[2] - 1, trip[0], diff);
        }

        return check(diff, capacity);
    }

    private static void increment(int i, int j, int k, int[] diff) {
        diff[i] += k;
        if (j + 1 < diff.length) {
            diff[j + 1] -= k;
        }
    }

    private static boolean check(int[] diff, int capacity) {
        int num1 = diff[0];
        if (num1 > capacity) {
            return false;
        }
        for (int i = 1; i < diff.length; i++) {
            int num2 = diff[i] + num1;
            if (num2 > capacity) {
                return false;
            }
            num1 = num2;
        }

        return true;
    }

}
