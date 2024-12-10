package array_linked_list.two_pointers.fast_slow_pointers;

// 80. Remove Duplicates from Sorted Array II
public class Solution80 {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        int start = fast;
        while(fast <= nums.length){
            if(nums[fast] != nums[start] || fast == nums.length) {
                int size = fast - start;
                for (int i = 0; i < Math.min(2, size); i++) {
                    nums[slow] = nums[start];
                    slow++;
                }
                start = fast;
                fast++;
            } else {
                fast++;
            }
        }

        return slow;
    }
}


class Solution {
    public int removeDuplicates(int[] nums) {
        int pre = Integer.MAX_VALUE;
        int occur = 0;
        int slow = 0, fast = 0;
        while(fast < nums.length){
            if(nums[fast] != pre){
                nums[slow] = nums[fast];
                occur = 1;
                pre = nums[fast];
                fast++;
                slow++;
            } else {
                if(occur == 2){
                    fast++;
                } else {
                    occur++;
                    nums[slow] = nums[fast];
                    slow++;
                    fast++;
                }
            }
        }

        return slow;
    }
}