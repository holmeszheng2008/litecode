package misc.math;

// 645. Set Mismatch
public class Solution645 {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            int num = Math.abs(nums[i]);
            int index = num - 1;
            if (nums[index] > 0){
                nums[index] = -nums[index];
            } else {
                res[0] = num;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if (nums[i] > 0){
                res[1] = i + 1;
            }
        }

        return res;
    }
}
