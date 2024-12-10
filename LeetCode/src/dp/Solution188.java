package dp;

// 188. Best Time to Buy and Sell Stock IV
// Bottom Up
public class Solution188 {
    public int maxProfit(int k, int[] prices) {
        int dp[][][] = new int[prices.length + 1][k + 1][2];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j][0] = 0;
            dp[0][j][1] = Integer.MIN_VALUE;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i - 1]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
            }
        }

        return dp[prices.length][k][0];
    }
}


// Top Down
class Solution188_td {
    private int[] prices;
    private Integer[][][] memo;
    public int maxProfit(int k, int[] prices) {
        this.prices = prices;
        this.memo = new Integer[prices.length][k + 1][2];

        return dp(prices.length - 1, k, 0);
    }

    private int dp(int index, int j, int hold) {
        if (index == -1) {
            if (hold == 0) {
                return 0;
            } else {
                return Integer.MIN_VALUE;
            }
        }
        if (j == 0) {
            if (hold == 0) {
                return 0;
            } else {
                return Integer.MIN_VALUE;
            }
        }

        if (memo[index][j][hold] != null) {
            return memo[index][j][hold];
        }

        int res = Integer.MIN_VALUE;
        if (hold == 0) {
            res = Math.max(dp(index - 1, j, hold), dp(index - 1, j, 1) + prices[index]);
        } else {
            res = Math.max(dp(index - 1, j, hold), dp(index - 1, j - 1, 0) - prices[index]);
        }

        memo[index][j][hold] = res;
        return res;
    }
}
