package dp;

import java.util.ArrayList;
import java.util.List;

// 322. Coin Change
public class Solution322 {
    private int[] memo;
    private List<Integer> coinList = new ArrayList<>();

    public int coinChange(int[] coins, int amount) {
        this.memo = new int[amount + 1];
        for (int coin : coins) {
            if (coin <= amount) {
                coinList.add(coin);
                memo[coin] = 1;
            }
        }

        int res = dp(amount);
        if (res == Integer.MAX_VALUE) {
            return -1;
        } else {
            return res;
        }
    }

    private int dp(int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (memo[amount] != 0) {
            return memo[amount];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coinList) {
            int res = dp(amount - coin);
            min = Math.min(res, min);
        }

        if (min == Integer.MAX_VALUE) {
            memo[amount] = Integer.MAX_VALUE;
        } else {
            memo[amount] = 1 + min;
        }

        return memo[amount];
    }
}


// bottom up
class Solution322_bu {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for(int coin : coins) {
                if (coin > i) {
                    continue;
                }
                min = Math.min(min, dp[i - coin]);
            }
            if (min == Integer.MAX_VALUE) {
                dp[i] = Integer.MAX_VALUE;
            } else {
                dp[i] = 1 + min;
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}


// Top Down
class way2 {
    private Integer[][] memo;
    private int[] coins;

    public int coinChange(int[] coins, int amount) {
        this.memo = new Integer[coins.length][amount + 1];
        this.coins = coins;

        int res = dp(coins.length - 1, amount);
        return res;
    }

    private int dp(int index, int amount) {
        if (index == -1) {
            return -1;
        }
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        if (memo[index][amount] != null) {
            return memo[index][amount];
        }

        int res1 = dp(index - 1, amount);
        int res2 = dp(index, amount - coins[index]);
        if (res1 == -1 && res2 == -1) {
            memo[index][amount] = -1;
        } else if (res1 == -1) {
            memo[index][amount] = res2 + 1;
        } else if (res2 == -1) {
            memo[index][amount] = res1;
        } else {
            memo[index][amount] = Math.min(res1, res2 + 1);
        }

        return memo[index][amount];
    }
}


// Bottom Up
class way2_2 {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    int choice1 = dp[i - 1][j];
                    int choice2 = dp[i][j - coins[i - 1]];
                    if (choice2 == Integer.MAX_VALUE) {
                        dp[i][j] = choice1;
                    } else {
                        dp[i][j] = Math.min(choice1, 1 + choice2);
                    }
                }
            }
        }

        return dp[coins.length][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length][amount];
    }
}

class Solution322_attempt1 {
    int[] coins;
    //Map<Pair<Integer, Integer>, Integer> memo = new HashMap<>();
    Integer[][] memo;
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.memo = new Integer[coins.length][amount+1];

        int res = dp(0, amount);
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

    private int dp(int i, int remain){
        if(remain == 0) {
            return 0;
        }
        if(i == coins.length){
            return Integer.MAX_VALUE;
        }

        if(memo[i][remain] != null){
            return memo[i][remain];
        }
        int res = Integer.MAX_VALUE;
        for(int num = 0; ; num++){
            long newRemain = remain - coins[i] * num *1l;
            if(newRemain < 0){
                break;
            }

            int temp = dp(i + 1, (int)newRemain);
            if(temp != Integer.MAX_VALUE){
                temp += num;
            }
            res = Math.min(res, temp);
        }

        memo[i][remain] = res;
        return res;
    }
}