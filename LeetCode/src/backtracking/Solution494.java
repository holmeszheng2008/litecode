package backtracking;

import util.Pair;

import java.util.HashMap;
import java.util.Map;

// 494. Target Sum
// backtracking, no optimization
public class Solution494 {
    int res;
    int[] nums;
    int target;
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        backtracking(0, 0);

        return res;
    }

    private void backtracking(int i, int preSum){
        if (i == nums.length) {
            return;
        }

        //+
        preSum += nums[i];
        if(preSum == target && i == nums.length - 1){
            res++;
        } else {
            backtracking(i + 1, preSum);
        }
        preSum -= nums[i];
        //-
        preSum -= nums[i];
        if (preSum == target && i == nums.length - 1){
            res++;
        } else {
            backtracking(i + 1, preSum);
        }
        preSum += nums[i];
    }

}


class Solution494_dp {
    int[] nums;
    int target;
    private Map<String, Integer> memo = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        return dp(nums.length-1, 0);
    }

    private int dp(int i, int sum){
        if(i == -1){
            if(sum == target){
                return 1;
            }
            return 0;
        }

        String state = i + "," + sum;
        if(memo.containsKey(state)){
            return memo.get(state);
        }

       int res = dp(i-1, sum - nums[i]) + dp(i-1, sum + nums[i]);

        memo.put(state, res);
        return res;
    }
}

class Solution494_dp2 {
    int[] nums;
    int target;
    private Map<String, Integer> memo = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        return dp(0, 0);
    }

    private int dp(int i, int sum){
        if(i == nums.length && sum == target){
            return 1;
        }
        if (i == nums.length){
            return 0;
        }

        String state = i + "," + sum;
        if(memo.containsKey(state)){
            return memo.get(state);
        }
        int res = dp(i + 1, sum - nums[i]) + dp(i+1, sum+nums[i]);

        memo.put(state, res);
        return res;

    }
}

// 转化为子集划分问题
class Solution494_dp3 {
    int newTarget;
    int[] nums;
    private Integer[][] memo;
    // A 中元素的和为 (target + sum(nums)) / 2？
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        if ((target + sum) % 2 != 0 || (target + sum) < 0) {
            return 0;
        }

        this.newTarget = (target + sum) / 2;
        this.nums = nums;
        this.memo = new Integer[nums.length][newTarget + 1];

        return dp(0, 0);
    }

    private int dp(int i, int sum){
        if (i == nums.length) {
            if(sum == newTarget){
                return 1;
            }
            return 0;
        }

        if(memo[i][sum] != null){
            return memo[i][sum];
        }

        int res = 0;
        if(sum + nums[i] > newTarget){
            res = dp(i + 1, sum);
        } else {
            res = dp(i + 1, sum) + dp(i+1, sum + nums[i]);
        }

        memo[i][sum] = res;
        return res;
    }
}

// 转化为子集划分问题
class Solution494_dp3_bu {
    // A 中元素的和为 (target + sum(nums)) / 2？
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        if ((target + sum) % 2 != 0 || (target + sum) < 0) {
            return 0;
        }

        int newTarget = (target + sum) / 2;
        int[][] dp = new int[nums.length + 1][newTarget + 1];
        dp[0][0] = 1;

        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                int num = nums[i-1];
                if(j < num){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-num];
                }
            }
        }

        return dp[nums.length][newTarget];
    }
}

class Solution_attempt1_backtracking {
    private int[] nums;
    private int path;
    private int target;
    private int res;
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        backtracking(0);
        return res;
    }

    private void backtracking(int index){
        if(index == nums.length){
            return;
        }

        path += nums[index];
        if(path == target && index == nums.length - 1){
            res++;
        } else {
            backtracking(index+1);
        }
        path -= nums[index];


        path -= nums[index];
        if(path == target && index == nums.length - 1){
            res++;
        } else {
            backtracking(index+1);
        }
        path += nums[index];
    }
}

class Solution_attempt1_dp {
    private int[] nums;
    private Map<Pair<Integer, Integer>, Integer> memo;
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.memo = new HashMap<>();

        return dp(0, target);
    }

    private int dp(int index, int remain){
        if(index == nums.length){
            if(remain == 0){
                return 1;
            } else {
                return 0;
            }
        }

        Pair<Integer, Integer> key = new Pair<>(index, remain);

        if(memo.get(key) != null){
            return memo.get(key);
        }

        int res;
        res = dp(index+1, remain - nums[index]) + dp(index+1, remain + nums[index]);

        memo.put(key, res);

        return res;
    }
}

class Solution494_attempt2_td {
    private Map<String, Integer> memo = new HashMap<>();
    private int[] nums;
    private int target;

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        return dp(0, 0);
    }

    private int dp(int i, int sum){
        if(i == nums.length) {
            if(sum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        String key = i + "," + sum;
        if(memo.get(key) != null){
            return memo.get(key);
        }

        int res = dp(i + 1, sum - nums[i]) + dp(i+1, sum + nums[i]);
        memo.put(key, res);

        return res;
    }
}

class Solution494_attempt2_backtracking {
    private int res;
    private int[] nums;
    private int target;

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        backtracking(0, 0);
        return res;
    }

    private void backtracking(int index, int sum){
        sum = sum - nums[index];
        if(index == nums.length-1) {
            if (sum == target) {
                res++;
            }
        } else {
            backtracking(index+1, sum);
        }
        sum = sum + nums[index];

        sum += nums[index];
        if(index == nums.length-1) {
            if (sum == target) {
                res++;
            }
        } else {
            backtracking(index+1, sum);
        }
        sum -= nums[index];
    }
}