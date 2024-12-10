package dp;

// 712. Minimum ASCII Delete Sum for Two Strings
// Bottom Up
public class Solution712 {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i < m + 1; i++) {
            dp[i][0] = s1.charAt(i - 1) + dp[i - 1][0];
        }
        for (int j = 1; j < n + 1; j++) {
            dp[0][j] = s2.charAt(j - 1) + dp[0][j - 1];
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int res = Integer.MAX_VALUE;
                    res = Math.min(res, dp[i - 1][j] + s1.charAt(i - 1));
                    res = Math.min(res, dp[i][j - 1] + s2.charAt(j - 1));

                    dp[i][j] = res;
                }
            }
        }

        return dp[m][n];
    }
}


class Solution712_attempt1 {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i < m+1; i++){
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
        }

        for(int j = 1; j < n+1; j++){
            dp[0][j] = dp[0][j-1] + s2.charAt(j-1);
        }

        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                char a = s1.charAt(i-1);
                char b = s2.charAt(j-1);
                if(a == b){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j] + s1.charAt(i-1), dp[i][j-1] + s2.charAt(j-1));
                }
            }
        }

        return dp[m][n];
    }
}