package string;

import java.util.Stack;

// 227. Basic Calculator II
public class Solution227 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int sign = '+';
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            if(i == s.length() - 1 || c == '+' || c == '-' || c == '*' || c == '/'){
                switch (sign){
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
                }

                sign = c;
                num = 0;
            }
        }

        int res = 0;
        while(!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }
}
