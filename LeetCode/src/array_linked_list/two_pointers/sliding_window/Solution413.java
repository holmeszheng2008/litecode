package array_linked_list.two_pointers.sliding_window;

// 413. Arithmetic Slices
public class Solution413 {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3){
            return 0;
        }

        int res = 0;
        int diff = nums[1] - nums[0];
        int left = 0, right = 2;
        while(right < nums.length){
            int in = nums[right++];
            if(in - nums[right- 2] != diff){
                int length = right-1 - left;
                res += gatherNum(length);

                diff = in - nums[right - 2];
                left = right - 2;
            }
        }

        int length = right - left;
        res += gatherNum(length);

        return res;
    }

    private int gatherNum(int length){
        if(length < 3){
            return 0;
        }

        return (1 + (length - 2)) * (length - 2) / 2;
    }
}
