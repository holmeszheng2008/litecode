package dp;

// 931. Minimum Falling Path Sum
// Bottom Up
public class Solution931 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = matrix[n - 1][j];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int nextI = i + 1;
                int min = Integer.MAX_VALUE;
                for (int nextJ = j - 1; nextJ <= j + 1; nextJ++) {
                    if (nextJ < 0 || nextJ >= n) {
                        continue;
                    }
                    min = Math.min(min, dp[nextI][nextJ]);
                }

                dp[i][j] = matrix[i][j] + min;
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0, j = 0; j < n; j++) {
            res = Math.min(res, dp[i][j]);
        }

        return res;
    }
}


// Top Down
class Solution931_td {
    private Integer[][] memo;
    private int n;
    private int[][] matrix;
    public int minFallingPathSum(int[][] matrix) {
        this.matrix = matrix;
        this.n = matrix.length;
        this.memo = new Integer[n][n];

        for (int i = n - 1, j = 0; j < n; j++) {
            memo[i][j] = matrix[i][j];
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0, j = 0; j < n; j++) {
            res = Math.min(res, dp(i, j));
        }

        return res;
    }

    private int dp(int x, int y) {
        if (memo[x][y] != null) {
            return memo[x][y];
        }
        int min = Integer.MAX_VALUE;
        int nextX = x+1;
        for(int nextY = y - 1; nextY <= y+1; nextY++) {
            if (nextY < 0 || nextY > n - 1) {
                continue;
            }
            min = Math.min(min, dp(nextX, nextY));
        }

        memo[x][y] = matrix[x][y] + min;
        return memo[x][y];
    }
}


class temp {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int res = Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    res = Math.min(res, dp[i - 1][j - 1]);
                }
                if (j + 1 < n) {
                    res = Math.min(res, dp[i - 1][j + 1]);
                }
                res = Math.min(res, dp[i - 1][j]);

                dp[i][j] = res + matrix[i][j];
            }
        }

        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp[n - 1][j]);
        }

        return res;
    }
}
