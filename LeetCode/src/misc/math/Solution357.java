package misc.math;

// 357. Count Numbers with Unique Digits
public class Solution357 {
    private int res = 1;
    private boolean[] used;
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0){
            return 1;
        }

        this.used = new boolean[10];
        int ceiling = 1;
        for(int i = 0; i < n; i++){
            ceiling *= 10;
        }

        backtracking(0, ceiling);
        return res;
    }

    private void backtracking(long curNum, int ceiling){
        for(int i = 0; i < 10; i++){
            if(used[i]){
                continue;
            }
            long nextNum = curNum * 10 + i;
            if(nextNum == 0){
                continue;
            }
            used[i] = true;
            if(nextNum < ceiling) {
                res++;
            }
            if(nextNum >= ceiling){

            } else {
                backtracking(nextNum, ceiling);
            }


            used[i] = false;
        }
    }
}