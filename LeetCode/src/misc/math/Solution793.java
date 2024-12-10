package misc.math;

// 793. Preimage Size of Factorial Zeroes Function
public class Solution793 {
    public int preimageSizeFZF(int k) {
        return hasN(k)? 5 : 0;
    }

    private boolean hasN(int k){
        long low = 0, high = Long.MAX_VALUE;
        while(low <= high){
            long n = low + (high - low) / 2;
            if (trailingZeroNum(n) < k){
                low = n+1;
            } else if (trailingZeroNum(n) == k){
                return true;
            } else if (trailingZeroNum(n) > k){
                high = n - 1;
            }
        }

        return false;
    }

    private long trailingZeroNum(long n){
        long dividor = 5;
        long res = 0;
        while(dividor <= n){
            res += n / dividor;
            dividor *= 5;

        }
        return res;
    }

}

class Solution793_2 {
    public int preimageSizeFZF(int k) {
        long leftBound = getLeftBound(k);
        long rightBound = getRightBound(k);
        if (leftBound == -1 || rightBound == -1){
            return 0;
        }

        return (int)(rightBound - leftBound) + 1;
    }

    private long getLeftBound(int k){
        long low = 0, high = Long.MAX_VALUE;
        while(low <= high){
            long n = low + (high - low) / 2;
            if (trailingZeroNum(n) < k){
                low = n+1;
            } else if (trailingZeroNum(n) == k){
                high = n - 1;
            } else if (trailingZeroNum(n) > k){
                high = n - 1;
            }
        }

        if (low == Long.MAX_VALUE || trailingZeroNum(low) != k){
            return -1;
        }

        return low;
    }

    private long getRightBound(int k){
        long low = 0, high = Long.MAX_VALUE;
        while(low <= high){
            long n = low + (high - low) / 2;
            if (trailingZeroNum(n) < k){
                low = n+1;
            } else if (trailingZeroNum(n) == k){
                low = n+1;
            } else if (trailingZeroNum(n) > k){
                high = n - 1;
            }
        }

        if (high < 0 || trailingZeroNum(high) != k){
            return -1;
        }

        return high;
    }

    private long trailingZeroNum(long n){
        long dividor = 5;
        long res = 0;
        while(dividor <= n){
            res += n / dividor;
            dividor *= 5;
        }

        return res;
    }

}
