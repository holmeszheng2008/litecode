package misc.math;

// 172. Factorial Trailing Zeroes
public class Solution172 {
    public int trailingZeroes(int n) {
        int divider = 5;
        int res = 0;
        while(divider <= n){
            res += n / divider;

            divider *= 5;
        }

        return res;
    }
}
