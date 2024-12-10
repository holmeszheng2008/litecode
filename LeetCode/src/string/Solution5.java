package string;

public class Solution5 {
    public String longestPalindrome(String s) {
        String res = "";
        for(int i = 0; i < s.length(); i++){
            String temp = getPalindrome(s, i, i);
            if(temp.length() > res.length()){
                res = temp;
            }
        }
        for(int i = 0; i < s.length() - 1; i++){
            String temp = getPalindrome(s, i, i+1);
            if(temp.length() > res.length()){
                res = temp;
            }
        }

        return res;
    }

    private String getPalindrome(String s, int i, int j){
        while(i >= 0 && j < s.length()){
            if(s.charAt(i) != s.charAt(j)){
                break;
            }
            i--;
            j++;
        }
        return s.substring(i+1, j);
    }
}
