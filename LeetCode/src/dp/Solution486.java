package dp;

// 486. Predict the Winner
public class Solution486 {
    public boolean PredictTheWinner(int[] nums) {
        int[][][] dp = new int[nums.length][nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i][0] = nums[i];
            dp[i][i][1] = 0;
        }

        // 斜着遍历
        // for (int k = 1; k < nums.length; k++) {
        // for (int i = 0; i < nums.length - k; i++) {
        // int j = i + k;
        // int opt1 = dp[i + 1][j][1] + nums[i];
        // int opt2 = dp[i][j - 1][1] + nums[j];
        // if (opt1 > opt2) {
        // dp[i][j][0] = opt1;
        // dp[i][j][1] = dp[i + 1][j][0];
        // } else {
        // dp[i][j][0] = opt2;
        // dp[i][j][1] = dp[i][j - 1][0];
        // }
        // }
        // }

        // 倒着遍历
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                int opt1 = dp[i + 1][j][1] + nums[i];
                int opt2 = dp[i][j - 1][1] + nums[j];
                if (opt1 > opt2) {
                    dp[i][j][0] = opt1;
                    dp[i][j][1] = dp[i + 1][j][0];
                } else {
                    dp[i][j][0] = opt2;
                    dp[i][j][1] = dp[i][j - 1][0];
                }
            }
        }
        int diff = dp[0][nums.length - 1][0] - dp[0][nums.length - 1][1];
        if (diff >= 0) {
            return true;
        } else {
            return false;
        }
    }
}
