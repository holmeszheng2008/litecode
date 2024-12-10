package misc.math;

// 69. Sqrt(x)
public class Solution69 {
    public int mySqrt(int x) {
        int low = 0, high = 46340;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int temp = mid * mid;
            if(temp == x){
                return mid;
            } else if (temp < x){
                low = mid + 1;
            } else if (temp > x){
                high = mid - 1;
            }
        }

        return low - 1;
    }
}
