package leetcode;

import java.util.Arrays;

public class PlayGround {

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 5, 2, 8, 10, 1, 3, 2, 7, 5 };
        quickSort(nums, 0, nums.length);

        Arrays.stream(nums).forEach(System.out::println);
    }

    public static int partition(int nums[], int low, int high) {
        int pivot = nums[high - 1];
        int i = low;
        int j = high - 2;
        while (i <= j) {
            if (nums[i] <= pivot) {
                i++;
            } else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
            }
        }

        int temp = nums[i];
        nums[i] = nums[high - 1];
        nums[high - 1] = temp;

        return i;
    }

    public static void quickSort(int[] nums, int low, int high) {
        if (low + 1 >= high) {
            return;
        }
        int pivotIndex = partition(nums, low, high);
        quickSort(nums, low, pivotIndex);
        quickSort(nums, pivotIndex + 1, high);
    }
}
