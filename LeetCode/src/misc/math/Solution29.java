package misc.math;

// 29. Divide Two Integers
public class Solution29 {
    public int divide(int dividend, int divisor) {
        int res = 0;
        // same sign
        if ((dividend ^ divisor) >= 0) {
            if (dividend == Integer.MIN_VALUE && divisor == -1){
                return Integer.MAX_VALUE;
            }
            res = doDivide(dividend, divisor);
        } else {
            // opposite sign
            if(dividend == Integer.MIN_VALUE && divisor == 1){
                return Integer.MIN_VALUE;
            }
            divisor = -divisor;
            res = doDivide(dividend, divisor);
            res = -res;
        }

        return res;
    }

    public int doDivide(long dividend, long divisor){
        int res = 1;
        if (divisor > 0){
            long sum = divisor;
            while(sum <= dividend){
                res++;
                sum = sum + divisor;
            }
        } else {
            long sum = divisor;
            while(sum >= dividend){
                res++;
                sum = sum + divisor;
            }
        }


        return res-1;
    }
}