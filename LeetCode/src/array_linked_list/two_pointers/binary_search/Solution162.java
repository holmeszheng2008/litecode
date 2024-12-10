package array_linked_list.two_pointers.binary_search;

// 162. Find Peak Element
public class Solution162 {
    private Integer res;
    private int[] nums;
    public int findPeakElement(int[] nums) {
        this.nums = nums;

        dfs(0, nums.length - 1);
        return res;
    }

    private void dfs(int low, int high){
        if(low > high){
            return;
        }
        if(res != null){
            return;
        }
        int middle = low + (high - low) / 2;
        if(middle == 0 && middle == nums.length - 1){
            res = middle;
            return;
        } else if(middle == 0 && nums[middle] > nums[middle+1]){
            res = middle;
            return;
        } else if(middle == nums.length - 1 && nums[middle] > nums[middle - 1]){
            res = middle;
            return;
        } else if(nums[middle] > nums[middle + 1] && nums[middle] > nums[middle-1]) {
            res = middle;
            return;
        }

        dfs(low, middle - 1);
        dfs(middle + 1, high);
    }
}
