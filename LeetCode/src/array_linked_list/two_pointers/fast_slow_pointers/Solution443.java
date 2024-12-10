package array_linked_list.two_pointers.fast_slow_pointers;

import java.util.LinkedList;

// 443. String Compression
public class Solution443 {
    public int compress(char[] chars) {
        char lastChar = chars[0];
        int slow = 0, fast = 1;
        int groupLength = 1;
        while(fast <= chars.length){
            if(fast == chars.length || chars[fast] != lastChar){
                if(groupLength == 1) {
                    chars[slow] = lastChar;
                    slow++;
                } else {
                    chars[slow] = lastChar;
                    slow++;
                    LinkedList<Integer> digits = new LinkedList<>();
                    while(groupLength != 0){
                        int digit = groupLength % 10;
                        digits.addFirst(digit);
                        groupLength = groupLength / 10;
                    }

                    while(!digits.isEmpty()) {
                        chars[slow] = (char)(digits.removeFirst() + '0');
                        slow++;
                    }
                }

                if(fast == chars.length){
                    break;
                }
                groupLength = 1;
                lastChar = chars[fast];

                fast++;
            } else {
                fast++;
                groupLength++;
            }
        }

        return slow;
    }
}
