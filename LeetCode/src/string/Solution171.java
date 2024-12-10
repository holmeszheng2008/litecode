package string;

// 171. Excel Sheet Column Number
public class Solution171 {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for(int i = 0; i < columnTitle.length(); i++){
            char c = columnTitle.charAt(i);
            int val = c - 'A' + 1;

            res = res * 26 + val;
        }

        return res;
    }
}
