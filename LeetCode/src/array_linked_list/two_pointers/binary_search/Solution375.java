package array_linked_list.two_pointers.binary_search;

// 375. Guess Number Higher or Lower II
public class Solution375 {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+2][n+2];
        for(int i = n; i >= 1; i--){
            for(int j = i+1; j <= n; j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i; k <= j; k++){
                    dp[i][j] = Math.min(dp[i][j], k + Math.max(dp[i][k-1], dp[k+1][j]));
                }
            }
        }

        return dp[1][n];
    }
}
