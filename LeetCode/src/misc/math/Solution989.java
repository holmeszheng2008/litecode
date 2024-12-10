package misc.math;

import java.util.LinkedList;
import java.util.List;

// 989. Add to Array-Form of Integer
public class Solution989 {
    private LinkedList<Integer> res;
    public List<Integer> addToArrayForm(int[] num, int k) {
        this.res = new LinkedList<>();
        doAdd(num, 0, k);

        return res;
    }

    private void doAdd(int[] num, int digitIndex, int carry){
        if(num.length - 1 - digitIndex < 0 && carry == 0){
            return;
        }

        int tempSum = 0;
        if(num.length - 1 - digitIndex < 0){
            tempSum = carry;
        } else {
            tempSum = num[num.length - 1 - digitIndex] + carry;
        }

        int digit = tempSum % 10;
        int nextCarry = tempSum / 10;

        res.addFirst(digit);
        doAdd(num, digitIndex + 1, nextCarry);
    }
}
