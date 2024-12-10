package misc.math;

// 7. Reverse Integer
public class Solution7 {
    public int reverse(int x) {
        int res = 0;
        while(x != 0){
            int modular = x % 10;
            if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && modular > 7)) {
                return 0;
            }
            if(res < Integer.MIN_VALUE/ 10 || (res == Integer.MIN_VALUE / 10 && modular < -8)){
                return 0;
            }

            res = res * 10 + modular;
            x /= 10;
        }

        return res;
    }
}
