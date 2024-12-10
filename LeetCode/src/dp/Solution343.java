package dp;

// 343. Integer Break
public class Solution343 {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            if(i != n){
                dp[i] = i;
            }
           for(int j = 1; j < i; j++){
               dp[i] = Math.max(dp[i], dp[j] * (i-j));
           }
        }

        return dp[n];
    }
}
