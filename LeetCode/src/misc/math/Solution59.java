package misc.math;

// 59. Spiral Matrix II
public class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix= new int[n][n];
        int lastStep = (n-1) / 2;
        int num = 1;
        for(int step = 0; step <= lastStep; step++) {
            int initI = step, initJ = step;
            int maxI = n-1-step, maxJ = n-1-step;

            if(initI == maxI){
                matrix[initI][initJ] = num++;
            } else {
                for(int i = initI, j = initJ; j < maxJ; j++){
                    matrix[i][j] = num++;
                }
                for(int i = initI, j = maxJ; i < maxI; i++){
                    matrix[i][j] = num++;
                }
                for(int i = maxI, j = maxJ; j > initJ; j--){
                    matrix[i][j] = num++;
                }
                for(int i = maxI, j = initJ; i > initI; i--){
                    matrix[i][j] = num++;
                }
            }
        }

        return matrix;
    }
}

class Solution59_attempt1 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 1;
        for(int step = 0; step <= (n-1)/ 2; step++){
            int left = step, right = n-1-step, top = step, bottom = n-1-step;
            if(left == right){
                res[step][step] = num;
            } else {
                for(int i = top, j = left; j < right; j++){
                    res[i][j] = num;
                    num++;
                }
                for(int i = top, j = right; i < bottom; i++){
                    res[i][j] = num;
                    num++;
                }
                for(int i = bottom, j = right; j > left; j--){
                    res[i][j] = num;
                    num++;
                }
                for(int i = bottom, j = left; i > top; i--){
                    res[i][j] = num;
                    num++;
                }
            }
        }

        return res;
    }
}