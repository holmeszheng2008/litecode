package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 187. Repeated DNA Sequences
// sliding window
public class Solution187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> seenMap = new HashMap<>();
        int left = 0, right = 0;
        StringBuilder window = new StringBuilder();

        while(right < s.length()){
            window.append(s.charAt(right));
            right++;
            if(right - left == 10){
                String temp = window.toString();
                Integer seenInteger = seenMap.get(temp);
                if(seenInteger == null){
                    seenMap.put(temp, 1);
                } else {
                    if (seenInteger == 1) {
                        res.add(temp);
                    }
                    seenInteger++;
                    seenMap.put(temp, seenInteger);
                }

                window.deleteCharAt(0);
                left++;
            }
        }

        return res;
    }
}
