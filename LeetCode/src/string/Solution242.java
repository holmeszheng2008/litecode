package string;

import java.util.HashMap;
import java.util.Map;

// 242. Valid Anagram
public class Solution242 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] memo = new int[26];
        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            memo[index]++;
        }
        for(int i = 0; i < t.length(); i++){
            int index = t.charAt(i) - 'a';
            memo[index]--;
            if(memo[index] < 0){
                return false;
            }
        }

        return true;
    }
}

class Solution242_attempt1 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) - 1);
            if(map.get(c) < 0){
                return false;
            }
        }


        return true;
    }
}