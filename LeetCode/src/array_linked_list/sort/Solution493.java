package array_linked_list.sort;

// 493. Reverse Pairs
public class Solution493 {
    private int[] temp;
    private int count;

    public int reversePairs(int[] nums) {
        temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);

        return count;
    }

    private void mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low)/2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);

        merge(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = nums[i];
        }
        int end = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (end <= high && nums[i] > 2l * nums[end]) {
                end++;
            }
            count += end - (mid + 1);
        }
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j++];
            } else if (j == high + 1) {
                nums[k] = temp[i++];
            } else if (temp[i] < temp[j]) {
                nums[k] = temp[i++];
            } else if (temp[i] >= temp[j]) {
                nums[k] = temp[j++];
            }
        }
    }
}

class Solution493_attempt1 {
    private int[] temp;
    private int[] nums;
    private int count;

    public int reversePairs(int[] nums) {
        temp = new int[nums.length];
        this.nums = nums;

        mergeSort(0, nums.length - 1);
        return count;
    }

    private void mergeSort(int low, int high){
        if (low == high){
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(low, mid);
        mergeSort(mid+1, high);

        merge(low, mid, high);
    }

    private void merge(int low, int mid, int high){
        int checkP = mid+1;
        for(int i = low; i <= mid; i++) {
            for(; checkP <= high; checkP++){
                if (nums[i] <= 2l * nums[checkP]){
                    break;
                }
            }
            count += checkP - mid - 1;
        }
        for(int i = low; i <= high; i++){
            temp[i] = nums[i];
        }

        for(int i = low, j = low, k = mid+1; i <= high; i++){
            if (j == mid+1){
                nums[i] = temp[k++];
            } else if (k == high + 1){
                nums[i] = temp[j++];
            } else {
                if (temp[j] <= temp[k]){
                    nums[i] = temp[j++];
                } else {
                    nums[i] = temp[k++];
                }
            }
        }
    }
}
