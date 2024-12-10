package dp;

import java.util.List;

// 120. Triangle
public class Solution120 {
    private List<List<Integer>> triangle;
    private Integer[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        this.memo = new Integer[n][n];
        this.triangle = triangle;

        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            res = Math.min(res, dp(n-1, i));
        }

        return res;
    }

    private int dp(int level, int index) {
        if(level == 0){
            return triangle.get(0).get(0);
        }
        if(memo[level][index] != null){
            return memo[level][index];
        }

        int res = triangle.get(level).get(index);
        if(index == 0){
            res += dp(level - 1, index);
        } else {
            if(level == index){
                res += dp(level - 1, index - 1);
            } else {
                res += Math.min(dp(level - 1, index), dp(level - 1, index - 1));
            }
        }

        memo[level][index] = res;
        return res;
    }
}

class Solution120_attempt1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);

        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++) {
                int num = triangle.get(i).get(j);
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + num;
                } else if (i == j) {
                    dp[i][j] = dp[i-1][j-1] + num;
                } else {
                    dp[i][j] = num + Math.min(dp[i-1][j], dp[i-1][j-1]);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            res = Math.min(dp[n-1][i], res);
        }

        return res;
    }
}