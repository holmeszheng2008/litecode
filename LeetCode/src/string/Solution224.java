package string;

import java.util.Stack;

public class Solution224 {
    public int calculate(String s) {
        char[] sArray = s.toCharArray();
        char sign = '+';
        int res = 0;
        int num = 0;
        for (int i = 0; i < sArray.length; i++) {
            char c = sArray[i];
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (c == '(') {
                StringBuilder sb = new StringBuilder();
                Stack<Character> bracketChecker = new Stack<>();
                bracketChecker.push('(');
                i++;
                while(!bracketChecker.isEmpty()) {
                    c = sArray[i];
                    if (c == ')' && bracketChecker.size() == 1) {
                        i++;
                        if(i < sArray.length){
                            c = sArray[i];
                        }
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
            }
            if (i >= sArray.length - 1 || (!Character.isDigit(c) && c != ' ')) {
                if(sign == '-'){
                    num = -num;
                }
                res = res + num;

                num = 0;
                sign = c;
            }
        }

        return res;
    }

}


class Solution772 {
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
            if (c == '(') {
                StringBuilder sb = new StringBuilder();
                Stack<Character> bracketChecker = new Stack<>();
                bracketChecker.push('(');
                i++;
                while (!bracketChecker.isEmpty()) {
                    c = sArray[i];
                    if (c == ')' && bracketChecker.size() == 1) {
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
            }

            if (i == sArray.length - 1 || i == '+' || i == '-' || i == '*' || i == '/') {
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
