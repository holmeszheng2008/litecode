package dp;

// 213. House Robber II
public class Solution213 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int start, int end) {
        int[] dp = new int[end + 1 - start + 2];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 2 + start]);
        }

        return dp[dp.length - 1];
    }
}

class Solution213_attempt1 {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        return Math.max(robMax(0, nums.length - 2, nums), robMax(1, nums.length - 1, nums));
    }

    private int robMax(int start, int end, int[] nums){
        int n = end - start + 1;
        int[] dp = new int[n + 2];
        for(int i = 2; i < n+2; i++){
            int index = i - 2 + start;
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[index]);
        }

        return dp[n+1];
    }
}

class Solution213_attempt2 {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        return Math.max(robMax(0, nums.length - 2, nums), robMax(1, nums.length - 1, nums));
    }

    // 0 -> not take
    // 1 -> take
    private int robMax(int start, int end, int[] nums){
        int n = end - start + 1;
        int[][] dp = new int[n+1][2];
        for(int i = 1; i < n+1; i++){
            int index = i - 1 + start;
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = nums[index] + dp[i-1][0];
        }

        return Math.max(dp[n][0], dp[n][1]);
    }
}