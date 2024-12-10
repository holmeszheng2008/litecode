package misc.math;

// 405. Convert a Number to Hexadecimal
public class Solution405 {
    public String toHex(int num) {
        char[] cArray = new char[8];
        char[] dict = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        int firstNon0Bit = 7;
        int mask = 15;
        for(int i = 0; i < 8; i++){
            int bitsValue = num & mask;
            char c = dict[bitsValue];
            if(c != '0'){
                firstNon0Bit = 7-i;
            }
            cArray[7-i] = c;

            num = num >>> 4;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = firstNon0Bit; i < 8; i++){
            sb.append(cArray[i]);
        }

        return sb.toString();
    }
}

class Solution405_attempt1 {
    public String toHex(int num) {
        char[] dict = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        int mask = 15;

        String res = "";
        while(num != 0){
            res = dict[num & mask] + res;
            num = num >>> 4;
        }

        if(res.length() == 0){
            res = "0";
        }
        return res;
    }
}
