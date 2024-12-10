package array_linked_list.two_pointers.binary_search;

// 154. Find Minimum in Rotated Sorted Array II
public class Solution154 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int res = Integer.MAX_VALUE;
        while(left <= right){
            while(left <= right && nums[left] == nums[right]) {
                res = Math.min(res, nums[left]);
                left++;
                right--;
            }
            if(left > right){
                break;
            }

            int middle = left + (right - left) / 2;
            int value = nums[middle];
            res = Math.min(res, value);

            // 判断是否有pivot point
            if(nums[left] < nums[right]){
                return Math.min(res, nums[left]);
            }
            if(value > nums[left]){
                left = middle + 1;
            } else if (value < nums[left]){
                right = middle - 1;
            } else if (value == nums[left]) {
                left = middle + 1;
            }
        }

        return res;
    }
}


class Solution154_attempt1 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int res = Integer.MAX_VALUE;
        while(left <= right){
            int middle = left + (right - left) / 2;
            int value = nums[middle];
            res = Math.min(res, value);

            // 判断是否有pivot point
            if(nums[left] < nums[right]){
                return Math.min(res, nums[left]);
            }
            if(value > nums[left]){
                left = middle + 1;
            } else if (value < nums[left]){
                right = middle - 1;
            } else if (value == nums[left]) {
                if(nums[left] != nums[right]){
                    left = middle + 1;
                } else {
                    while(left <= right && nums[left] == nums[right] && nums[left] == value){
                        left++;
                        right--;
                    }
                }

            }
        }

        return res;
    }
}
