package array_linked_list;

// 43. Multiply Strings
public class Solution43 {
    int[] resArray;
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        this.resArray = new int[num1.length() + num2.length()];
        for(int i = num1.length() - 1; i >= 0; i--){
            for(int j = num2.length() - 1; j >= 0; j--){
                int actualI = num1.length() - 1 - i;
                int actualJ = num2.length() - 1 - j;
                int tempProduction = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                increToIth(actualI+actualJ, tempProduction % 10);
                increToIth(actualI+actualJ + 1, tempProduction / 10);
            }
        }

        int start = 0;
        while(resArray[start] == 0){
            start++;
        }

        StringBuilder sb = new StringBuilder();
        for(; start < resArray.length; start++){
            sb.append(resArray[start]);
        }

        return sb.toString();

    }

    private void increToIth(int i, int num){
        if(num == 0){
            return;
        }
        int index = resArray.length - 1 - i;
        int afterIncre = resArray[index] + num;
        resArray[index] = afterIncre % 10;
        increToIth(i+1, afterIncre / 10);
    }
}

class Solution43_attempt1 {
    private int[] production;
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int len = m + n;
        this.production = new int[len];

        for(int i = num1.length() - 1; i >= 0; i--){
            for(int j = num2.length() - 1; j >=0; j--){
                int digitI = num1.length() - 1 - i;
                int digitJ = num2.length() - 1 - j;

                int num = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                addToIndex(num, len - 1 - (digitI + digitJ));
            }
        }

        StringBuilder sb = new StringBuilder();
        int start = -1;
        for(int i = 0; i < production.length; i++){
            if(production[i] == 0){
                i++;
            } else {
                start = i;
                break;
            }
        }

        if(start == -1){
            return "0";
        }

        for(int i = start; i < production.length; i++){
            sb.append(production[i]);
        }

        return sb.toString();

    }

    private void addToIndex(int num, int index){
        if(num == 0) {
            return;
        }
        num += production[index];
        int digit = num % 10;
        int carry = num / 10;
        production[index] = digit;
        addToIndex(carry, index - 1);
    }
}
