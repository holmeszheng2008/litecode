package string;

// 151. Reverse Words in a String
public class Solution151 {
    public String reverseWords(String s) {
        s = s + " ";
        String res = null;
        int start = -1, end = -1;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' ') {
                if (start == -1) {
                    continue;
                } else {
                    end = i;
                    String subString = s.substring(start, end);
                    if (res == null) {
                        res = subString;
                    } else {
                        res = subString + " " + res;
                    }
                    start = -1;
                    end = -1;
                }
            } else {
                if(start == -1){
                    start = i;
                }
            }
        }

        return res;
    }
}
