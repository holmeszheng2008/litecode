package misc.math;

import java.util.LinkedList;
import java.util.List;

// 54. Spiral Matrix
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList<Integer> res = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int maxStep = (Math.min(m, n) - 1) / 2;
        for(int step = 0; step <= maxStep; step++){
            int initI = step, initJ = step;
            int maxI = m - 1 - step;
            int maxJ = n - 1 - step;
            if(initI == maxI){
                for(int i = initI, j = initJ; j <= maxJ; j++){
                    res.addLast(matrix[i][j]);
                }
            } else if (initJ == maxJ){
                for(int i = initI, j = initJ; i <= maxI; i++){
                    res.addLast(matrix[i][j]);
                }
            } else {
                for(int i = initI, j = initJ; j < maxJ; j++){
                    res.addLast(matrix[i][j]);
                }

                for(int i = initI, j = maxJ; i < maxI; i++){
                    res.addLast(matrix[i][j]);
                }

                for(int i = maxI, j = maxJ; j > initJ; j--){
                    res.addLast(matrix[i][j]);
                }

                for(int i = maxI, j = initJ; i > initI; i--){
                    res.addLast(matrix[i][j]);
                }
            }
        }

        return res;
    }
}
