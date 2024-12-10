package array_linked_list.two_pointers.binary_search;

import java.util.Arrays;

// 2187. Minimum Time to Complete Trips
public class Solution2187 {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 1, right = Long.MAX_VALUE;
        Arrays.sort(time);
        while(left <= right){
            long middle = left + (right - left) / 2;
            int value = check(time, totalTrips, middle);
            if(value == -1){
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return left;
    }

    private int check(int[] time, int totalTrips, long currentTime){
        long trips = 0;
        for(int t : time){
            if(t > currentTime && trips < totalTrips){
                return -1;
            }
            if(trips >= totalTrips){
                return 1;
            }
            trips += currentTime / t;
        }

        return (trips >= totalTrips) ? 1 : -1;
    }
}
