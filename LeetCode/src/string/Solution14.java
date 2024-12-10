package string;

/*
 * 14. Longest Common Prefix
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int i = 0;
        for (; ;i++) {
            Character c = null;
            Character temp = null;
            boolean stop = false;
            for (String str : strs) {
                try {
                    temp = str.charAt(i);
                    if (c == null) {
                        c = temp;
                    } else {
                        if (!c.equals(temp)) {
                            stop = true;
                            break;
                        }
                    }
                } catch (IndexOutOfBoundsException ex) {
                    stop = true;
                    break;
                }
            }

            if (stop) {
                break;
            }
        }
        
        return strs[0].substring(0, i);
    }
}
