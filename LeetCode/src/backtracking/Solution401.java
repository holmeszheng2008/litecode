package backtracking;

import java.util.ArrayList;
import java.util.List;

// 401. Binary Watch
public class Solution401 {
    private int path;

    public List<String> readBinaryWatch(int turnedOn) {
        int[] hours = new int[]{8, 4, 2, 1};
        int[] minutes = new int[]{32, 16, 8 ,4 ,2 ,1};

        List<String> res = new ArrayList<>();
        if (turnedOn >= 9) {
            return res;
        }

        //3, 5
        for(int i = 0; i <= 3; i++){
            int j = turnedOn - i;
            if(j > 5 || j < 0){
                continue;
            }
            List<Integer> hoursRes = new ArrayList<>();
            List<Integer> minsRes = new ArrayList<>();

            if(i == 0){
                hoursRes.add(0);
            } else {
                path = 0;
                backtracking(hours, 12, 0, i, hoursRes);
            }
            if(j == 0){
                minsRes.add(0);
            } else {
                path = 0;
                backtracking(minutes, 60, 0, j, minsRes);
            }

            for(int hourRes : hoursRes){
                for(int minRes : minsRes){
                    if(minRes < 10){
                        res.add(hourRes + ":" + "0" + minRes);
                    } else {
                        res.add(hourRes + ":" + minRes);
                    }
                }
            }
        }

        return res;
    }

    void backtracking(int[] array, int limit, int index, int left, List<Integer> res){
        if(left > 0){
            // take
            path += array[index];
            left--;

            if(left == 0 || index == array.length - 1) {
                if (left == 0 && path < limit) {
                    res.add(path);
                }
            } else {
                backtracking(array, limit, index + 1, left, res);
            }

            path -= array[index];
            left++;
        }

        // don't take
        if(index == array.length - 1) {

        } else {
            backtracking(array, limit, index + 1, left, res);
        }
    }
}
