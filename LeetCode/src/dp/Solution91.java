package dp;

// 91. Decode Ways
public class Solution91 {
    private Integer[] memo;
    public int numDecodings(String s) {
        this.memo = new Integer[s.length()];

        return dp(s, 0);
    }

    private int dp(String s, int index){
        if(index == s.length()){
            return 1;
        }
        if(memo[index] != null){
            return memo[index];
        }

        int choice1 = 0, choice2 = 0;
        char firstChar = s.charAt(index);
        if(firstChar == '0') {
            memo[index] = 0;
            return 0;
        }

        choice1 = dp(s, index + 1);

        if(index != s.length() - 1) {
            char secondChar = s.charAt(index + 1);
            int num = (firstChar - '0') * 10 + (secondChar - '0');
            if(num <= 26) {
                choice2 = dp(s, index + 2);
            }
        }

        memo[index] = choice1 + choice2;

        return memo[index];
    }
}
