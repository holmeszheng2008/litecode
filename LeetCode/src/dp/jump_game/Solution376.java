package dp.jump_game;

// 376. Wiggle Subsequence
public class Solution376 {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        // 0 larger than previous, 1 smaller than previous
        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = 1;

        int res = 1;
        for(int i = 1; i < n; i++){
            int max0 = 1, max1 = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]) {
                    max0 = Math.max(max0, 1 + dp[j][1]);
                } else if (nums[j] > nums[i]){
                    max1 = Math.max(max1, 1 + dp[j][0]);
                }
            }
            dp[i][0] = max0;
            dp[i][1] = max1;
            res = Math.max(res, Math.max(max0, max1));
        }

        return res;
    }
}
