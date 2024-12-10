package array_linked_list.sort;

public class Solution327 {

    private int lower, upper;

    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = nums[i] + preSum[i];
        }
        sort(preSum);
        return count;
    }

    private long[] temp;

    public void sort(long[] nums) {
        temp = new long[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    private void sort(long[] nums, int lo, int hi) {
        if (lo == hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(nums, lo, mid);
        sort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private int count = 0;

    private void merge(long[] nums, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = nums[i];
        }
        int start = mid + 1, end = mid + 1;
        for (int i = lo; i <= mid; i++) {
            while (start <= hi && nums[start] - nums[i] < lower) {
                start++;
            }
            while (end <= hi && nums[end] - nums[i] <= upper) {
                end++;
            }
            count += end - start;
        }
        int i = lo, j = mid + 1;
        for (int p = lo; p <= hi; p++) {
            if (i == mid + 1) {
                nums[p] = temp[j++];
            } else if (j == hi + 1) {
                nums[p] = temp[i++];
            } else if (temp[i] > temp[j]) {
                nums[p] = temp[j++];
            } else {
                nums[p] = temp[i++];
            }
        }
    }
}


class Solution327_attempt1 {
    private int lower;
    private int upper;
    private int count;
    public int countRangeSum(int[] nums, int lower, int upper) {
        this.upper = upper;
        this.lower = lower;
        int n = nums.length;
        long[] preSums = new long[n+1];
        for(int i = 0; i < n; i++){
            preSums[i+1] = preSums[i] + nums[i];
        }

        mergeSort(preSums, 0, n);
        return count;
    }

    private void mergeSort(long[] preSums, int left, int right){
        if(left == right){
            return;
        }
        int middle = left + (right - left) / 2;
        mergeSort(preSums, left, middle);
        mergeSort(preSums, middle + 1, right);


        merge(preSums, left, middle, right);
    }

    private void merge(long[] preSums, int left, int middle, int right){
        countRanges(preSums, left, middle, right);

        long[] temp = new long[right + 1 - left];
        int i = left, j = middle + 1, k = 0;
        while(i <= middle || j <= right){
            if(i <= middle && j <= right) {
                if (preSums[i] <= preSums[j]) {
                    temp[k++] = preSums[i++];
                } else {
                    temp[k++] = preSums[j++];
                }
            } else if(i <= middle) {
                temp[k++] = preSums[i++];
            } else {
                temp[k++] = preSums[j++];
            }
        }

        for(i = left; i <= right; i++){
            preSums[i] = temp[i-left];
        }
    }

    private void countRanges(long[] preSums, int left, int middle, int right){
        int i = middle + 1, j = middle + 1;
        for(int k = left; k <= middle; k++){
            while(i <= right){
                if(preSums[i] - preSums[k] >= lower){
                    break;
                }
                i++;
            }
            while(j <= right){
                if(preSums[j] - preSums[k] > upper){
                    break;
                }
                j++;
            }
            if(i <= j){
                count += j - i;
            }
        }
    }
}