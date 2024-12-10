package misc.math;

// 400. Nth Digit
public class Solution400 {
    public int findNthDigit(int n) {
        // 1 * 9, 2 * 90, 3 * 900 ...
        long digit = 1, base = 1;

        while(n > digit * base * 9){
            n -= digit * base * 9;
            digit++;
            base *= 10;
        }

        if(n == 0){
            return 9;
        }

        long start = base;

        int whole = (int)(n / digit);
        int extra = (int)(n % digit);

        if(extra == 0){
            whole--;
            extra = (int)digit;
        }

        start += whole;
        String str = String.valueOf(start);

        return str.charAt(extra - 1) - '0';
    }
}
