package dp;

// 377. Combination Sum IV
public class Solution377 {
    private Integer[][] memo;
    private int[] nums;
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        this.nums = nums;
        this.memo = new Integer[n][target+1];

        return dp(n-1, target);
    }

    private int dp(int i, int j){
        if(i < 0){
            return 0;
        }
        if (j == 0) {
            return 1;
        }
        if(j < 0){
            return 0;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        memo[i][j] = dp(i, j-nums[i]) + dp(i-1, j);

        return memo[i][j];
    }
}


class Solution377_dp {
    private Integer[] memo;
    private int[] nums;
    public int combinationSum4(int[] nums, int target) {
        this.memo = new Integer[target+1];
        memo[0] = 1;
        this.nums = nums;

        return dp(target);
    }

    private int dp(int j){
        if(j < 0){
            return 0;
        }
        if(memo[j] != null){
            return memo[j];
        }

        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(j >= nums[i]){
                res += dp(j - nums[i]);
            }
        }

        memo[j] = res;
        return res;
    }
}