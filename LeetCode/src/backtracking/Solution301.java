package backtracking;

import java.util.*;

// 301. Remove Invalid Parentheses
public class Solution301 {
    private String s;
    private Set<String> res;
    private StringBuilder sb;
    private Stack<Character> stack = new Stack<>();
    public List<String> removeInvalidParentheses(String s) {
        int leftCount = 0, rightCount = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                leftCount++;
            } else if(c == ')'){
                rightCount++;
            }
        }
        this.s = s;
        this.res = new HashSet<>();
        this.sb = new StringBuilder();

        if(leftCount > rightCount) {
            backtracking(true, leftCount - rightCount, 0);
        } else if (leftCount < rightCount){
            backtracking(false, rightCount - leftCount, 0);
        } else {
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(c == '('){
                    stack.push(c);
                } else if (c == ')') {
                    if(stack.isEmpty()) {
                        return removeAllP();
                    } else {
                        stack.pop();
                    }
                }
            }

            return Arrays.asList(s);
        }


        if(res.isEmpty()) {
            return removeAllP();
        }
        return new ArrayList<>(res);
    }

    private void backtracking(boolean isLeftToRemove, int count, int index){
        char c = s.charAt(index);
        if(c != '(' && c != ')') {
            sb.append(c);
            if (index == s.length() - 1) {
                if(count == 0){
                    res.add(sb.toString());
                }
            } else {
                backtracking(isLeftToRemove, count, index + 1);
            }

            sb.deleteCharAt(sb.length() - 1);
        } else if(count == 0 || (isLeftToRemove && c == ')') || (!isLeftToRemove && c == '(')){
            if(c == '(') {
                stack.push(c);
                sb.append(c);
                if(index == s.length() - 1) {

                } else {
                    backtracking(isLeftToRemove, count, index+1);
                }
                sb.deleteCharAt(sb.length() - 1);
                stack.pop();
            } else {
                if(stack.isEmpty()) {
                    return;
                }
                stack.pop();
                sb.append(c);
                if(index == s.length() - 1){
                    if(count == 0){
                        res.add(sb.toString());
                    }
                } else {
                    backtracking(isLeftToRemove, count, index+1);
                }

                stack.push('(');
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            if(isLeftToRemove && c == '(') {
                // delete
                count--;
                if(index == s.length()  -1) {
                    if (count == 0) {
                        res.add(sb.toString());
                    }
                } else {
                    backtracking(isLeftToRemove, count, index+1);
                }
                count++;

                // no delete
                stack.push(c);
                sb.append(c);
                if(index == s.length() - 1) {

                } else {
                    backtracking(isLeftToRemove, count, index+1);
                }
                sb.deleteCharAt(sb.length() - 1);
                stack.pop();
            } else {
                // delete
                count--;
                if(index == s.length()  -1) {
                    if (count == 0) {
                        res.add(sb.toString());
                    }
                } else {
                    backtracking(isLeftToRemove, count, index+1);
                }
                count++;

                // no delete
                if(stack.isEmpty()) {
                    return;
                }
                stack.pop();
                sb.append(c);
                if(index == s.length() - 1){
                    if(count == 0){
                        res.add(sb.toString());
                    }
                } else {
                    backtracking(isLeftToRemove, count, index+1);
                }

                stack.push('(');
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private List<String> removeAllP(){
        StringBuilder tsb = new StringBuilder();
        for(int j = 0; j < s.length(); j++){
            char cj = s.charAt(j);
            if(cj != '(' && cj != ')'){
                tsb.append(cj);
            }
        }
        return Arrays.asList(tsb.toString());
    }
}

class Solution301_pass {
    private Stack<Character> stack = new Stack<>();
    private StringBuilder sb = new StringBuilder();
    private String s;
    private Set<String> tempRes = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        this.s = s;

        backtracking(0);
        int maxLength = 0;
        for(String tempS : tempRes){
            maxLength = Math.max(maxLength, tempS.length());
        }

        List<String> res = new ArrayList<>();
        for(String tempS : tempRes){
            if(tempS.length() == maxLength){
                res.add(tempS);
            }
        }

        return res;
    }

    private void backtracking(int index){
        char c = s.charAt(index);
        if(c != '(' && c != ')') {
            sb.append(c);
            if (index == s.length() - 1) {
                if (stack.isEmpty()) {
                    tempRes.add(sb.toString());
                }
            } else {
                backtracking(index + 1);
            }
            sb.deleteCharAt(sb.length() - 1);
        } else {
            if(c == '('){
                // delete
                if(index == s.length() - 1){
                    if(stack.isEmpty()){
                        tempRes.add(sb.toString());
                    }
                } else {
                    backtracking(index + 1);
                }

                // no delete
                stack.push(c);
                sb.append(c);
                if(index == s.length() - 1){

                } else {
                    backtracking(index + 1);
                }
                sb.deleteCharAt(sb.length() - 1);
                stack.pop();
            } else {
                // delete
                if(index == s.length() - 1){
                    if(stack.isEmpty()){
                        tempRes.add(sb.toString());
                    }
                } else {
                    backtracking(index + 1);
                }

                // no delete
                if(stack.isEmpty()){
                    return;
                }
                stack.pop();
                sb.append(c);
                if(index == s.length() - 1){
                    if(stack.isEmpty()){
                        tempRes.add(sb.toString());
                    }
                } else {
                    backtracking(index + 1);
                }
                stack.push('(');
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}