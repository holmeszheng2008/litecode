package dp.jump_game;

// 45. Jump Game II
public class Solution45 {
    private int[] nums;
    private Integer[] memo;

    public int jump(int[] nums) {
        this.nums = nums;
        memo = new Integer[nums.length];

        return dp(0);
    }

    private int dp(int index){
        if (index == nums.length - 1) {
            return 0;
        }

        if (nums[index] == 0){
            return Integer.MAX_VALUE;
        }

        if(memo[index] != null){
            return memo[index];
        }

        int res = Integer.MAX_VALUE;
        for(int i = 1; i < nums[index]; i++){
            int nextIndex = i + index;
            if (nextIndex >= nums.length){
                break;
            }

            int temp = dp(nextIndex);
            if (temp != Integer.MAX_VALUE){
                res = Math.min(res, temp + 1);
            }
        }

        memo[index] = res;
        return res;
    }
}

class Solution45_greedy {
    public int jump(int[] nums) {
        int jumps = 0, end = 0, farthest = 0;
        for(int i = 0; i < nums.length - 1;){
            for(int j = i; j <= end; j++){
                farthest = Math.max(farthest, j + nums[j]);
            }

            jumps++;
            if (farthest >= nums.length - 1){
                return jumps;
            }
            if (farthest <= end){
                return -1;
            }

            i = end + 1;
            end = farthest;
        }

        return jumps;
    }
}

class Solution45_attempt1 {
    public int jump(int[] nums) {
        int left = 0, right = 0;
        int steps = 0;
        int rightMax = 0;
        while(true){
            if(right >= nums.length - 1){
                return steps;
            }

            steps++;
            for(int i = left; i <= right; i++){
                rightMax = Math.max(rightMax, nums[i] + i);
            }
            left = right + 1;
            if(right == rightMax){
                return -1;
            }
            right= rightMax;
        }
    }
}