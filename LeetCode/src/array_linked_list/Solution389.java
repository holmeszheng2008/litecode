package array_linked_list;

// 389. Find the Difference
public class Solution389 {
    public char findTheDifference(String s, String t) {
        int[] dict = new int[26];
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        for(char c : sArray){
            dict[c-'a']++;
        }
        for(char c : tArray){
            if(dict[c-'a'] == 0){
                return c;
            }
            dict[c-'a']--;
        }

        return 1;
    }
}
