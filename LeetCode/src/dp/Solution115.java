package dp;

// 115. Distinct Subsequences
public class Solution115 {
    private Integer[][] memo;
    private int m;
    private int n;
    public int numDistinct(String s, String t) {
        this.m = s.length();
        this.n = t.length();
        this.memo = new Integer[m][n];

        return dp(s, t, 0, 0);
    }
    private int dp(String s, String t, int i, int j){
        if(j == n){
            return 1;
        }
        if(i == m){
            return 0;
        }
        if(memo[i][j] != null){
            return memo[i][j];
        }

        int res = 0;
        if(s.charAt(i) == t.charAt(j)){
            res += dp(s, t, i+1, j+1);
        }
        res += dp(s, t, i+1, j);

        memo[i][j] = res;
        return res;
    }
}
