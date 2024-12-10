package dp;

// 174. Dungeon Game
public class Solution174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        int value = 1-dungeon[m-1][n-1];
        if (value > 0) {
            value = 1;
        }
        dp[m - 1][n - 1] = value;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    continue;
                }
                if (i+1 < m && j+1 < n) {
                    int minHealth = Math.min(dp[i][j + 1], dp[i + 1][j]) - dungeon[i][j];
                    if (minHealth <= 0) {
                        minHealth = 1;
                    }
                    dp[i][j] = minHealth;
                } else if (i+1 < m) {
                    int minHealth = dp[i+1][j] - dungeon[i][j];
                    if (minHealth <= 0) {
                        minHealth = 1;
                    }
                    dp[i][j] = minHealth;
                } else if (j + 1 < n){
                    int minHealth = dp[i][j + 1] - dungeon[i][j];
                    if (minHealth <= 0) {
                        minHealth = 1;
                    }
                    dp[i][j] = minHealth;
                }
            }
        }
        

        return dp[0][0];
    }
}

class Solution174_attempt1 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];
        dp[m-1][n-1] = (1 - dungeon[m-1][n-1] <= 0) ? 1 : 1 - dungeon[m-1][n-1];

        for(int j = n-2; j >= 0; j--){
            int res = dp[m-1][j+1] - dungeon[m-1][j];
            dp[m-1][j] = (res <= 0) ? 1 : res;
        }
        for(int i = m-2; i >=0; i--){
            int res = dp[i+1][n-1] - dungeon[i][n-1];
            dp[i][n-1] = (res <= 0) ? 1 : res;
        }

        for(int i = m-2; i >= 0; i--){
            for(int j = n-2; j >= 0; j--){
                int res = Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j];
                dp[i][j] = (res <= 0) ? 1 : res;
            }
        }

        return dp[0][0];
    }
}