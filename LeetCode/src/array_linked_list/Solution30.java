package array_linked_list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 30. Substring with Concatenation of All Words
// brute force (not good)
public class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> wordCount = new HashMap<>();
        for(String word : words){
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        Map<String, Integer> tempWordCount = new HashMap<>();
        int numOfWords = words.length;
        int lengthOfWord = words[0].length();
        int subStrLength = numOfWords * lengthOfWord;
        char[] sArray = s.toCharArray();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i <= sArray.length - subStrLength; i++){
            int j = i;
            for(; j < i + subStrLength; j += lengthOfWord){
                String str = String.valueOf(sArray, j, lengthOfWord);

                int count = tempWordCount.getOrDefault(str, 0) + 1;
                if(wordCount.getOrDefault(str, 0) < count){
                    break;
                }
                tempWordCount.put(str, count);
            }
            if(j == i + subStrLength){
                res.add(i);
            }

            tempWordCount.clear();
        }

        return res;
    }
}

// With memos
class Solution30_attempt1 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> wordCount = new HashMap<>();
        for(String word : words){
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        int oneWordLength = words[0].length();
        Map<String, Integer>[] mapList = new Map[oneWordLength];

        int size = words.length * oneWordLength;

        for(int i = 0; i < s.length() - size + 1; i++){
            Map<String, Integer> map = mapList[i%oneWordLength];
            if(map == null) {
                map = new HashMap<>();
                mapList[i % oneWordLength] = map;
                for (int j = i; j < i + size; j += oneWordLength) {
                    String word = s.substring(j, j + oneWordLength);
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }
                if(wordCount.equals(map)) {
                    res.add(i);
                }
            } else {
                String toRemove = s.substring(i-oneWordLength, i);
                String toAdd = s.substring(i+size - oneWordLength, i+size);
                int value = map.get(toRemove) - 1;
                if(value == 0){
                    map.remove(toRemove);
                } else {
                    map.put(toRemove, value);
                }
                map.put(toAdd, map.getOrDefault(toAdd, 0) + 1);

                if(wordCount.equals(map)) {
                    res.add(i);
                }
            }
        }


        return res;
    }
}