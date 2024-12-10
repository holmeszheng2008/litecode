package array_linked_list.two_pointers.binary_search;

public class Solution875_iteration {
    private int getHours(int kPerHour, int[] piles) {
        int hours = 0;
        for (int i : piles) {
            hours += i / kPerHour;
            if (i % kPerHour != 0) {
                hours++;
            }
        }
        return hours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000000 + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int ans = getHours(mid, piles);
            if (ans == h) {
                right = mid;
            } else if (ans > h) {
                left = mid + 1;
            } else if (ans < h) {
                right = mid;
            }
        }

        return left;
    }
}
