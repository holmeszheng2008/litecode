package array_linked_list.two_pointers.sliding_window;

import java.util.HashSet;
import java.util.Set;

// 424. Longest Repeating Character Replacement
public class Solution424 {
    public int characterReplacement(String s, int k) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            set.add(s.charAt(i));
        }

        int maxLength = Integer.MIN_VALUE;
        for(char c : set){
            int temp = slide(s, k, c);
            maxLength = Math.max(maxLength, temp);
        }

        return maxLength;
    }

    private int slide(String s, int k, char targetChar){
        int maxLength = 0;
        int countOfTargetChar = 0;
        int left = 0, right = 0;
        while(right < s.length()){
            char in = s.charAt(right++);
            if(in == targetChar){
                countOfTargetChar++;
            }
            while(right - left - countOfTargetChar > k){
                char out = s.charAt(left++);
                if(out == targetChar){
                    countOfTargetChar--;
                }
            }

            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }
}

class Solution424_attempt1 {
    public int characterReplacement(String s, int k) {
        int res = Integer.MIN_VALUE;
        int[] count = new int[26];
        int maxFreq = 0;
        int left = 0, right = 0;
        while(right < s.length()){
            char inChar = s.charAt(right++);
            count[inChar - 'A']++;
            if(count[inChar - 'A'] > maxFreq){
                maxFreq = count[inChar - 'A'];
            }
            while(right - left - maxFreq > k){
                char outChar = s.charAt(left++);
                count[outChar - 'A']--;
                if(count[outChar - 'A'] == maxFreq - 1){
                    maxFreq = getMaxFreq(count);
                }
            }

            res = Math.max(res, right - left);
        }

        return res;
    }

    private int getMaxFreq(int[] count){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 26; i++){
            max = Math.max(max, count[i]);
        }

        return max;
    }
}