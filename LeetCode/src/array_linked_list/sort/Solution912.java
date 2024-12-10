package array_linked_list.sort;

public class Solution912 {
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void heapSort(int[] nums) {
        int n = nums.length - 1;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            adjust(nums, i, n);
        }
        while (n > 0) {
            swap(nums, 0, n);
            n--;
            adjust(nums, 0, n);
        }
    }

    private void adjust(int[] nums, int i, int j) {
        int leftIndex = 2 * i + 1;
        int rightIndex = 2 * i + 2;

        int largestIndex = i;
        int largestValue = nums[i];
        if (leftIndex <= j && largestValue < nums[leftIndex]) {
            largestIndex = leftIndex;
            largestValue = nums[leftIndex];
        }
        if (rightIndex <= j && largestValue < nums[rightIndex]) {
            largestIndex = rightIndex;
            largestValue = nums[rightIndex];
        }

        if (largestIndex == i) {
            return;
        } else if (largestIndex == leftIndex) {
            swap(nums, i, largestIndex);
            adjust(nums, leftIndex, j);
        } else if (largestIndex == rightIndex) {
            swap(nums, i, largestIndex);
            adjust(nums, rightIndex, j);
        }
    }


}
