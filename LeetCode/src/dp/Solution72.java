package dp;

// 72. Edit Distance
// Top Down
public class Solution72 {
    private Integer[][] memo;
    public int minDistance(String word1, String word2) {
        char[] array1 = word1.toCharArray();
        char[] array2 = word2.toCharArray();
        this.memo = new Integer[array1.length][array2.length];

        return dp(array1, array1.length - 1, array2, array2.length - 1);
    }

    private int dp(char[] array1, int i, char[] array2, int j) {
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (array1[i] == array2[j]) {
            int res = dp(array1, i - 1, array2, j - 1);
            memo[i][j] = res;

            return memo[i][j];
        }

        int res = Integer.MAX_VALUE;
        // delete operation
        res = Math.min(res, dp(array1, i - 1, array2, j));
        // insert operation
        res = Math.min(res, dp(array1, i, array2, j - 1));
        // replace operation
        res = Math.min(res, dp(array1, i - 1, array2, j - 1));

        memo[i][j] = 1 + res;
        return memo[i][j];
    }
}


// Bottom Up
class Solution72_bu {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0, j = 0; j < n + 1; j++) {
            dp[i][j] = j;
        }
        for (int i = 0, j = 0; i < m + 1; i++) {
            dp[i][j] = i;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int res = Integer.MAX_VALUE;
                    // replace
                    res = Math.min(res, dp[i - 1][j - 1] + 1);
                    // add
                    res = Math.min(res, dp[i][j - 1] + 1);
                    // delete
                    res = Math.min(res, dp[i - 1][j] + 1);

                    dp[i][j] = res;
                }
            }
        }

        return dp[m][n];
    }
}

class Solution72_attempt1 {
    private String word1;
    private String word2;
    Integer[][] memo;
    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        this.memo = new Integer[word1.length()][word2.length()];

        return dp(word1.length() - 1, word2.length() - 1);
    }

    private int dp(int i, int j){
        if(i == -1){
            return j+1;
        }
        if(j == -1){
            return i + 1;
        }

        if(memo[i][j] != null){
            return memo[i][j];
        }

        int charI = word1.charAt(i);
        int charJ = word2.charAt(j);
        int res = 0;
        if (charI == charJ) {
            res = dp(i - 1, j - 1);
        } else {
            int tempRes = Math.min(dp(i-1, j-1), Math.min(dp(i, j-1), dp(i-1, j)));
            res = tempRes + 1;
        }

        memo[i][j] = res;
        return res;
    }
}

class Solution72_attempt1_bu {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = i;
        }
        for(int j = 0; j < dp[0].length; j++){
            dp[0][j] = j;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                int charI = word1.charAt(i-1);
                int charJ = word2.charAt(j-1);
                if(charI == charJ){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j]);
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}

class Solution72_attempt2_bu {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i < m+1; i++){
            dp[i][0] = i;
        }
        for(int j = 0; j < n+1; j++){
            dp[0][j] = j;
        }

        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                char char1 = word1.charAt(i-1);
                char char2 = word2.charAt(j-1);
                if(char1 == char2){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                }
            }
        }

        return dp[m][n];
    }
}