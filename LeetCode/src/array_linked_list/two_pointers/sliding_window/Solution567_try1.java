package array_linked_list.two_pointers.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Solution567_try1 {
    public boolean checkInclusion(String s1, String s2) {
        char[] s1Array = s1.toCharArray();
        Map<Character, Integer> need = new HashMap<>();
        for(char c : s1Array) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, valid = 0;
        
        while (right < s2.length()) {
            char in = s2.charAt(right);
            right++;
            if (need.containsKey(in)) {
                window.put(in, window.getOrDefault(in, 0) + 1);
                if (window.get(in).equals(need.get(in))) {
                    valid++;
                } else if (window.get(in).equals(need.get(in) + 1)) {
                    valid--;
                    while (true) {
                        char out = s2.charAt(left);
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
                return true;
            }
        }
        
        return false;
    }
}
