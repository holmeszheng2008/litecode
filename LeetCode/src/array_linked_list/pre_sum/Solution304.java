package array_linked_list.pre_sum;

public class Solution304 {

}


class NumMatrix {
    private int[][] preSum;

    public NumMatrix(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        preSum = new int[rowLength][colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                int a = 0;
                int b = 0;
                int c = 0;
                if (i - 1 >= 0) {
                    a = preSum[i - 1][j];
                }
                if (j - 1 >= 0) {
                    b = preSum[i][j - 1];
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    c = preSum[i - 1][j - 1];
                }
                preSum[i][j] = a + b - c + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int a = 0, b = 0, c = 0;
        if (row1 - 1 >= 0) {
            a = preSum[row1 - 1][col2];
        }
        if (col1 - 1 >= 0) {
            b = preSum[row2][col1 - 1];
        }
        if (row1 - 1 >= 0 && col1 - 1 >= 0) {
            c = preSum[row1 - 1][col1 - 1];
        }
        return preSum[row2][col2] - a - b + c;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such: NumMatrix obj = new
 * NumMatrix(matrix); int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
