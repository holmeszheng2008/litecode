package dp;

// 583. Delete Operation for Two Strings
// Bottom Up
public class Solution583 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int res = Integer.MAX_VALUE;
                    res = Math.min(res, dp[i - 1][j]);
                    res = Math.min(res, dp[i][j - 1]);

                    dp[i][j] = 1 + res;
                }
            }
        }

        return dp[m][n];
    }
}


// Top Down
class Solution583_td {
    private String word1;
    private String word2;
    private int m;
    private int n;
    private Integer[][] memo;
    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        this.m = word1.length();
        this.n = word2.length();
        this.memo = new Integer[m][n];

        return dp(m - 1, n - 1);
    }

    private int dp(int i, int j) {
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = dp(i - 1, j - 1);
            return memo[i][j];
        } else {
            int res = Integer.MAX_VALUE;
            res = Math.min(res, dp(i - 1, j));
            res = Math.min(res, dp(i, j - 1));

            memo[i][j] = 1 + res;
            return memo[i][j];
        }
    }
}
