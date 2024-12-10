package string;

// 125. Valid Palindrome
public class Solution125 {
    public boolean isPalindrome(String s) {
        char[] sArray = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while(left <= right){
            while(left <= right && !Character.isLetterOrDigit(sArray[left])) {
                left++;
            }
            while(left <= right && !Character.isLetterOrDigit(sArray[right])) {
                right--;
            }

            if(left <= right){
                if(Character.toLowerCase(sArray[left]) != Character.toLowerCase(sArray[right])) {
                    return false;
                }
                left++;
                right--;
            }
        }

        return true;
    }
}
