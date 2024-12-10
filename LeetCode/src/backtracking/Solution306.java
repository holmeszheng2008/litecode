package backtracking;

// 306. Additive Number
public class Solution306 {
    private long num1 = 0;
    private int digits1 = 0;
    private long num2 = 0;
    private int digits2 = 0;
    private boolean res = false;
    private String num;
    private int n;
    public boolean isAdditiveNumber(String num) {
        this.n = num.length();
        this.num = num;
        if(n < 3){
            return false;
        }

        backtracking(0);
        return res;
    }

    private void backtracking(int index){
        int curDigit = num.charAt(index) - '0';
        if(digits2 == 0) {
            if(digits1 == 0) {
                // append num1
                num1 = num1 * 10 + curDigit;
                digits1++;
                backtracking(index+1);
                if(res){
                    return;
                }

                digits1--;
                num1 = (num1 - curDigit) / 10;
            } else {
                if((n-1)/2 == digits1 || (digits1 == 1 && num1 == 0)){
                    // append num2;
                    num2 = num2 * 10 + curDigit;
                    digits2++;
                    backtracking(index+1);
                    if(res){
                        return;
                    }
                    digits2--;
                    num2 = (num2 - curDigit) / 10;
                } else {
                    // append num1 or append num2
                    num1 = num1 * 10 + curDigit;
                    digits1++;
                    backtracking(index+1);
                    if(res){
                        return;
                    }

                    digits1--;
                    num1 = (num1 - curDigit) / 10;

                    num2 = num2 * 10 + curDigit;
                    digits2++;
                    backtracking(index+1);
                    if(res){
                        return;
                    }
                    digits2--;
                    num2 = (num2 - curDigit) / 10;
                }
            }
        } else {
            if((n-1)/2 == digits2 || (digits2 == 1 && num2 == 0)) {
                // stop num2
                if(isValid(num2, num1 + num2, index)) {
                    res = true;
                    return;
                }
            } else {
                // append num2 or stop num2
                num2 = num2 * 10 + curDigit;
                digits2++;
                backtracking(index+1);
                if(res){
                    return;
                }
                digits2--;
                num2 = (num2 - curDigit) / 10;

                if(isValid(num2, num1 + num2, index)) {
                    res = true;
                    return;
                }
            }
        }
    }

    private boolean isValid(long secondNum, long sum, int index){
        String str = String.valueOf(sum);
        if(n - index < str.length()) {
            return false;
        }

        for(int i = 0; i < str.length();){
            if(str.charAt(i++) != num.charAt(index++)){
                return false;
            }
        }

        if(index == n){
            return true;
        }

        return isValid(sum, sum + secondNum, index);
    }
}
