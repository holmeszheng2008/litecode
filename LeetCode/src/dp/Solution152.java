package dp;

// 152. Maximum Product Subarray
public class Solution152 {
    public int maxProduct(int[] nums) {
        int res = nums[0];

        int n = nums.length;
        int[] dpMin = new int[n];
        int[] dpMax = new int[n];

        dpMin[0] = nums[0];
        dpMax[0] = nums[0];

        for(int i = 1; i < n; i++){
            dpMax[i] = Math.max(nums[i], Math.max(nums[i] * dpMax[i-1], nums[i] * dpMin[i-1]));
            dpMin[i] = Math.min(nums[i], Math.min(nums[i] * dpMin[i-1], nums[i] * dpMax[i-1]));

            res = Math.max(res, dpMax[i]);
        }

        return res;
    }
}
