package queue_stack;

import java.util.Deque;
import java.util.LinkedList;

// 316. Remove Duplicate Letters
public class Solution361 {
    public String removeDuplicateLetters(String s) {
        char[] sArray = s.toCharArray();
        int[] count = new int[26];
        boolean[] instack = new boolean[26];
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < sArray.length; i++) {
            count[sArray[i] - 'a']++;
        }
        for (char c : sArray) {
            count[c - 'a']--;
            if (instack[c - 'a']) {
                continue;
            }
            while (!deque.isEmpty() && deque.peekLast() >= c) {
                if (count[deque.peekLast()] == 0) {
                    break;
                }
                char out = deque.pollLast();
                instack[out - 'a'] = false;
            }
            deque.offerLast(c);
            instack[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }

        return sb.toString();
    }
}
