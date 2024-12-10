package array_linked_list;

import java.util.HashMap;
import java.util.Map;

// 387. First Unique Character in a String
public class Solution387 {
    public int firstUniqChar(String s) {
        char[] sArray = s.toCharArray();
        boolean[] repeated = new boolean[sArray.length];
        Map<Character, Integer> charToFirstIndexMap = new HashMap<>();
        for(int i = 0; i < sArray.length; i++){
            char c = sArray[i];
            if(charToFirstIndexMap.containsKey(c)) {
                repeated[i] = true;
                repeated[charToFirstIndexMap.get(c)] = true;
            } else {
                charToFirstIndexMap.put(c, i);
            }
        }

        for(int i = 0; i < sArray.length; i++){
            if(!repeated[i]){
                return i;
            }
        }

        return -1;
    }
}

class Solution387_attempt1 {
    public int firstUniqChar(String s) {
        char[] sArray = s.toCharArray();
        Map<Character, Integer> countMap = new HashMap<>();
        for(int i = 0; i < sArray.length; i++){
            char c = sArray[i];
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < sArray.length; i++){
            char c = sArray[i];
            if(countMap.get(c) == 1){
                return i;
            }
        }

        return -1;
    }
}

class Solution387_attempt2 {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            // 将字符转化成数字
            count[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count[c - 'a'] == 1) {
                // 第一个出现一次的字符
                return i;
            }
        }
        return -1;
    }
}