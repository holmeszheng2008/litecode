package queue_stack;

import java.util.Stack;

// 150. Evaluate Reverse Polish Notation
public class Solution150 {
    Stack<Integer> stack = new Stack<>();
    public int evalRPN(String[] tokens) {
        for(String token : tokens){
            if (token.length() == 1 && !Character.isDigit(token.charAt(0))) {
                int rightOp = stack.pop();
                int leftOp = stack.pop();
                int res = 0;
                char op = token.charAt(0);
                if(op == '+'){
                    res = leftOp + rightOp;
                } else if (op == '-') {
                    res = leftOp - rightOp;
                } else if (op == '*') {
                    res = leftOp * rightOp;
                } else if (op == '/') {
                    res = leftOp / rightOp;
                }

                stack.push(res);
            } else {
                stack.push(convertStrToNum(token));
            }
        }

        return stack.pop();

    }
    private int convertStrToNum(String s){
        int res = 0;
        int sign = 1;
        int i = 0;
        if(s.charAt(0) == '-'){
            i = 1;
            sign = -1;
        } else {
            i = 0;
            sign = 1;
        }
        for(; i < s.length(); i++){
            char c = s.charAt(i);
            res = res * 10 + (c-'0');
        }

        return res * sign;
    }
}

class Solution150_attempt1 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                switch(token){
                    case "+" -> {
                        stack.push(operand1 + operand2);
                    }
                    case "-" -> {
                        stack.push(operand1 - operand2);
                    }
                    case "*" -> {
                        stack.push(operand1 * operand2);
                    }
                    case "/" -> {
                        stack.push(operand1 / operand2);
                    }
                }
            } else {
                stack.push(convertToInt(token));
            }
        }

        return stack.pop();
    }

    private int convertToInt(String s){
        int sign = 1, start = 0;
        if(s.charAt(0) == '-'){
            sign = -1;
            start = 1;
        }
        int sum = 0;
        for(; start < s.length(); start++){
            char c = s.charAt(start);
            sum = sum * 10 + c - '0';
        }

        return sign * sum;
    }
}
