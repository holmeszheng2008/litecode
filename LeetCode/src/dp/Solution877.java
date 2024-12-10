package dp;

// 877. Stone Game
public class Solution877 {
    public boolean stoneGame(int[] piles) {
        int[][][] dp = new int[piles.length][piles.length][2];
        for (int i = 0; i < piles.length; i++) {
            dp[i][i][0] = piles[i];
            dp[i][i][1] = 0;
        }
        // 遍历方向： 由下向上
        // for (int i = piles.length - 1; i >= 0; i--) {
        // for (int j = i + 1; j < piles.length; j++) {
        // int op1 = dp[i + 1][j][1] + piles[i];
        // int op2 = dp[i][j - 1][1] + piles[j];
        // if (op1 > op2) {
        // dp[i][j][0] = op1;
        // dp[i][j][1] = dp[i + 1][j][0];
        // } else {
        // dp[i][j][0] = op2;
        // dp[i][j][1] = dp[i][j - 1][0];
        // }
        // }
        // }

        // 遍历方向： 斜着
        for (int k = 1; k < piles.length; k++) {
            for (int i = 0; i < piles.length - k; i++) {
                int j = i + k;
                int op1 = dp[i + 1][j][1] + piles[i];
                int op2 = dp[i][j - 1][1] + piles[j];
                if (op1 > op2) {
                    dp[i][j][0] = op1;
                    dp[i][j][1] = dp[i + 1][j][0];
                } else {
                    dp[i][j][0] = op2;
                    dp[i][j][1] = dp[i][j - 1][0];
                }
            }
        }

        if (dp[0][piles.length - 1][0] >= dp[0][piles.length - 1][1]) {
            return true;
        }
        return false;
    }
}