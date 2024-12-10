package string.kmp;

// 214. Shortest Palindrome
public class Solution214 {
    public String shortestPalindrome(String s) {
        if(s.isEmpty()){
            return s;
        }
        String rev_s = new StringBuilder(s).reverse().toString();
        String sNew = s + "#" + rev_s;

        int n = sNew.length();
        int[][] dp = new int[n][256];
        int x = 0;
        dp[0][s.charAt(0)] = 1;
        for(int i = 1; i < n; i++){
            char validC = sNew.charAt(i);
            for(int c = 0; c < 256; c++){
                if(c == validC){
                    dp[i][c] = i+1;
                } else {
                    dp[i][c] = dp[x][c];
                }
            }
            x = dp[x][validC];
        }


        return new StringBuilder(s.substring(x)).reverse().toString() + s;
    }
}
