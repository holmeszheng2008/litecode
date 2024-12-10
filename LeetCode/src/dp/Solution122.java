package dp;

// 122. Best Time to Buy and Sell Stock II
public class Solution122 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
        }

        return dp[prices.length][0];
    }
}


// Top Down
class Solution122_td {
    private int[] prices;
    private Integer[][] memo;
    public int maxProfit(int[] prices) {
        this.prices = prices;
        memo = new Integer[prices.length][2];

        return dp(prices.length - 1, 0);
    }

    private int dp(int i, int hold) {
        if (i == -1) {
            if (hold == 0) {
                return 0;
            } else {
                return Integer.MIN_VALUE;
            }
        }

        if (memo[i][hold] != null) {
            return memo[i][hold];
        }

        int res = 0;
        if (hold == 0) {
            res = Math.max(dp(i - 1, hold), dp(i - 1, 1) + prices[i]);
        } else {
            res = Math.max(dp(i - 1, hold), dp(i - 1, 0) - prices[i]);
        }

        memo[i][hold] = res;
        return res;
    }
}

class Solution122_attempt1 {
    int[] prices;
    Integer[][] memo;

    public int maxProfit(int[] prices) {
        this.prices = prices;
        this.memo = new Integer[prices.length][2];
        return dp(prices.length - 1, 0);
    }

    // 1 hold
    // 0 not hold
    private int dp(int i, int hold){
        if (i == 0){
            if (hold == 0){
                return 0;
            } else {
                return -prices[0];
            }
        }
        if (memo[i][hold] != null){
            return memo[i][hold];
        }
        int profit;
        int choice1 = dp(i-1, hold);
        int choice2 = 0;
        if (hold == 1) {
            choice2 = dp(i-1, 0) - prices[i];
        } else if (hold == 0){
            choice2 = dp(i-1, 1) + prices[i];
        }

        profit = Math.max(choice1, choice2);
        memo[i][hold] = profit;
        return profit;
    }
}


class Solution122_attempt1_bu {
    int[][] dp;
    public int maxProfit(int[] prices) {
        this.dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }

        return Math.max(dp[prices.length-1][0], dp[prices.length-1][1]);
    }
}

class Solution_attempt2 {
    private Integer[][] memo;
    private int[] prices;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        this.prices = prices;
        this.memo = new Integer[n][2];

        return dp(n - 1, 0);
    }

    // 0 -> not hold, 1 -> hold
    private int dp(int index, int hold){
        if(index == -1){
            if(hold == 0){
                return 0;
            } else {
                return Integer.MIN_VALUE;
            }
        }
        if(memo[index][hold] != null){
            return memo[index][hold];
        }

        int res = 0;
        if(hold == 0){
            res = Math.max(dp(index - 1, 0), dp(index - 1, 1) + prices[index]);
        } else {
            res = Math.max(dp(index-1, 1), dp(index - 1, 0) - prices[index]);
        }

        memo[index][hold] = res;
        return res;
    }
}

class Solution_attempt2_bu {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;

        for(int i = 1; i <= n; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i-1]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i-1]);
        }

        return dp[n][0];
    }
}