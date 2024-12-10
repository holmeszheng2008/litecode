package dp;

// 70. Climbing Stairs
public class Solution70 {
    private Integer[] memo;

    public int climbStairs(int n) {
        memo = new Integer[n + 1];

        return dp(n);
    }

    private int dp(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        if (memo[n] != null) {
            return memo[n];
        }

        int num = dp(n - 1) + dp(n - 2);
        memo[n] = num;

        return num;
    }
}
