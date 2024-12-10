package misc;

// 73. Set Matrix Zeroes
public class Solution73 {
    public void setZeroes(int[][] matrix) {
        boolean rowContain = false, colContain = false;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    if(i == 0){
                        rowContain = true;
                    }
                    if (j == 0){
                        colContain = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                for(int j = 1; j < matrix[0].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j = 1; j < matrix[0].length; j++){
            if(matrix[0][j] == 0){
                for(int i = 1; i < matrix.length; i++){
                    matrix[i][j] = 0;
                }
            }
        }

        if(colContain){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
        if(rowContain){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }
    }
}

class Solution73_attempt1 {
    public void setZeroes(int[][] matrix) {
        boolean setFirstRow = false, setFirstCol = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0){
                setFirstCol = true;
                break;
            }
        }
        for(int j = 0; j < n; j++){
            if(matrix[0][j] == 0){
                setFirstRow = true;
                break;
            }
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < m; i++){
            if (matrix[i][0] == 0) {
                for(int j = 1; j < n; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j = 1; j < n; j++){
            if(matrix[0][j] == 0){
                for(int i = 1; i < m; i++){
                    matrix[i][j] = 0;
                }
            }
        }

        if(setFirstCol){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
        if(setFirstRow){
            for(int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }
    }
}