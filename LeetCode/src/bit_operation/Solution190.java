package bit_operation;

// 190. Reverse Bits
public class Solution190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            res |= ((1 << i) & n) >>> i << (31 - i);
        }

        return res;
    }
}
