package dp;

// 416. Partition Equal Subset Sum
// Top Down
public class Solution416 {
    private Boolean[][] memo;
    private int[] nums;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        this.memo = new Boolean[nums.length][target + 1];
        this.nums = nums;

        return dp(nums.length - 1, target);
    }

    public boolean dp(int index, int target) {
        if (target == 0) {
            return true;
        }
        if (index == -1) {
            return false;
        }

        if (memo[index][target] != null) {
            return memo[index][target];
        }

        boolean res = false;
        if (target < nums[index]) {
            res = dp(index - 1, target);
        } else {
            res = dp(index - 1, target) || dp(index - 1, target - nums[index]);
        }

        memo[index][target] = res;

        return res;
    }
}


// Bottom Up
class Solution416_bu {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        boolean dp[][] = new boolean[nums.length + 1][target + 1];

        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = false;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                }
            }
        }

        return dp[nums.length][target];
    }
}

class Solution416_attempt1 {
    Boolean[][] memo;
    int[] nums;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0){
            return false;
        }

        this.nums = nums;
        int target = sum/2;
        this.memo = new Boolean[nums.length][target+1];

        return dp(nums.length - 1, target);
    }

    private boolean dp(int i, int remain){
        if(remain == 0){
            return true;
        }
        if(i == -1){
            return false;
        }

        if(memo[i][remain] != null) {
            return memo[i][remain];
        }

        boolean res;

        if(remain - nums[i] < 0){
            res = dp(i-1, remain);
        } else {
            res = dp(i-1, remain) || dp(i-1, remain - nums[i]);
        }

        memo[i][remain] = res;
        return res;
    }
}

class Solution416_attempt1_bu {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0){
            return false;
        }

        int target = sum/2;
        boolean[][] dp = new boolean[nums.length + 1][target+1];

        for(int i =0; i < dp.length; i++){
            dp[i][0] = true;
        }
        for(int i =1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++){
                int num = nums[i-1];
                if(j - num >= 0){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-num];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[nums.length][target];
    }
}