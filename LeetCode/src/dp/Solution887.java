package dp;

// 887. Super Egg Drop
// DP with Linear search
public class Solution887 {
    private Integer[][] memo;

    public int superEggDrop(int k, int n) {
        this.memo = new Integer[k + 1][n + 1];

        return dp(k, n);
    }

    private int dp(int k, int n) {
        if (k == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }

        if (memo[k][n] != null) {
            return memo[k][n];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, Math.max(dp(k - 1, i - 1), dp(k, n - i)) + 1);
        }

        memo[k][n] = res;
        return res;
    }
}


class Solution887_bs {
    private Integer[][] memo;

    public int superEggDrop(int k, int n) {
        this.memo = new Integer[k + 1][n + 1];

        return dp(k, n);
    }

    private int dp(int k, int n) {
        if (k == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }
        
        if (memo[k][n] != null) {
            return memo[k][n];
        }
        
        int low = 1, high = n;
        int res = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = low + (high-low)/2;
            // make choice at level mid
            int broken = dp(k - 1, mid - 1);
            int notBroken = dp(k, n - mid);

            if (broken > notBroken) {
                high = mid - 1;
                res = Math.min(res, broken + 1);
            } else {
                low = mid + 1;
                res = Math.min(res, notBroken + 1);
            }
        }

        memo[k][n] = res;
        return res;
    }
}
