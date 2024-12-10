package queue_stack;

import java.util.Stack;

// 32. Longest Valid Parentheses
public class Solution32 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] memo = new int[s.length() + 1];
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') {
                stack.push(i);
                memo[i+1] = 0;
            } else {
                if(stack.isEmpty()) {
                    memo[i+1] = 0;
                } else {
                    int leftIndex = stack.pop();
                    int length = i + 1 - leftIndex + memo[leftIndex];
                    memo[i+1] = length;
                }
            }
        }

        int res = 0;
        for(int i : memo){
            res = Math.max(res, i);
        }

        return res;
    }
}


class Solution32_attempt1 {
    public int longestValidParentheses(String s) {
        int[] memo = new int[s.length()];
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.add(i);
                memo[i] = 0;
            } else {
                if(stack.isEmpty()){
                    memo[i] = 0;
                } else {
                    int left = stack.pop();
                    int size = i + 1 - left;
                    if(left == 0) {
                        memo[i] = size;
                    } else {
                        memo[i] = size + memo[left - 1];
                    }
                    res = Math.max(res, memo[i]);
                }
            }
        }

        return res;
    }
}