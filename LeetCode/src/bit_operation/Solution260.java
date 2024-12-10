package bit_operation;

// 260. Single Number III
public class Solution260 {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num : nums){
            xor ^= num;
        }

        int diffBit = xor & ~(xor-1);
        int[] res = new int[2];
        for(int num : nums){
            if((num & diffBit) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }

        return res;
    }
}
