package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 205. Isomorphic Strings
public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            char char1 = s.charAt(i);
            char char2 = t.charAt(i);

            if(map.containsKey(char1)){
                if(map.get(char1) != char2){
                    return false;
                }
            } else {
                if(set.contains(char2)){
                    return false;
                }
                set.add(char2);
                map.put(char1, char2);
            }
        }

        return true;
    }
}

