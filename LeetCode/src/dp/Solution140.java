package dp;

import java.util.*;

// 140. Word Break II
// Base case 在-1
public class Solution140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        List<String>[] dp = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            // end at i-1
            List<String> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j != 0) {
                    if (dp[j].size() == 0) {
                        continue;
                    }
                }
                String subString = s.substring(j, i);
                if (set.contains(subString)) {
                    if (j == 0) {
                        list.add(subString);
                    } else {
                        for (String pre : dp[j]) {
                            String temp = pre + " " + subString;
                            list.add(temp);
                        }
                    }
                }
            }

            dp[i] = list;
        }

        return dp[n];
    }
}

// Base case 在n
class Solution140_attempt1 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        List<String>[] dp = new List[n];
        for(int i = n-1; i >= 0; i--){
            List<String> list = new ArrayList<>();
            for(int j = n-1; j >= i; j--){
                if(j + 1 != n){
                    if(dp[j+1].size() == 0){
                        continue;
                    }
                }
                String subString = s.substring(i, j+1);
                if (set.contains(subString)) {
                    if(j + 1 == n) {
                        list.add(subString);
                    } else {
                        for(String after : dp[j+1]){
                            String temp = subString + " " + after;
                            list.add(temp);
                        }
                    }
                }
            }

            dp[i] = list;
        }

        return dp[0];
    }
}

// Backtracking
class Solution140_backtracking_from0 {
    private String s;
    private Set<String> setDict;
    private List<String> res = new ArrayList<>();
    private List<String> path = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        setDict = new HashSet<>(wordDict);

        backtracking(0);
        return res;
    }

    private void backtracking(int start){
        for(int end = start; end < s.length(); end++){
            String subString = s.substring(start, end + 1);
            if(!setDict.contains(subString)){
                continue;
            }
            path.add(subString);
            if(end == s.length() - 1){
                addToRes();
            } else {
                backtracking(end + 1);
            }

            path.remove(path.size() - 1);
        }
    }

    private void addToRes(){
        StringBuilder sb = new StringBuilder();
        sb.append(path.get(0));
        for(int i = 1; i < path.size(); i++){
            sb.append(" ");
            sb.append(path.get(i));
        }

        res.add(sb.toString());
    }
}

// Backtracking
class Solution140_backtracking_fromNminus1 {
    private String s;
    private int n;
    private Set<String> setDict;
    private List<String> res = new ArrayList<>();
    private LinkedList<String> path = new LinkedList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.n = s.length();
        setDict = new HashSet<>(wordDict);

        backtracking(n-1);
        return res;
    }

    private void backtracking(int end){
        for(int start = end; start >= 0; start--){
            String subString = s.substring(start, end  + 1);
            if(!setDict.contains(subString)) {
                continue;
            }
            path.addFirst(subString);
            if(start == 0){
                addToRes();
            } else {
                backtracking(start - 1);
            }

            path.removeFirst();
        }
    }

    private void addToRes(){
        StringBuilder sb = new StringBuilder();
        Iterator<String> iterator = path.iterator();
        sb.append(iterator.next());
        while(iterator.hasNext()) {
            sb.append(" ");
            sb.append(iterator.next());
        }

        res.add(sb.toString());
    }
}