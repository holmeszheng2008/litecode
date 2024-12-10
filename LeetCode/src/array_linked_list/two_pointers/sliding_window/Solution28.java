package array_linked_list.two_pointers.sliding_window;

// 28. Find the Index of the First Occurrence in a String
public class Solution28 {
    public int strStr(String haystack, String needle) {
        int res = -1;
        int left = 0, right = 0;
        StringBuilder window = new StringBuilder();
        while(right < haystack.length()){
            window.append(haystack.charAt(right));
            right++;
            if(window.length() == needle.length()){
                if(window.toString().equals(needle)){
                    return left;
                }
                left++;
                window.deleteCharAt(0);
            }
        }

        return -1;
    }
}

class Solution28_attempt1 {
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        int left = 0, right = 0;

        StringBuilder window = new StringBuilder();

        while(right < haystack.length()){
            char inC = haystack.charAt(right);
            right++;
            window.append(inC);
            if(right - left == n){
                if(needle.equals(window.toString())){
                    return left;
                }
                window.deleteCharAt(0);
                left++;
            }
        }

        return -1;
    }
}