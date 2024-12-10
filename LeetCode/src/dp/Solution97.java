package dp;

// 97. Interleaving String
public class Solution97 {
    private Boolean[][][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if(m + n != s3.length()){
            return false;
        }
        memo = new Boolean[2][m+1][n+1];

        return dp(0, s1, 0, s2, 0, s3) || dp(1, s1, 0, s2, 0, s3);
    }

    // 0 -> s1 first, s2 second
    // 1 -> s1 second, s2 first
    private boolean dp(int order, String s1, int i, String s2, int j, String s3){
        if(i == s1.length() && j == s2.length()){
            return true;
        }
        if(order == 0 && i >= s1.length()){
            return false;
        }
        if(order == 1 && j >= s2.length()){
            return false;
        }

        if(memo[order][i][j] != null) {
            return memo[order][i][j];
        }

        boolean res = false;
        if(order == 0) {
            if(s3.charAt(i + j) == s1.charAt(i)) {
                res = dp(0, s1, i+1, s2, j, s3) || dp(1, s1, i+1, s2, j, s3);
            } else {
                res = false;
            }
        } else {
            if(s3.charAt(i + j) == s2.charAt(j)) {
                res = dp(0, s1, i, s2, j + 1, s3) || dp(1, s1, i, s2, j + 1, s3);
            } else {
                res = false;
            }
        }

        memo[order][i][j] = res;
        return res;
    }
}


class Solution_attempt1 {
    private Boolean[][][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if(m + n != s3.length()){
            return false;
        }
        this.memo = new Boolean[2][m+1][n+1];

        return dp(0, s1, 0, s2, 0, s3) || dp(1, s1, 0, s2, 0, s3);
    }

    // 0 -> s1 first
    // 1 -> s2 first
    private boolean dp(int order, String s1, int i, String s2, int j, String s3){
        if(i == s1.length() && j == s2.length()){
            return true;
        }

        if(order == 0 && i == s1.length()){
            return false;
        }

        if(order == 1 && j == s2.length()){
            return false;
        }

        if(memo[order][i][j] != null){
            return memo[order][i][j];
        }

        boolean res = false;

        if(order == 0){
            if(s1.charAt(i) != s3.charAt(i + j)){
                res = false;
            } else {
                res = dp(0, s1, i + 1, s2, j, s3) || dp(1, s1, i+1, s2, j, s3);
            }
        }

        if(order == 1){
            if(s2.charAt(j) != s3.charAt(i + j)){
                res = false;
            } else {
                res = dp(1, s1, i, s2, j+1, s3) || dp(0, s1, i, s2, j+1, s3);
            }
        }

        memo[order][i][j] = res;

        return res;
    }
}