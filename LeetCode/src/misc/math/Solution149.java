package misc.math;

import java.util.HashMap;
import java.util.Map;

// 149. Max Points on a Line
public class Solution149 {
    public int maxPoints(int[][] points) {
        int res = 0;
        for(int[] point1 : points){
            Map<Double, Integer> map = new HashMap<>();
            for(int[] point2 : points){
                if(point1 == point2){
                    continue;
                }
                double quotient = 0;
                if(point1[0] - point2[0] == 0) {
                    quotient = Double.MAX_VALUE;
                } else {
                    quotient = 1.0d * (point1[1] - point2[1]) / (point1[0] - point2[0]);
                }
                int value = map.getOrDefault(quotient, 0) + 1;
                res = Math.max(res, value);
                map.put(quotient, value);
            }
        }

        return res + 1;
    }
}


class Solution149_attempt1 {
    public int maxPoints(int[][] points) {
        int res = 0;
        for(int[] point1 : points){
            Map<Double, Integer> map = new HashMap<>();
            for(int[] point2 : points){
                if(point1 == point2){
                    continue;
                }
                double quotient = 0;
                if(point1[0] == point2[0]){
                    quotient = Double.MAX_VALUE;
                } else {
                    quotient = 1.0 * (point2[1] - point1[1]) / (point2[0] - point1[0]);
                }

                int value = map.getOrDefault(quotient, 0) + 1;
                map.put(quotient, value);

                res = Math.max(res, value);
            }
        }

        return res + 1;
    }
}