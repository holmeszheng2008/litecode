package dp;

// 198. House Robber
// Bottom Up
public class Solution198 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 2];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 2]);
        }

        return dp[nums.length + 1];
    }
}


// Top Down
class Solution198_td {
    private int[] nums;
    private Integer[] memo;
    public int rob(int[] nums) {
        this.memo = new Integer[nums.length];
        this.nums = nums;

        return dp(nums.length - 1);
    }

    int dp(int index) {
        if (index < 0) {
            return 0;
        }
        if (memo[index] != null) {
            return memo[index];
        }

        int res = Math.max(dp(index - 1), dp(index - 2) + nums[index]);
        memo[index] = res;
        return res;
    }
}


class Solution198_attempt2 {
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][2];
        for(int i = 1; i < n+1; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i-1];
        }

        return Math.max(dp[n][0], dp[n][1]);
    }
}

class Solution198_attempt3 {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+2];
        for(int i = n-1; i >= 0; i--){
            dp[i] = Math.max(dp[i+1], dp[i+2] + nums[i]);
        }

        return dp[0];
    }
}