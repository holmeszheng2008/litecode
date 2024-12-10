package misc.math;

public class Solution66 {
    private int[] digits;
    private boolean carryDigit;
    public int[] plusOne(int[] digits) {
        this.digits = digits;
        addToDigit(digits.length - 1, 1);
        if(carryDigit){
            int[] res = new int[digits.length + 1];
            for(int i = 0; i < digits.length; i++){
                res[i+1] = digits[i];
            }
            res[0] = 1;
            return res;
        } else {
            return digits;
        }
    }

    private void addToDigit(int index, int add){
        if(add == 0){
            return;
        }
        if(index == -1){
            carryDigit = true;
            return;
        }
        int sum = digits[index]+add;
        digits[index] = sum % 10;
        addToDigit(index-1, sum / 10);
    }
}
