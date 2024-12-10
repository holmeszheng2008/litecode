package dp;

import java.util.Arrays;

// 2616. Minimize the Maximum Difference of Pairs
public class Solution2616 {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] dp = new int[n+1][p+1];
        for(int j = 1; j < p+1; j++){
            dp[0][j] = Integer.MAX_VALUE;
            dp[1][j] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < n+1; i++){
            dp[i][0] = 0;
        }

        for(int i = 2; i < n+1; i++){
            for(int j = 1; j < p+1; j++){
                int res = Integer.MAX_VALUE;
                if(dp[i-2][j-1] != Integer.MAX_VALUE){
                    res = Math.min(res, Math.max(nums[i-1] - nums[i-2], dp[i-2][j-1]));
                }
                res = Math.min(res, dp[i-1][j]);
                dp[i][j] = res;
            }
        }

        return dp[n][p];
    }
}

// binary search
class Solution2616_pass {
    private int[] nums;
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        this.nums = nums;
        int n = nums.length;

        int left = 0, right = nums[n-1] - nums[0];
        while(left <= right){
            int middle = left + (right - left) / 2;
            int value = getMaxValidPairs(middle);
            if(value == p) {
                right = middle - 1;
            } else if(value < p){
                left = middle + 1;
            } else if(value > p){
                right = middle - 1;
            }
        }

        return left;
    }

    private int getMaxValidPairs(int diff){
        int count = 0;
        for(int i = 0; i < nums.length - 1;){
            if(nums[i+1] - nums[i] <= diff){
                count++;
                i+=2;
            } else {
                i++;
            }
        }

        return count;
    }
}