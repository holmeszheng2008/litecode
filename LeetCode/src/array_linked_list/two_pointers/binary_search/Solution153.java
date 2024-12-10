package array_linked_list.two_pointers.binary_search;

// 153. Find Minimum in Rotated Sorted Array
public class Solution153 {
    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int n = nums.length;
        if(nums[0] < nums[n-1]){
            return nums[0];
        }

        int left = 0, right = n-1;
        int res = Integer.MAX_VALUE;
        while(left <= right){
            int middle = left + (right - left) / 2;
            int value = nums[middle];
            res = Math.min(res, value);
            if(value > nums[0]){
                left = middle + 1;
            } else if (value < nums[0]){
                right = middle - 1;
            } else if (value == nums[0]){
                left = middle + 1;
            }
        }

        return res;
    }
}
