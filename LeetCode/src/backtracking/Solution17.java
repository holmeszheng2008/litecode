package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 17. Letter Combinations of a Phone Number
public class Solution17 {
    private String digits;
    private StringBuilder sb = new StringBuilder();
    private List<String> res = new ArrayList<>();
    private Map<Character, char[]> dialMap = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return res;
        }
        this.digits = digits;

        dialMap.put('2', new char[]{'a', 'b', 'c'});
        dialMap.put('3', new char[]{'d', 'e', 'f'});
        dialMap.put('4', new char[]{'g', 'h', 'i'});
        dialMap.put('5', new char[]{'j', 'k', 'l'});
        dialMap.put('6', new char[]{'m', 'n', 'o'});
        dialMap.put('7', new char[]{'p', 'q', 'r', 's'});
        dialMap.put('8', new char[]{'t', 'u', 'v'});
        dialMap.put('9', new char[]{'w', 'x', 'y', 'z'});

        backtracking(0);

        return res;
    }

    private void backtracking(int i){
        char number = digits.charAt(i);
        char[] chars = dialMap.get(number);
        for(char c : chars){
            sb.append(c);
            if(i == digits.length() - 1){
                res.add(sb.toString());
            } else {
                backtracking(i + 1);
            }

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
