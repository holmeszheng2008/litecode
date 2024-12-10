package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 290. Word Pattern
public class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(pattern.length() != words.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            String word = words[i];
            if(map.get(c) == null){
                if(!set.contains(word)) {
                    map.put(c, word);
                    set.add(word);
                } else {
                    return false;
                }
            } else {
                if(!map.get(c).equals(word)) {
                    return false;
                }
            }
        }

        return true;
    }
}
