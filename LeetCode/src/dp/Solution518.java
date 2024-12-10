package dp;

// 518. Coin Change 2
public class Solution518 {
    private Integer[][] memo;
    private int[] coins;
    public int change(int amount, int[] coins) {
        this.coins = coins;
        this.memo = new Integer[coins.length][amount + 1];

        return dp(coins.length - 1, amount);
    }

    private int dp(int index, int amount) {
        if (index == -1) {
            return 0;
        }
        if (amount == 0) {
            return 1;
        }
        if (amount < 0) {
            return 0;
        }
        if (memo[index][amount] != null) {
            return memo[index][amount];
        }
        int choice1 = dp(index, amount - coins[index]);
        int choice2 = dp(index - 1, amount);
        int res = choice1 + choice2;
        memo[index][amount] = res;

        return res;
    }
}


class Solution518_bu {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length + 1][amount + 1];
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[coins.length][amount];
    }
}


class Solution518_attempt1 {
    int[] coins;
    Integer[][] memo;
    public int change(int amount, int[] coins) {
        this.coins = coins;
        this.memo = new Integer[amount + 1][coins.length];

        return dp(amount, 0);
    }

    private int dp(int remain, int i){
        if (remain == 0){
            return 1;
        }
        if(i == coins.length){
            return 0;
        }

        if(memo[remain][i] != null){
            return memo[remain][i];
        }
        int res = 0;
        for(int num = 0; ;num++){
            int newRemain = remain - num * coins[i];
            if(newRemain < 0){
                break;
            }

            res += dp(newRemain, i+1);
        }

        memo[remain][i] = res;
        return res;
    }
}
