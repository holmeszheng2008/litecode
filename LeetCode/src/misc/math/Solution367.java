package misc.math;

// 367. Valid Perfect Square
public class Solution367 {
    public boolean isPerfectSquare(int num) {
        long left = 1, right = Integer.MAX_VALUE;
        while(left <= right){
            long middle = left + (right - left) / 2;
            long value = middle * middle;
            if(value < num){
                left = middle + 1;
            } else if(value > num) {
                right = middle - 1;
            } else if (value == num){
                return true;
            }
        }

        return false;
    }
}
