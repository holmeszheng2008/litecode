package array_linked_list;

import java.util.Arrays;

// 324. Wiggle Sort II
public class Solution324 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] copy = Arrays.copyOf(nums, n);

        int i = n-1;
        for(int j = 1; j < n; j+=2){
            nums[j] = copy[i--];
        }
        for(int j = 0; j < n; j+=2){
            nums[j] = copy[i--];
        }
    }
}
