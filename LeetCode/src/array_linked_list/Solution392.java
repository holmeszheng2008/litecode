package array_linked_list;

// 392. Is Subsequence
public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int i = 0, j = 0;
        for(; i < s.length() && j < t.length();){
            while(j < t.length()){
                if(sArray[i] != tArray[j]){
                    j++;
                } else {
                    i++;
                    j++;
                    break;
                }
            }
        }

        if(i == s.length()) {
            return true;
        }

        return false;
    }
}


class Solution392_attempt1 {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }

        return i == s.length();
    }
}