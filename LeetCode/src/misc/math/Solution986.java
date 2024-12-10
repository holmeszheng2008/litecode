package misc.math;

import java.util.ArrayList;
import java.util.List;

// 986. Interval List Intersections
public class Solution986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        List<int[]> mergedList = new ArrayList<>();
        for(int i = 0, j = 0; i < firstList.length || j < secondList.length;){
            if (i < firstList.length && j < secondList.length){
                int firstLeft = firstList[i][0];
                int firstRight = firstList[i][1];
                int secondLeft = secondList[j][0];
                int secondRight = secondList[j][1];
                if (firstLeft == secondLeft){
                    if (firstRight >= secondRight){
                        mergedList.add(firstList[i]);
                        i++;
                    } else {
                        mergedList.add(secondList[j]);
                        j++;
                    }
                } else if (firstLeft < secondLeft){
                    mergedList.add(firstList[i]);
                    i++;
                } else if (firstLeft > secondLeft){
                    mergedList.add(secondList[j]);
                    j++;
                }
            } else if (i < firstList.length) {
                while (i < firstList.length) {
                    mergedList.add(firstList[i]);
                    i++;
                }
            }else if (j < secondList.length){
                while(j < secondList.length) {
                    mergedList.add(secondList[j]);
                    j++;
                }
            }
        }

        int left = mergedList.get(0)[0], right= mergedList.get(0)[1];
        for(int i = 1; i < mergedList.size(); i++){
            int[] interval = mergedList.get(i);
            if (right >= interval[1]) {
                res.add(new int[]{interval[0], interval[1]});
            } else if (right >= interval[0] && right <= interval[1]){
                res.add(new int[]{interval[0], right});
                right = interval[1];
            } else {
                left = interval[0];
                right = interval[1];
            }
        }

        return res.stream().toArray(int[][]::new);
    }
}

class Solution986_concise {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        for(int i = 0, j = 0; i < firstList.length && j < secondList.length; ){
            int firstLeft = firstList[i][0];
            int firstRight = firstList[i][1];
            int secondLeft = secondList[j][0];
            int secondRight = secondList[j][1];

            if (!(firstLeft > secondRight || firstRight < secondLeft)) {
                res.add(new int[]{Math.max(firstLeft, secondLeft), Math.min(firstRight, secondRight)});
            }
            if (firstRight == secondRight) {
                i++;
                j++;
            } else if (firstRight > secondRight){
                j++;
            } else if (firstRight < secondRight){
                i++;
            }
        }

        return res.stream().toArray(int[][]::new);
    }
}
