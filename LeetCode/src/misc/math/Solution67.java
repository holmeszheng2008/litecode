package misc.math;

// 67. Add Binary
public class Solution67 {
    private int[] sum;
    private int carry;

    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();

        if(aLen < bLen){
            return addBinary(b, a);
        }

        this.sum = new int[aLen];
        addToIndex(aLen, bLen, a, b, 0, 0);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < aLen; i++){
            sb.append(sum[i]);
        }

        if(carry == 0){
            return sb.toString();
        } else {
            return "1" + sb.toString();
        }
    }

    private void addToIndex(int aLen, int bLen, String a, String b, int digitIndex, int add){
        if(aLen - 1 - digitIndex < 0){
            this.carry = add;
            return;
        }

        int tempSum = 0;
        if(bLen - 1 - digitIndex < 0){
            int aIndex = aLen - 1 - digitIndex;
            tempSum = a.charAt(aIndex) - '0' + add;
        } else {
            int aIndex = aLen - 1 - digitIndex;
            int bIndex = bLen - 1 - digitIndex;
            tempSum = a.charAt(aIndex) - '0' + b.charAt(bIndex) - '0' + add;
        }

        sum[aLen - 1 - digitIndex] = tempSum % 2;
        addToIndex(aLen, bLen, a, b, digitIndex + 1, tempSum / 2);
    }
}


class Solution67_attempt1 {
    private int[] sum;
    private boolean firstOne;
    public String addBinary(String a, String b) {
        if(a.length() < b.length()){
            return addBinary(b, a);
        }

        this.sum = new int[a.length()];
        addToDigitIndex(a, b, 0, 0);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < sum.length; i++){
            sb.append(sum[i]);
        }

        if(firstOne){
            return 1 + sb.toString();
        } else {
            return sb.toString();
        }
    }
    private void addToDigitIndex(String a, String b, int digitIndex, int carry){
        if(a.length() - 1 - digitIndex < 0){
            if(carry == 1){
                firstOne = true;
            } else {
                firstOne = false;
            }
            return;
        }

        int tempSum = 0;
        if(b.length() - 1 - digitIndex < 0){
            tempSum = a.charAt(a.length() - 1 - digitIndex) - '0' + carry;
        } else {
            tempSum = a.charAt(a.length() - 1 - digitIndex) - '0' + b.charAt(b.length() - 1 - digitIndex) - '0' + carry;
        }

        int digit = tempSum % 2;
        int nextCarry = tempSum / 2;

        sum[a.length() - 1 - digitIndex] = digit;
        addToDigitIndex(a, b, digitIndex + 1, nextCarry);
    }
}