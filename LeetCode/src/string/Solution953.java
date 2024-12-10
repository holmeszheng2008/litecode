package string;

import java.util.HashMap;
import java.util.Map;

// 953. Verifying an Alien Dictionary
public class Solution953 {
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length == 1) {
            return true;
        }
        Map<Character, Integer> orderMap = new HashMap<>();
        for(int i = 0; i < order.length(); i++){
            orderMap.put(order.charAt(i), i);
        }

        for(int i = 0; i < words.length - 1; i++){
            if(!isValid(orderMap, words[i], words[i+1])){
                return false;
            }
        }

        return true;
    }

    private boolean isValid(Map<Character, Integer> orderMap, String word1, String word2) {
        for(int i = 0; i < word1.length(); i++){
            if(i == word2.length()){
                return false;
            }
            Integer order1 = orderMap.get(word1.charAt(i));
            Integer order2 = orderMap.get(word2.charAt(i));
            if(order1 < order2){
                return true;
            } else if (order1 > order2){
                return false;
            }
        }

        return true;
    }
}
