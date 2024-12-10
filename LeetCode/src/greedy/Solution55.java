package greedy;

// 55. Jump Game
class Solution55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest <= i) {
                return false;
            }
        }
        return farthest >= n - 1;
    }
}

class Solution {
    public boolean canJump(int[] nums) {
        int left = 0, right = 0;
        int rightMax = 0;
        while(true){
            for(int i = left; i <= right; i++){
                rightMax = Math.max(rightMax, i + nums[i]);
            }
            if(rightMax >= nums.length -1){
                return true;
            }
            if(rightMax == right){
                return false;
            }
            left = right + 1;
            right = rightMax;
        }
    }
}