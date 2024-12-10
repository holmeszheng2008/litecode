package dp;

// 1143. Longest Common Subsequence
// Bottom Up
public class Soution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    int res = Integer.MIN_VALUE;
                    res = Math.max(res, dp[i - 1][j]);
                    res = Math.max(res, dp[i][j - 1]);
                    res = Math.max(res, dp[i - 1][j - 1]);
                    dp[i][j] = res;
                }
            }
        }

        return dp[m][n];
    }
}


// Top down
class Soution1143_Td {
    private String text1;
    private String text2;
    private int m;
    private int n;
    private int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        this.m = text1.length();
        this.n = text2.length();
        this.memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }

        return dp(m - 1, n - 1);
    }

    private int dp(int i, int j) {
        if (i == -1) {
            return 0;
        }
        if (j == -1) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + dp(i - 1, j - 1);
            return memo[i][j];
        } else {
            int res = Integer.MIN_VALUE;
            res = Math.max(res, dp(i - 1, j));
            res = Math.max(res, dp(i, j - 1));
            res = Math.max(res, dp(i - 1, j - 1));

            memo[i][j] = res;
            return res;
        }
    }
}

class Soution1143_attempt1 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                char char1 = text1.charAt(i-1);
                char char2 = text2.charAt(j-1);
                if(char1 == char2) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }
}

class Soution1143_attempt2 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m  = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i < m+1; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j < n+1; j++){
            dp[0][j] = 0;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }
}

class Soution1143_attempt3 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]), dp[i][j - 1]);
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }
}