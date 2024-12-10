package array_linked_list.two_pointers.sliding_window;

import java.util.HashSet;
import java.util.Set;

// 3. Longest Substring Without Repeating Characters
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> window = new HashSet<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            char in = s.charAt(right);
            right++;
            if (!window.contains(in)) {
                window.add(in);
                res = (res > window.size()) ? res : window.size();
            } else {
                while (true) {
                    char out = s.charAt(left);
                    left++;
                    if (out != in) {
                        window.remove(out);
                    } else {
                        break;
                    }
                }
            }
        }

        return res;
    }
}

class Solution3_attempt1 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int res = 0;
        int left = 0, right = 0;
        while(right < s.length()){
            char add = s.charAt(right++);
            if(!window.contains(add)){
                window.add(add);
                res = Math.max(res, right - left);
            } else {
                while(s.charAt(left) != add){
                    window.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
        }

        return res;
    }
}

class Solution3_attempt2{
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int left = 0, right = 0;
        Set<Character> window = new HashSet<>();
        while(right < s.length()){
            char inChar = s.charAt(right);
            right++;

            if(window.contains(inChar)){
                while(s.charAt(left) != inChar){
                    window.remove(s.charAt(left));
                    left++;
                }
                left++;
            } else {
                window.add(inChar);
                int tempLength = right - left;
                if(length < tempLength){
                    length = tempLength;
                }
            }
        }

        return length;
    }
}