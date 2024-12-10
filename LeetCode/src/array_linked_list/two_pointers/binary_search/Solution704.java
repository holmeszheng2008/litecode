package array_linked_list.two_pointers.binary_search;

// 704. Binary Search
public class Solution704 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        return biSearch(nums, left, right, target);
    }

    public int biSearch(int[] nums, int left, int right, int target) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
                return biSearch(nums, left, right, target);
            } else if (nums[mid] > target) {
                right = mid;
                return biSearch(nums, left, right, target);
            }
        }

        return -1;
    }
}
