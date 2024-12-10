package misc.math;

import java.util.Arrays;

// 1288. Remove Covered Intervals
public class Solution1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        int res = 0;
        Arrays.sort(intervals, (int[] o1, int[] o2) -> {
            if (o1[0] == o2[0]){
                return o2[1] - o1[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        int left = intervals[0][0], right = intervals[0][1];
        for(int i =1; i < intervals.length; i++){
            if (right >= intervals[i][1]){
                res++;
            } else if (right >= intervals[i][0]  && right <= intervals[i][1]){
                right = intervals[i][1];
            } else if (right < intervals[i][0]){
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }

        return intervals.length - res;
    }
}
