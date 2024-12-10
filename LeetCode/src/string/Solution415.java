package string;

// 415. Add Strings
public class Solution415 {
    public String addStrings(String num1, String num2) {
        if(num1.equals("0") && num2.equals("0")){
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int newLength = Math.max(m, n) + 1;
        char[] resArray = new char[newLength];

        int carry = 0;

        for(int i = m-1, j = n-1; i >= 0 || j >= 0; i--, j--){
            int digitI = 0, digitJ = 0;
            if(i >= 0){
                digitI = num1.charAt(i) - '0';
            }
            if(j >= 0){
                digitJ = num2.charAt(j) - '0';
            }
            int digit = digitI + digitJ + carry;
            carry = digit / 10;
            digit = digit % 10;

            resArray[Math.max(i, j) + 1] = (char)(digit + '0');
        }

        if(carry > 0){
            resArray[0] = (char)(carry + '0');
        }

        int i = 0;
        while(resArray[i] == '0' || resArray[i] == 0){
            i++;
        }

        StringBuilder sb = new StringBuilder();
        while(i < newLength){
            sb.append(resArray[i]);

            i++;
        }

        return sb.toString();
    }
}
