package dp;

// 920. Number of Music Playlists
public class Solution920 {
    public int numMusicPlaylists(int n, int goal, int k) {
        int modulo = 1_000_000_000 + 7;
        int[][] dp = new int[goal + 1][n+1];
        dp[0][0] = 1;
        for(int i = 1; i <= goal; i++){
            for(int j = 1; j <= Math.min(i, n); j++){
                dp[i][j] = (int)((long)dp[i-1][j-1] * (n - j  +1) % modulo);
                if(j > k){
                    dp[i][j] = (int)(((long)dp[i-1][j] * (j-k) + dp[i][j]) % modulo);
                }
            }
        }

        return dp[goal][n];
    }
}
