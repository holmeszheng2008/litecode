package queue_stack;

import java.util.Deque;
import java.util.LinkedList;

// 738. Monotone Increasing Digits
public class Solution738 {
    public int monotoneIncreasingDigits(int n) {
        Deque<Integer> deque = new LinkedList<>();
        int digitNum = 0;
        if(n >= 0 && n <= 9){
            return n;
        }

        int nBackup = n;
        while(n != 0){
            deque.offerFirst(n % 10);
            n /= 10;
            digitNum++;
        }

        int wDigit = 0;
        for(int i = 1; i < digitNum; i++){
            int digit = deque.removeLast();
            int preDigit = deque.getLast();
            if(preDigit > digit){
                wDigit = i;
                deque.removeLast();
                deque.offerLast(preDigit-1);
            }
        }

        if(wDigit == 0){
            return nBackup;
        }

        for(int i = 1; i <= wDigit; i++){
            nBackup /= 10;
        }
        nBackup -= 1;
        for(int i = 1; i <= wDigit; i++){
            nBackup = 10 * nBackup + 9;
        }

        return nBackup;
    }
}
