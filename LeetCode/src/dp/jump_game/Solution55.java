package dp.jump_game;

// 55. Jump Game
public class Solution55 {
    private int[] nums;
    private Boolean[] memo;
    public boolean canJump(int[] nums) {
        this.nums = nums;
        memo = new Boolean[nums.length];

        return dp(0);
    }

    private boolean dp(int index){
        if(index == nums.length - 1){
            return true;
        }

        if(index >= nums.length || nums[index] == 0){
            return false;
        }

        if (memo[index] != null){
            return memo[index];
        }

        boolean res = false;

        for(int i = 1; i <= nums[index]; i++){
            int nextIndex = i + index;
            if (nextIndex >= nums.length){
                break;
            }
            res = res | dp(nextIndex);
            if (res){
                break;
            }
        }

        memo[index] = res;
        return res;
    }
}


// Greedy
class Solution55_greedy {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for(int i =0; i < nums.length - 1; i++) {
            int nextMost = i + nums[i];
            farthest = Math.max(farthest, nextMost);
            if(farthest == i){
                // can't reach index i+1 anymore
                return false;
            }
        }

        return farthest >= nums.length - 1;
    }

}
