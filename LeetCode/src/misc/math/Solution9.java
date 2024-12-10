package misc.math;

// 9. Palindrome Number
public class Solution9 {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        long xl = x;
        long reverse = 0;

        while(xl != 0){
            reverse = reverse * 10 + xl % 10;
            xl = xl / 10;
        }

        return x == reverse;
    }
}

class Solution9_attempt1 {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int copy = x;
        int reverse = 0;
        while(copy != 0){
            int digit = copy % 10;
            if(reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && digit > 7)) {
                return false;
            }
            reverse = reverse * 10 + digit;
            copy /= 10;
        }

        return x == reverse;
    }
}
