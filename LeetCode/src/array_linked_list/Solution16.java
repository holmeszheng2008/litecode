package array_linked_list;

import java.util.Arrays;

// 16. 3Sum Closest
public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0; i < nums.length - 2;){
            int left = i+1, right = nums.length - 1;
            while(left < right){
                int tempSum = nums[i] + nums[left] + nums[right];
                int tempDiff = tempSum - target;
                if(tempDiff == 0){
                    return target;
                }
                int tempDiffAbs = Math.abs(tempDiff);
                if(tempDiffAbs <= diff){
                    diff = tempDiffAbs;
                    res = tempSum;
                }

                if(tempDiff > 0){
                    right--;
                } else {
                    left++;
                }
            }

            i++;
            while(i != nums.length-2 && nums[i] == nums[i-1]){
                i++;
            }
        }

        return res;
    }
}
