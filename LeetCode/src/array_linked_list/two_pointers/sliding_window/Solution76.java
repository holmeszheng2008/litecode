package array_linked_list.two_pointers.sliding_window;

import java.util.HashMap;
import java.util.Map;

// 76. Minimum Window Substring
public class Solution76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] tArray = t.toCharArray();
        for (char c : tArray) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, valid = 0, length = Integer.MAX_VALUE;
        int start = 0, end = 0;
        while (right < s.length()) {
            Character in = s.charAt(right);
            right++;
            if (need.get(in) != null) {
                window.put(in, window.getOrDefault(in, 0) + 1);
                if (window.get(in).equals(need.get(in))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                int currentLength = right - left;
                if (currentLength < length) {
                    length = currentLength;
                    start = left;
                    end = right;
                }
                Character out = s.charAt(left);
                left++;
                if (need.get(out) != null) {
                    window.put(out, window.get(out) - 1);
                    if (window.get(out).equals(need.get(out) - 1)) {
                        valid--;
                    }
                }
            }
        }

        return s.substring(start, end);
    }
}

class Solution76_attempt1{
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int fulfilledKeys = 0;
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int resLeft = -1, length = Integer.MAX_VALUE;

        while(right < s.length()) {
            char inChar = s.charAt(right);
            right++;
            window.put(inChar, window.getOrDefault(inChar, 0) + 1);

            if(need.containsKey(inChar)){
                if(window.get(inChar).equals(need.get(inChar))){
                    fulfilledKeys++;
                }

                if(fulfilledKeys == need.keySet().size()){
                    for(; left < right; ){
                        int tempLength = right - left;
                        if(length > tempLength){
                            length = tempLength;
                            resLeft = left;
                        }

                        char outChar = s.charAt(left);
                        left++;
                        window.put(outChar, window.get(outChar) - 1);

                        if(need.containsKey(outChar) && need.get(outChar) == window.get(outChar) + 1) {
                            fulfilledKeys--;
                            break;
                        }
                    }
                }
            }

        }

        if(length == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(resLeft, resLeft + length);
    }
}
