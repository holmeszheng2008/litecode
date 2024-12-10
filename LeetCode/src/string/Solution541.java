package string;

// 541. Reverse String II
public class Solution541 {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i += 2 * k){
            int lastIndex = Math.min(i + k - 1, s.length() - 1);
            for(int j = lastIndex; j >= i; j--){
                sb.append(s.charAt(j));
            }

            int lastIndex2 = Math.min(i + 2 * k - 1, s.length() - 1);
            for(int j = lastIndex + 1; j <= lastIndex2; j++){
                sb.append(s.charAt(j));
            }
        }

        return sb.toString();
    }
}
