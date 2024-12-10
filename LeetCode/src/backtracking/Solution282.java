package backtracking;

import java.util.*;

// 282. Expression Add Operators
public class Solution282 {
    private List<String> res = new ArrayList<>();
    private String num;
    private int target;
    private StringBuilder sb = new StringBuilder();
    private LinkedList<Long> stack = new LinkedList<>();
    private Stack<Long> zeroStack = new Stack<>();
    public List<String> addOperators(String num, int target) {
        if(num.length() == 1){
            if(num.charAt(0) - '0' == target){
                return Arrays.asList(num);
            }
        }

        this.target = target;
        this.num = num;
        sb.append(num.charAt(0));
        backtracking(1, '+', num.charAt(0) - '0');

        return res;
    }

    private void backtracking(int index, char op, long opNum){
        long newNum = 0;
        // '+'
        kickout(opNum, op);
        sb.append('+');
        sb.append(num.charAt(index));
        newNum = num.charAt(index) - '0';
        if(index == num.length() - 1){
            long sum = getStackSum();
            if(sum + newNum == target){
                res.add(sb.toString());
            }
        } else {
            backtracking(index+1, '+', newNum);
        }

        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        reverseKickout(opNum, op);

        // '-'
        kickout(opNum, op);
        sb.append('-');
        sb.append(num.charAt(index));
        newNum = num.charAt(index) - '0';
        if(index == num.length() - 1){
            long sum = getStackSum();
            if(sum - newNum == target){
                res.add(sb.toString());
            }
        } else {
            backtracking(index+1, '-', newNum);
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        reverseKickout(opNum, op);

        // ''
        if(opNum != 0){
            sb.append(num.charAt(index));
            newNum = opNum * 10 + (num.charAt(index) - '0');

            if(index == num.length() - 1){
                kickout(newNum, op);
                long sum = getStackSum();
                if(sum == target) {
                    res.add(sb.toString());
                }
                reverseKickout(newNum, op);
            } else {
                backtracking(index + 1, op, newNum);
            }

            sb.deleteCharAt(sb.length() - 1);
        }

        // '*'
        kickout(opNum, op);
        sb.append('*');
        sb.append(num.charAt(index));
        newNum = num.charAt(index) - '0';
        if(index == num.length() - 1) {
            kickout(newNum, '*');
            long sum = getStackSum();
            if (sum == target) {
                res.add(sb.toString());
            }
            reverseKickout(newNum, '*');
        } else {
            backtracking(index + 1, '*', newNum);
        }

        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        reverseKickout(opNum, op);
    }

    private void kickout(long num, char op){
        switch (op){
            case '+' -> {
                stack.push(Long.valueOf(num));
            }
            case '-' -> {
                stack.push(Long.valueOf(-num));
            }
            case '*' -> {
                if(num == 0){
                    long temp = stack.pop();
                    stack.push(0l);
                    zeroStack.push(temp);
                } else {
                    stack.push(stack.pop() * num);
                }
            }
        }
    }

    private void reverseKickout(long num, char op){
        switch (op){
            case '+','-' -> {
                stack.pop();
            }
            case '*' -> {
                if(num == 0) {
                    long temp = zeroStack.pop();
                    stack.pop();
                    stack.push(temp);
                } else {
                    stack.push(stack.pop() / num);
                }
            }
        }
    }

    private long getStackSum(){
        long sum = 0;
        LinkedList<Long> copy = new LinkedList<>(stack);
        while(!copy.isEmpty()){
            sum += copy.pop();
        }
        return sum;
    }
}
