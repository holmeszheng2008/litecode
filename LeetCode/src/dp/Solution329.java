package dp;

// 329. Longest Increasing Path in a Matrix
public class Solution329 {
    private int m;
    private int n;
    private int[][] matrix;
    private Integer[][] memo;
    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        this.m = matrix.length;
        this.n = matrix[0].length;
        this.memo = new Integer[m][n];
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                res = Math.max(res, dp(i, j));
            }
        }

        return res;
    }

    // start with (i,j)
    private int dp(int i, int j){
        if(memo[i][j] != null){
            return memo[i][j];
        }
        int res = 1;
        int curValue = matrix[i][j];
        if(i != 0){
            if(curValue < matrix[i-1][j]){
                res = Math.max(res, 1 + dp(i-1, j));
            }
        }
        if(i != m-1){
            if(curValue < matrix[i+1][j]){
                res = Math.max(res, 1 + dp(i+1, j));
            }
        }
        if(j != 0){
            if(curValue < matrix[i][j-1]){
                res = Math.max(res, 1 + dp(i, j-1));
            }
        }
        if(j != n-1){
            if(curValue < matrix[i][j+1]){
                res = Math.max(res, 1 + dp(i, j+1));
            }
        }

        memo[i][j] = res;
        return res;
    }
}
