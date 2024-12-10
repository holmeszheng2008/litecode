package misc.math;

// 372. Super Pow
public class Solution372 {
    public int superPow(int a, int[] b) {
        return doPow(a, b, b.length-1);
    }
    private int doPow(int a, int[] b, int endIndex){
        if(endIndex != 0){
            if(b[endIndex] == 0){
                int temp = doPow(a, b, endIndex - 1) % 1337;
                return pow(temp, 10);
            } else {
                int endDigit = b[endIndex];
                b[endIndex] = 0;
                return pow(a, endDigit) * doPow(a, b, endIndex) % 1337;
            }
        } else {
            int endDigit = b[endIndex];
            return pow(a, endDigit);
        }
    }

    // b is one digit
    private int pow(int a, int b){
        if(b == 0){
            return 1;
        }
        int res = 1;
        for(int i = 0; i < b; i++){
            res = (int)(1l * a * res % 1337);
        }

        return res;
    }
}
