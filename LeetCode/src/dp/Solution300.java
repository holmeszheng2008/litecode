package dp;

// 300. Longest Increasing Subsequence
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int preMax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    preMax = Math.max(preMax, dp[j]);
                }
            }
            dp[i] = preMax + 1;
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}

class Solution300_attempt1 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int res = 1;
        for(int i = 1; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            res = Math.max(res, dp[i]);
        }

        return res;
    }
}