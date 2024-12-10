package leetcode;

import java.util.Arrays;

public class PlayGround {

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 5, 2, 8, 10, 1, 3, 2, 7, 5 };
        mergeSort(nums, 0, nums.length);

        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void merge(int[] nums, int low, int middle, int high) {
        int[] result = new int[high - low];
        int i = low, j = middle, k = 0;
        while (k < result.length) {
            if (i == middle) {
                result[k] = nums[j];
                j++;
            } else if (j == high) {
                result[k] = nums[i];
                i++;
            } else {
                if (nums[i] <= nums[j]) {
                    result[k] = nums[i];
                    i++;
                } else {
                    result[k] = nums[j];
                    j++;
                }
            }
            k++;
        }

        for (k = 0; k < result.length; k++) {
            nums[low + k] = result[k];
        }
    }

    public static void mergeSort(int[] nums, int low, int high) {
        if (low + 1 < high) {
            int middle = (low + high) / 2;
            mergeSort(nums, low, middle);
            mergeSort(nums, middle, high);
            merge(nums, low, middle, high);
        }
    }
}
