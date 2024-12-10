package dp;

// 53. Maximum Subarray
public class Solution53 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}


// PreSum O(n^2)
class Solution53_attempt1 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] preSums = new int[n+1];
        for(int i = 1; i < preSums.length; i++){
            preSums[i] = preSums[i-1] + nums[i-1];
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < preSums.length; i++){
            for(int j = i+1; j < preSums.length; j++) {
                int temp = preSums[j] - preSums[i];
                max = Math.max(temp, max);
            }
        }

        return max;
    }
}

// PreSum O(n) Optimization
class Solution53_attempt2 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] preSums = new int[n+1];
        for(int i = 1; i < preSums.length; i++){
            preSums[i] = preSums[i-1] + nums[i-1];
        }


        int min = preSums[0];
        int res = Integer.MIN_VALUE;

        for(int i = 1; i < preSums.length; i++){
            res = Math.max(res, preSums[i] - min);
            min = Math.min(min, preSums[i]);
        }

        return res;
    }
}


class Solution53_attempt3 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}

