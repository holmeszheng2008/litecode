package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 472. Concatenated Words
public class Solution472 {
    private Set<String> wordDict;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        this.wordDict = new HashSet<>();
        for(String word : words){
            wordDict.add(word);
        }

        for(String word : words){
            wordDict.remove(word);

            if(canBreak(word)){
                res.add(word);
            }
            wordDict.add(word);
        }

        return res;
    }

    private boolean canBreak(String word) {
        if(wordDict.size() == 0){
            return false;
        }
        int n = word.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j <= i-1; j++){
                if(!dp[j]) {
                    continue;
                }
                if(wordDict.contains(word.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
