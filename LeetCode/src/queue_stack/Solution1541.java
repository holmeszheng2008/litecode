package queue_stack;

import java.util.Stack;

// 1541. Minimum Insertions to Balance a Parentheses String
public class Solution1541 {
    public int minInsertions(String s) {
        char[] sArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int needs = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            char c = sArray[i];
            if (c == '(') {
                stack.push(c);
            } else {
                if (i == length - 1) {
                    needs++;
                } else {
                    i++;
                    char cNext = sArray[i];
                    if (cNext == ')') {

                    } else {
                        i--;
                        needs++;
                    }
                }
                if (stack.isEmpty()) {
                    needs++;
                } else {
                    stack.pop();
                }
            }
        }

        return needs + stack.size() * 2;
    }
}

class Solution1541_attempt1 {
    public int minInsertions(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i = 0; i < s.length();) {
            char c = s.charAt(i);
            if (c == '('){
                stack.push(i);
                i++;
            } else {
                if(i == s.length() - 1){
                    res++;
                    i++;
                } else {
                    char nextC = s.charAt(i+1);
                    if(nextC == ')'){
                        i+=2;
                    } else {
                        i+=1;
                        res++;
                    }
                }

                if(stack.isEmpty()){
                    res++;
                } else {
                    stack.pop();
                }
            }
        }

        res += 2 * stack.size();

        return res;
    }
}