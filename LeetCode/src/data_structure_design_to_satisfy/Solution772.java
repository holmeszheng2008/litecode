package data_structure_design_to_satisfy;

import java.util.Stack;

// 772. Basic Calculator + - * / ( )
public class Solution772 {
    public int calculate(String s) {
        char[] sArray = s.toCharArray();
        char sign = '+';
        int res = 0;
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < sArray.length; i++) {
            char c = sArray[i];
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if ((!Character.isDigit(c) && c != ' ') || i == sArray.length - 1) {
                if (c == '(') {
                    StringBuilder sb = new StringBuilder();
                    Stack<Character> bracketChecker = new Stack<>();
                    bracketChecker.push('(');
                    i++;
                    while(!bracketChecker.isEmpty()) {
                        c = sArray[i];
                        if (c == ')' && bracketChecker.size() == 1) {
                            i++;
                            break;
                        }
                        sb.append(c);
                        if (c == '(') {
                            bracketChecker.push(c);
                        } else if (c == ')') {
                            bracketChecker.pop();
                        }
                        i++;
                    }
                    num = calculate(sb.toString());
                    while(i < sArray.length) {
                        c = sArray[i];
                        if (c == ' ') {
                            i++;
                        } else {
                            break;
                        }
                    }
                }
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                num = 0;
                sign = c;
            }
        }
        while (!stack.isEmpty()) {
            res = res + stack.pop();
        }

        return res;
    }
}
