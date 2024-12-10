package dp;

// 309. Best Time to Buy and Sell Stock with Cooldown
public class Solution309 {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length + 2][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[1][0] = 0;
        dp[1][1] = Integer.MIN_VALUE;

        for(int i = 2; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i - 2]);
        }

        return dp[prices.length + 1][0];
    }
}

class Solution309_attempt1 {
    private Integer[][] memo;
    private int[] prices;
    public int maxProfit(int[] prices) {
        this.memo = new Integer[prices.length][2];
        this.prices = prices;

        return dp(prices.length - 1, 0);
    }

    // 0 is not hold, 1 is hold
    private int dp(int i, int hold){
        if(i < 0){
            if(hold == 0){
                return 0;
            } else if(hold == 1) {
                return Integer.MIN_VALUE;
            }
        }

        if(memo[i][hold] != null){
            return memo[i][hold];
        }
        int res = 0;
        if(hold == 0) {
            res = Math.max(dp(i-1, 0),  dp(i-1, 1) + prices[i]);
        } else if(hold == 1) {
            res = Math.max(dp(i-1, 1), dp(i-2, 0) - prices[i]);
        }

        memo[i][hold] = res;
        return res;
    }
}

class Solution309_attempt1_bu {
    // 0 is not hold, 1 is hold
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 2][2];
        for(int i = 0; i <2; i++){
            dp[i][0] = 0;
            dp[i][1] = Integer.MIN_VALUE;
        }

        for(int i = 2; i < dp.length; i++){
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i-2]);
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i-2]);
        }

        return dp[prices.length + 1][0];
    }
}