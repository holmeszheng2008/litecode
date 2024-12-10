package string;

// 1071. Greatest Common Divisor of Strings
public class Solution1071 {
    public String gcdOfStrings(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        if(m > n){
            return gcdOfStrings(str2, str1);
        }
        int divisorLength = m;
        for(; divisorLength >= 1; divisorLength--){
            if(m % divisorLength == 0 && n % divisorLength == 0){
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < divisorLength; i++){
            sb.append(str1.charAt(i));
        }

        String divisor = sb.toString();

        for(int i = 0; i < m; i++){
            int j = i % divisorLength;
            if(str1.charAt(i) != divisor.charAt(j)){
                return "";
            }
        }

        for(int i = 0; i < n; i++){
            int j = i % divisorLength;
            if(str2.charAt(i) != divisor.charAt(j)){
                return "";
            }
        }

        return divisor;
    }
}
