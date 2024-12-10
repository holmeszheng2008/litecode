package dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 139. Word Break
public class Solution139 {
    private Boolean[] memo;
    private String s;
    private List<String> wordDict;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.memo = new Boolean[s.length()];
        this.s = s;
        this.wordDict = wordDict;

        return dp(0);
    }

    private boolean dp( int startIndex){
        if(startIndex == s.length()){
            return true;
        }

        if(memo[startIndex] != null){
            return memo[startIndex];
        }

        boolean res = false;
        for(String word : wordDict){
            int startPoint = s.indexOf(word, startIndex);
            if(startPoint == startIndex){
                res = dp(startPoint + word.length());
            }

            if(res){
                break;
            }
        }

        memo[startIndex] = res;
        return res;
    }
}


class Solution139_dp_bu {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];

        dp[0] = true;
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                if(!dp[j]) {
                    continue;
                }
                if(wordDictSet.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}