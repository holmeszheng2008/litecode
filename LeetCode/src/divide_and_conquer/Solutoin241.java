package divide_and_conquer;

import java.util.ArrayList;
import java.util.List;

// 241. Different Ways to Add Parentheses
public class Solutoin241 {
    private char[] expArray;
    public List<Integer> diffWaysToCompute(String expression) {

        expArray = expression.toCharArray();
        return doCompute(0, expression.length()-1);
    }

    private List<Integer> doCompute(int low, int high){
        List<Integer> res = new ArrayList<>();
        if (high - low <= 1) {
            res.add(convert(low, high));
            return res;
        }
        for(int i = low; i <= high; i++){
            if(expArray[i] == '+'){
                List<Integer> left = doCompute(low, i-1);
                List<Integer> right = doCompute(i+1, high);
                for(int leftInteger : left){
                    for(int rightInteger : right){
                        res.add(leftInteger + rightInteger);
                    }
                }
            } else if (expArray[i] == '-') {
                List<Integer> left = doCompute(low, i-1);
                List<Integer> right = doCompute(i+1, high);
                for(int leftInteger : left){
                    for(int rightInteger : right){
                        res.add(leftInteger - rightInteger);
                    }
                }
            } else if (expArray[i] == '*') {
                List<Integer> left = doCompute(low, i-1);
                List<Integer> right = doCompute(i+1, high);
                for(int leftInteger : left){
                    for(int rightInteger : right){
                        res.add(leftInteger * rightInteger);
                    }
                }
            }
        }

        return res;
    }

    private int convert(int low, int high) {
        int res = 0;
        for(int i = low; i <= high; i++){
            res = res * 10 + expArray[i] - '0';
        }

        return res;
    }
}
