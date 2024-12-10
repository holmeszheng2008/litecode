package dp;

// 132. Palindrome Partitioning II
public class Solution132 {
    private Integer[] memo;
    private String s;
    public int minCut(String s) {
        this.s = s;
        this.memo = new Integer[s.length()];

        return dp(0) - 1;
    }

    private int dp(int start){
        if(memo[start] != null){
            return memo[start];
        }
        int res = Integer.MAX_VALUE;
        for(int end = start; end < s.length(); end++){
            String substring = s.substring(start, end + 1);
            if(!isPalindrome(substring)){
                continue;
            }
            if(end == s.length() - 1){
                res = 1;
                break;
            }
            int nextLength = dp(end + 1);
            res = Math.min(nextLength + 1, res);
        }

        memo[start] = res;
        return res;
    }

    private boolean isPalindrome(String s){
        int left = 0, right = s.length() - 1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
