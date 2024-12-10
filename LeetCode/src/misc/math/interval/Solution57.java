package misc.math.interval;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 57. Insert Interval
public class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) {
            return new int[][]{
                newInterval
            };
        }
        int targetIndex = -1;
        for(int i = 0; i < intervals.length; i++){
            int[] interval = intervals[i];
            if(interval[0] > newInterval[0]){
                targetIndex = i;
                break;
            } else if (interval[0] == newInterval[0]) {
                if(interval[1] >= newInterval[1]){
                    return intervals;
                } else {
                    targetIndex = i;
                }
            }
        }

        LinkedList<int[]> res = new LinkedList<>();
        int left = -1, right = -1;
        boolean insertionVisited = false;
        for(int i = 0; i < intervals.length;){
            int[] interval = null;
            if(i == targetIndex){
                if(insertionVisited){
                    interval = intervals[i];
                    i++;
                } else {
                    insertionVisited = true;
                    interval = newInterval;
                }
            } else {
                interval = intervals[i];
                i++;
            }

            if(right < interval[0]){
                res.add(new int[]{left, right});
                left = interval[0];
                right=  interval[1];
            } else {
                right = Math.max(interval[1], right);
            }
        }

        if(targetIndex == -1){
            if(right >= newInterval[0]) {
                right = Math.max(right, newInterval[1]);
                res.add(new int[]{left, right});
            } else {
                res.add(new int[]{left, right});
                res.add(newInterval);
            }
        } else {
            res.add(new int[]{left, right});
        }

        res.removeFirst();

        return res.toArray(int[][]::new);
    }
}

class Solution57_attempt1 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{
                    newInterval
            };
        }

        List<int[]> res = new ArrayList<>();
        List<int[]> intervalList = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++){
            if(intervals[i][0] < newInterval[0]){
                intervalList.add(intervals[i]);
                if(i == intervals.length - 1){
                    intervalList.add(newInterval);
                }
            } else if (intervals[i][0] > newInterval[0] || (intervals[i][0] == newInterval[0] && newInterval[1] >= intervals[i][1])){
                intervalList.add(newInterval);
                for(; i < intervals.length; i++){
                    intervalList.add(intervals[i]);
                }
            } else {
                return intervals;
            }
        }
        int left = intervalList.get(0)[0];
        int right = intervalList.get(0)[1];
        for(int i = 1; i < intervalList.size(); i++){
            int[] interval = intervalList.get(i);
            if(right >= interval[0]){
                right = Math.max(right, interval[1]);
            } else {
                res.add(new int[]{left, right});
                left = interval[0];
                right = interval[1];
            }
        }

        res.add(new int[]{left, right});

        return res.toArray(int[][]::new);
    }
}