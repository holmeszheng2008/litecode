package queue_stack;

import java.util.Stack;

// 921. Minimum Add to Make Parentheses Valid
public class Solution921 {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] sArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char c = sArray[i];
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    char out = stack.peek();
                    if (out == '(') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }
        }
        return stack.size();
    }
}

class Solution921_attempt1 {
    public int minAddToMakeValid(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            } else {
                if(stack.isEmpty()) {
                    res++;
                } else {
                    stack.pop();
                }
            }
        }

        res += stack.size();
        return res;
    }
}