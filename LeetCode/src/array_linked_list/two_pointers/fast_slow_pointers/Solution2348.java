package array_linked_list.two_pointers.fast_slow_pointers;

// 2348. Number of Zero-Filled Subarrays
public class Solution2348 {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        int left = -1, right = -1;
        for(int i = 0; i <= nums.length; i++){
            if(i == nums.length || nums[i] != 0){
                if(right != -1){
                    int length = right + 1 - left;
                    res += calc(length);

                    left = -1;
                    right = -1;
                }
            } else {
                if(left == -1){
                    left = i;
                }
                right = i;
            }
        }

        return res;
    }

    private long calc(long length){
        if(length == 1){
            return 1;
        }

        return (1 + length) * length / 2;
    }
}
