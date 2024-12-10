package queue_stack;

import java.util.Stack;

// 20. Valid Parentheses
public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] sArray = s.toCharArray();
        for (int i = 0; i < sArray.length; i++) {
            char c = sArray[i];
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char out = stack.pop();
                if ((c == ')' && out == '(') || (c == '}' && out == '{') || (c == ']' && out == '[')) {

                } else {
                    return false;
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}

class Solution20_attempt1{
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                char topC = stack.pop();
                if (!((topC == '(' && c == ')') || (topC == '[' && c == ']') || (topC == '{' && c == '}'))) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

class Solution20_attempt2 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                Character top = stack.peek();
                if((top == '(' && c == ')') || (top == '{' && c == '}') || (top == '[' && c == ']')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}