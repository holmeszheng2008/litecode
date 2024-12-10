package backtracking;

import java.util.Arrays;

// 31. Next Permutation
public class Solution31 {
    public void nextPermutation(int[] nums) {
        for(int i = nums.length - 1; i >= 0; i--){
            int num = nums[i];
            int greaterNum = Integer.MAX_VALUE;
            int greaterIndex = -1;
            for(int j = i+1; j < nums.length; j++){
                if(nums[j] > num){
                    if(greaterNum > nums[j]){
                        greaterNum = nums[j];
                        greaterIndex = j;
                    }
                }
            }
            if(greaterIndex == -1) {
                continue;
            }

            int temp = nums[i];
            nums[i] = nums[greaterIndex];
            nums[greaterIndex] = temp;

            Arrays.sort(nums, i+1, nums.length);
            return;
        }

        Arrays.sort(nums, 0, nums.length);
    }
}

class Solution31_attempt1 {
    public void nextPermutation(int[] nums) {
        for(int i = nums.length - 2; i >= 0; i--){
            for(int j = nums.length - 1; j > i; j--) {
                if(nums[j] > nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    Arrays.sort(nums, i+1, nums.length);
                    return;
                }
            }
        }
        Arrays.sort(nums, 0, nums.length);
    }
}
