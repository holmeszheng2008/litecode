package array_linked_list.two_pointers.left_right_pointers;

// 41. First Missing Positive
/*
use right pointer to store garbage
1. index already taken by same number (duplicate)
2. num < 0
3. num > nums.length
 */
public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int num = nums[left];
            int targetIndex = num-1;
            if(num <= 0 || num > nums.length || (left != targetIndex && nums[targetIndex] == num)) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            } else if (left == targetIndex && nums[targetIndex] == num){
                left++;
            } else{
                int temp = nums[left];
                nums[left] = nums[targetIndex];
                nums[targetIndex] = temp;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1){
                return i+1;
            }
        }

        return nums.length + 1;
    }
}

class Solution41_attempt1 {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length;){
            int targetIndex = nums[i] - 1;
            if(targetIndex < 0){
                i++;
                continue;
            }
            if(targetIndex >= nums.length){
                i++;
                continue;
            }
            if(nums[targetIndex] == targetIndex+1){
                i++;
                continue;
            }

            int temp = nums[i];
            nums[i] = nums[targetIndex];
            nums[targetIndex] = temp;
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return nums.length + 1;
    }
}
