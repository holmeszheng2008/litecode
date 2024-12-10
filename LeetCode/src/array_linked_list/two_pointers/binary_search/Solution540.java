package array_linked_list.two_pointers.binary_search;

// 540. Single Element in a Sorted Array
public class Solution540 {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;

        while(low <= high){
            int middle = low + (high - low) / 2;
            if(middle % 2 == 1){
                middle -= 1;
            }
            if(middle + 1 == nums.length || nums[middle] != nums[middle + 1]){
                high = middle - 1;
            } else {
                low = middle + 2;
            }
        }

        return nums[low];
    }
}