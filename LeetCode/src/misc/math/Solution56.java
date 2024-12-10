package misc.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 56. Merge Intervals
public class Solution56 {
    public int[][] merge(int[][] intervals) {
        int[][] a = new int[5][];
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (int[] o1, int[] o2) -> {
            if (o1[0] == o2[0]){
                return o2[1] - o1[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        int left = intervals[0][0], right = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            int[] interval = intervals[i];
            if (right >= interval[1]) {

            } else if (right >= interval[0] && right <= interval[1]){
                right = interval[1];
            } else if (right < interval[0]){
                res.add(new int[]{left, right});
                left= interval[0];
                right = interval[1];
            }
        }

        res.add(new int[]{left, right});

        return res.stream().toArray(size -> new int[size][]);
        // return res.stream().toArray(int[][]::new);
    }
}

class Solution56_attempt1{
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[0] != o2[0]){
                return o1[0] - o2[0];
            }
            return o2[1] - o2[1];
        });

        int start = intervals[0][0], end = intervals[0][1];
        for(int i = 0; i < intervals.length; i++){
            int[] interval = intervals[i];
            if(interval[0] > end) {
                res.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            } else {
                end = Math.max(end, interval[1]);
            }
        }

        res.add(new int[]{start, end});
        return res.stream().toArray(int[][]::new);
    }
}

class Solution56_attempt2 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[0] < o2[0]){
                return -1;
            } else if (o1[0] > o2[0]){
                return 1;
            } else {
                if(o2[1] < o1[1]) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        int left = intervals[0][0], right = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= right){
                right = Math.max(intervals[i][1], right);
            } else {
                res.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }

        res.add(new int[]{left, right});

        return res.toArray(int[][]::new);
    }
}
