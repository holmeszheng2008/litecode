package array_linked_list.two_pointers.fast_slow_pointers;

// 75. Sort Colors
public class Solution75 {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, fast = left;
        while(fast <= right){
            if(nums[fast] == 0){
                int temp = nums[fast];
                nums[fast] = nums[left];
                nums[left] = temp;
                left++;
                fast = Math.max(fast, left);
            } else if (nums[fast] == 2){
                int temp = nums[fast];
                nums[fast] = nums[right];
                nums[right] = temp;
                right--;
            } else {
                fast++;
            }
        }
    }
}
