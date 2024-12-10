package misc.math;

// 8. String to Integer (atoi)
public class Solution8 {
    public int myAtoi(String s) {
        int sign = 1;
        s = s.trim();
        if(s.length() == 0){
            return 0;
        }
        if(s.charAt(0) == '+'){
            s = s.substring(1);
        } else if (s.charAt(0) == '-'){
            sign = -1;
            s = s.substring(1);
        }
        long res = 0;
        for(char c : s.toCharArray()){
            if(!Character.isDigit(c)) {
                break;
            }
            res = res * 10 + c-'0';

            if(sign == 1 && res > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(sign == -1 && res > -1l * Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }

        return sign * (int)res;
    }
}
