package array_linked_list.two_pointers.binary_search;

public class Solution34 {
    // recursion version
    public int[] searchRange(int[] nums, int target) {
        return new int[] {findLeftRange(nums, target, 0, nums.length), findRightRange(nums, target, 0, nums.length)};
    }

    private int findLeftRange(int[] nums, int target, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
            return findLeftRange(nums, target, left, right);
        }

        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    private int findRightRange(int[] nums, int target, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
            return findRightRange(nums, target, left, right);
        }

        left = left - 1;
        if (left < 0 || nums[left] != target) {
            return -1;
        }
        return left;
    }
}


class Solution34_attempt1 {
    public int[] searchRange(int[] nums, int target) {
        int left = findLeft(nums, target);
        int right = findRight(nums, target);

        return new int[]{left, right};
    }

    private int findLeft(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int middle = left + (right - left) / 2;
            int value = nums[middle];
            if(value == target){
                right = middle - 1;
            } else if (value > target){
                right = middle - 1;
            } else if (value < target){
                left = middle + 1;
            }
        }

        if(left == nums.length || nums[left] != target){
            return -1;
        }

        return left;
    }

    private int findRight(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int middle = left + (right - left) / 2;
            int value = nums[middle];
            if(value == target){
                left = middle + 1;
            } else if (value < target){
                left = middle + 1;
            } else if (value > target){
                right = middle - 1;
            }
        }

        if(right == -1 || nums[right] != target){
            return -1;
        }

        return right;
    }
}