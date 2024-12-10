package dp;

import java.util.Arrays;

// 1402. Reducing Dishes
public class Solution1402 {
    private int n;
    private Integer[][] memo;
    private int[] satisfaction;

    public int maxSatisfaction(int[] satisfaction) {
        this.n = satisfaction.length;
        Arrays.sort(satisfaction);
        this.satisfaction = satisfaction;
        this.memo = new Integer[n][n+1];


        return dp(0, 1);
    }

    private int dp(int index, int multiplier){
        if(index == n){
            return 0;
        }
        if(memo[index][multiplier] != null){
            return memo[index][multiplier];
        }

        int res;

        res = Math.max(satisfaction[index] * multiplier + dp(index+1, multiplier + 1), dp(index+1, multiplier));

        memo[index][multiplier] = res;

        return res;
    }
}

class Solution1402_bu {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int[][] dp = new int[n+1][n+2];
        Arrays.fill(dp[n], 0);

        for(int i = n-1; i >= 0; i--){
            for(int j = 1; j <= i+1; j++){
                dp[i][j] = Math.max(satisfaction[i] * j + dp[i+1][j+1], dp[i+1][j]);
            }
        }

        return dp[0][1];
    }
}