package bit_operation;

// 287. Find the Duplicate Number
public class Solution287 {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length;){
            int value = nums[i];
            if(i == value) {
                i++;
                continue;
            }

            if(nums[value] == value){
                return value;
            }

            nums[i] = nums[value];
            nums[value] = value;
        }

        return -1;
    }
}
