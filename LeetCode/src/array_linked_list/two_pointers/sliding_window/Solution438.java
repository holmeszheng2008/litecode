package array_linked_list.two_pointers.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 438. Find All Anagrams in a String
class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        char[] pArray = p.toCharArray();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : pArray) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, valid = 0;

        while (right < s.length()) {
            char in = s.charAt(right);
            right++;
            if (need.containsKey(in)) {
                window.put(in, window.getOrDefault(in, 0) + 1);
                if (window.get(in).equals(need.get(in))) {
                    valid++;
                } else if (window.get(in).equals(need.get(in) + 1)) {
                    valid--;
                    while (true) {
                        char out = s.charAt(left);
                        left++;
                        window.put(out, window.get(out) - 1);
                        if (window.get(out).equals(need.get(out) - 1)) {
                            valid--;
                        }
                        if (out == in) {
                            valid++;
                            break;
                        }
                    }
                }
            } else {
                window.clear();
                left = right;
                valid = 0;
            }

            if (valid == need.size()) {
                res.add(left);
                valid--;
                char out = s.charAt(left);
                left++;
                window.put(out, window.get(out) - 1);
            }
        }

        return res;
    }
}


class Solution438_attempt1 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(p.length() > s.length()){
            return res;
        }

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        while(right < s.length()){
            char inChar = s.charAt(right);
            right++;
            window.put(inChar, window.getOrDefault(inChar, 0) + 1);
            if(right - left == p.length()){
                if(window.equals(map)){
                    res.add(left);
                }

                char outChar = s.charAt(left);
                left++;
                int count = window.get(outChar) - 1;
                if(count == 0){
                    window.remove(outChar);
                } else {
                    window.put(outChar, window.get(outChar) - 1);
                }
            }
        }

        return res;
    }
}

class Solution438_attempt2 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(p.length() > s.length()){
            return res;
        }

        Map<Character, Integer> need = new HashMap<>();
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, valid = 0;
        while(right < s.length()){
            char inChar = s.charAt(right);
            right++;
            window.put(inChar, window.getOrDefault(inChar, 0) + 1);
            if(need.containsKey(inChar) && window.get(inChar).equals(need.get(inChar))){
                valid++;
            }
            if(right - left == p.length()){
                if(valid == need.keySet().size()){
                    res.add(left);
                }

                char outChar = s.charAt(left);
                left++;
                window.put(outChar, window.get(outChar) - 1);

                if(need.containsKey(outChar) && window.get(outChar) == need.get(outChar) - 1) {
                    valid--;
                }
            }
        }

        return res;
    }
}