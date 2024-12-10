package divide_and_conquer;

import util.Pair;

import java.util.HashMap;
import java.util.Map;

// 87. Scramble String
public class Solution87 {
    private Map<Pair<String, String>, Boolean> memo = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }

        if(s1.length() == 1){
            return s1.equals(s2);
        }

        Pair<String, String> key = new Pair<>(s1, s2);
        if(memo.containsKey(key)) {
            return memo.get(key);
        }

/*        Map<Character, Integer> map = new HashMap();
        for(int i = 0; i < s1.length(); i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            map.put(c2, map.getOrDefault(c2, 0) - 1);
        }

        for(int i : map.values()) {
            if(i != 0){
                memo.put(key, false);
                return false;
            }
        }*/

        Map<Character, Integer> map1 = new HashMap();
        Map<Character, Integer> map2 = new HashMap();
        for(int i = 0; i < s1.length(); i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            map1.put(c1, map1.getOrDefault(c1, 0) + 1);
            map2.put(c2, map2.getOrDefault(c2, 0) + 1);
        }

        if(map1.keySet().size() != map2.keySet().size()){
            memo.put(key, false);
            return false;
        }

        for(char c : map1.keySet()){
           if(!map2.containsKey(c) || map1.get(c) != map2.get(c)) {
               memo.put(key, false);
               return false;
           }
        }

        for(int i = 1; i < s1.length(); i++){
            boolean res;
            String s1First = s1.substring(0, i);
            String s1Second = s1.substring(i);
            String s2First = s2.substring(0, i);
            String s2Second = s2.substring(i);

            res = isScramble(s1First, s2First) && isScramble(s1Second, s2Second);
            if(res){
                memo.put(key, true);
                return true;
            }

            s2First = s2.substring(s2.length() - i);
            s2Second = s2.substring(0, s2.length() - i);

            res = isScramble(s1First, s2First) && isScramble(s1Second, s2Second);
            if(res){
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }
}
