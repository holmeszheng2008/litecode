package string;

public class Solution168 {
    public String convertToTitle(int columnNumber) {
        if(columnNumber == 0){
            return "";
        }
        columnNumber -= 1;

        int quotient = columnNumber / 26;
        int remainder = columnNumber % 26;

        return convertToTitle(quotient) + (char)(remainder + 'A');
    }
}


class Solution168_attempt1 {
    public String convertToTitle(int columnNumber) {
        String res = "";
        while(columnNumber > 0){
            columnNumber -= 1;
            int remainder = columnNumber % 26;
            res = (char)(remainder + 'A') + res;

            columnNumber /= 26;
        }

        return res;
    }
}