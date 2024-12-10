package array_linked_list;

// 14. Longest Common Prefix
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        String res = "";
        for (int i = 0; ; i++) {
            if(i == strs[0].length()){
                break;
            }
            char c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(i == strs[j].length() || strs[j].charAt(i) != c){
                    return res;
                }
            }

            res = res + c;
        }

        return res;
    }
}
