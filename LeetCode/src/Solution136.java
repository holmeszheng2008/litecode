// 136. Single Number
public class Solution136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num : nums){
            res = res ^ num;
        }

        return res;
    }
}
