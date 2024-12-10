package dp;

// 292. Nim Game
public class Solution292 {
    public boolean canWinNim(int n) {
        // 0 -> me 1 -> friend
        boolean[][] dp = new boolean[2][n+1];
        for(int i = 1; i <= Math.min(3, n); i++){
            dp[0][i] = true;
            dp[1][i] = false;
        }

        for(int j = 4; j < n+1; j++){
            dp[0][j] = dp[1][j-1] || dp[1][j-2] || dp[1][j-3];
            dp[1][j] = dp[0][j-1] && dp[0][j-2] && dp[0][j-3];
        }

        return dp[0][n];
    }
}

class Solution202_math {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
