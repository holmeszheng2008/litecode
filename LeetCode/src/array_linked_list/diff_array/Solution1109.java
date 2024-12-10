package array_linked_list.diff_array;

// 1109. Corporate Flight Bookings
class Solution1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];

        for (int i = 0; i < bookings.length; i++) {
            int low = bookings[i][0] - 1;
            int high = bookings[i][1] - 1;
            int val = bookings[i][2];
            increment(diff, low, high, val);
        }

        return returnResult(diff);
    }

    private void increment(int[] diff, int low, int high, int val) {
        diff[low] += val;
        if (high + 1 < diff.length) {
            diff[high + 1] -= val;
        }
    }

    private int[] returnResult(int[] diff) {
        int n = diff.length;
        int[] result = new int[n];
        result[0] = diff[0];
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] + diff[i];
        }

        return result;
    }
}
