package array_linked_list.two_pointers.binary_search;

// 875. Koko Eating Bananas
public class Solution875 {
    private int getHours(int kPerHour, int[] piles) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            int number = piles[i];
            hours += number / kPerHour;
            if (number % kPerHour != 0) {
                hours += 1;
            }
        }
        return hours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1000000000;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int y = getHours(mid, piles);
            if (y == h) {
                right = mid - 1;
            } else if (y < h) {
                right = mid - 1;
            } else if (y > h) {
                left = mid + 1;
            }
        }


        return left;
    }
}
