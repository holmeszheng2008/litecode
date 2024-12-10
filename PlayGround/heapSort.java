package leetcode;

import java.util.Arrays;

public class PlayGround {

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 5, 2, 8, 10, 1, 3, 2, 7, 5 };
        heapSort(nums);

        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void swap_nodes(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void makeHeap(int[] nums, int topIndex, int endIndex) {
        int leftIndex = 2 * topIndex + 1;
        int rightIndex = 2 * topIndex + 2;
        if (leftIndex >= endIndex) {
            return;
        } else if (rightIndex >= endIndex) {
            int left = nums[leftIndex];
            if (left > nums[topIndex]) {
                swap_nodes(nums, leftIndex, topIndex);
            }
        } else {
            int left = nums[leftIndex];
            int right = nums[rightIndex];
            
            if (left >= right) {
                if (left > nums[topIndex]) {
                    swap_nodes(nums, leftIndex, topIndex);
                    makeHeap(nums, leftIndex, endIndex);
                }
            } else {
                if (right > nums[topIndex]) {
                    swap_nodes(nums, rightIndex, topIndex);
                    makeHeap(nums, rightIndex, endIndex);
                }
            }
        }
    }

    public static void heapSort(int[] nums) {
        int lastBranchIndex = (nums.length - 1) / 2;
        for (int i = lastBranchIndex; i >= 0; i--) {
            makeHeap(nums, i, nums.length);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            swap_nodes(nums, 0, nums.length - 1 - i);
            makeHeap(nums, 0, nums.length - 1 - i);
        }
    }
}
