package string;

// 409. Longest Palindrome
public class Solution409 {
    public int longestPalindrome(String s) {
        boolean hasOdd = false;
        int[] count = new int[256];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i)]++;
        }

        int res = 0;
        for(int i = 0; i < count.length; i++){
            int num = count[i];
            if(num % 2 == 0){
                res += num;
            } else {
                res += num - 1;
                hasOdd = true;
            }
        }

        if(hasOdd){
            res++;
        }

        return res;
    }
}
