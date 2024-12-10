package string;

import java.util.ArrayList;
import java.util.List;

// 6. Zigzag Conversion
public class Solution6 {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        boolean incr = true;
        List<Character>[] lists = new List[numRows];
        int low = 0, high = numRows - 1;
        int row = 0;
        for(int i = 0; i < s.length(); i++){
            if(row == low){
                incr = true;
            }
            if(row == high){
                incr = false;
            }
            if(lists[row] == null){
                lists[row] = new ArrayList<>();
            }
            lists[row].add(s.charAt(i));

            if(incr){
                row++;
            } else {
                row--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < lists.length; i++){
            List<Character> list = lists[i];
            if(list == null){
                continue;
            }
            for(char c : list){
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
