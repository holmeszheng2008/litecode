package bit_operation;

// 338. Counting Bits
public class Solution338 {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i = 0; i <= n; i++){
            res[i] = res[i >> 1] + (1 & i);
        }

        return res;
    }
}
