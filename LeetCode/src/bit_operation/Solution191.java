package bit_operation;

// 191. Number of 1 Bits
public class Solution191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0){
            n = n & (n-1);
            res++;
        }
        return res;
    }
}
