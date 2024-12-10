package dp;

import util.Pair;

// 279. Perfect Squares
public class Solution279 {
    private Integer[][] memo;
    public int numSquares(int n) {
        int maxNum = (int)Math.sqrt(n);
        this.memo = new Integer[maxNum + 1][n + 1];

        return dp(maxNum, n);
    }

    private int dp(int index, int sum) {
        if(sum == 0){
            return 0;
        }
        if(index == 1) {
            return sum;
        }

        Pair<Integer, Integer> key = new Pair<>(index, sum);
        if(memo[index][sum] != null) {
            return memo[index][sum];
        }
        int res = Integer.MAX_VALUE;
        if(sum - index * index >= 0){
            res = Math.min(Math.min(dp(index - 1, sum), 1 + dp(index - 1, sum - index * index)), 1 + dp(index, sum - index * index));
        } else {
            res = dp(index - 1, sum);
        }

        memo[index][sum] = res;
        return res;
    }
}

class Solution279_attempt1 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i = 1; i <= n; i++){
            int res = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++){
                res = Math.min(res, dp[i - j*j]);
            }
            dp[i] = res + 1;
        }

        return dp[n];
    }
}