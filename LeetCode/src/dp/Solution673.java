package dp;

// 673. Number of Longest Increasing Subsequence
public class Solution673 {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][2];
        int maxLength = 1;
        dp[0] = new int[]{1, 1};

        for(int i = 1; i < n; i++){
            int preMaxLength = 0;
            int occur = 0;
            for(int j  = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(preMaxLength == dp[j][0]) {
                        occur += dp[j][1];
                    } else if (preMaxLength < dp[j][0]){
                        preMaxLength = dp[j][0];
                        occur = dp[j][1];
                    }
                }
            }

            dp[i][0] = 1 + preMaxLength;
            maxLength = Math.max(maxLength, dp[i][0]);
            if(occur == 0){
                occur = 1;
            }
            dp[i][1] = occur;
        }

        int res = 0;
        for(int i = 0; i < n; i++){
            if(dp[i][0] == maxLength){
                res += dp[i][1];
            }
        }

        return res;
    }
}
