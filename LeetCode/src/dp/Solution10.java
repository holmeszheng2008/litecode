package dp;

import java.util.HashMap;
import java.util.Map;

// 10. Regular Expression Matching
public class Solution10 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        if (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) {
            dp[1][1] = true;
        }

        for (int j = 2; j < n + 1; j++) {
            if (j % 2 == 0 && p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 2; j < n + 1; j++) {
                if (p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        dp[i][j] = dp[i - 1][j - 2] || dp[i - 1][j] || dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                } else if (p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if (p.charAt(j - 1) == s.charAt(i - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }

        return dp[m][n];
    }
}

class Solution10_td {
    private Boolean[][] memo;
    private Map<Integer, Boolean> memoFirst = new HashMap<>();
    private String s;
    private String p;
    public boolean isMatch(String s, String p) {
        this.memo = new Boolean[s.length()][p.length()];
        this.s = s;
        this.p = p;

        return dp(s.length() - 1, p.length() - 1);
    }

    private boolean dp(int i, int j) {
        if(i < 0 && j < 0) {
            return true;
        }
        if(i < 0){
            if(p.charAt(j) == '*'){
                if(memoFirst.get(j) != null){
                    return memoFirst.get(j);
                } else {
                    boolean res = dp(i, j -2);
                    memoFirst.put(j, res);
                    return res;
                }
            }
            return false;
        }
        if(j < 0){
            return false;
        }

        if(memo[i][j] != null){
            return memo[i][j];
        }

        boolean res = false;
        char pc = p.charAt(j);
        char sc = s.charAt(i);
        if(pc == '*'){
            char ppc = p.charAt(j-1);
            if(ppc == '.' || ppc == sc){
                res = dp(i, j-2) || dp(i-1, j) || dp(i-1, j-2);
            } else {
                res = dp(i, j-2);
            }
        } else if (pc == '.'){
            res = dp(i-1, j-1);
        } else {
            if(pc == sc) {
                res = dp(i - 1, j - 1);
            } else {
                res = false;
            }
        }

        memo[i][j] = res;
        return res;
    }
}

class Solution10_attempt1 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+2];
        dp[0][0] = true;
        dp[0][1] = true;
        for(int j = 2; j <dp[0].length; j++){
            if(p.charAt(j-2) == '*'){
                dp[0][j] = dp[0][j-2];
            } else {
                dp[0][j] = false;
            }
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 2; j < dp[0].length; j++){
                char pc = p.charAt(j-2);
                char sc = s.charAt(i-1);
                if(pc == '*'){
                    char ppc = p.charAt(j-3);
                    if(ppc == '.' || ppc == sc) {
                        dp[i][j] = dp[i][j-2] || dp[i-1][j] || dp[i-1][j-2];
                    } else {
                        dp[i][j] = dp[i][j-2];
                    }
                } else if (pc == '.'){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    if(pc == sc){
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }


        return dp[s.length()][p.length()+1];
    }
}