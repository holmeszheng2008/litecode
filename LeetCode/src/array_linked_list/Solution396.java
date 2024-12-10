package array_linked_list;

// 396. Rotate Function
public class Solution396 {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[0] += i * nums[i];
        }

        int res = dp[0];
        for(int i = 1; i < n; i++){
            dp[i] = sum - n * nums[n-i] + dp[i-1];
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
