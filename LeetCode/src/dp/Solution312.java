package dp;

// 312. Burst Balloons
// Diagonal
public class Solution312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] points = new int[n+2];
        for(int i = 1; i < n+1; i++){
            points[i] = nums[i-1];
        }
        points[0] = 1;
        points[n+1] = 1;

        int[][] dp = new int[n+2][n+2];

        for(int diff = 2; diff <= n+1; diff++){
            for(int i = 0, j = i+diff; j <= n+1; i++, j++){
                for(int k = i+1; k < j; k++){
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[i] * points[k] * points[j]);
                }
            }
        }

        return dp[0][n+1];
    }
}

// Bottom to up, left to right
class Solution312_attempt1 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] points = new int[n+2];
        for(int i = 1; i < n+1; i++){
            points[i] = nums[i-1];
        }
        points[0] = 1;
        points[n+1] = 1;

        int[][] dp = new int[n+2][n+2];

        for(int i = n-1; i >= 0; i--){
            for(int j = i+2; j <= n+1; j++){
                for(int k = i+1; k < j; k++){
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[i] * points[k] * points[j]);
                }
            }
        }

        return dp[0][n+1];
    }
}
