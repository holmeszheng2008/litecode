package backtracking.num_selection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 40. Combination Sum II
public class Solution40 {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, 0, target);

        return res;
    }

    private void backtracking(int[] candidates, int start, int target) {
        for (int i = start; i < candidates.length; i++) {
            if (i - 1 >= start && candidates[i - 1] == candidates[i]) {
                continue;
            }
            if (target - candidates[i] < 0) {
                break;
            }

            target -= candidates[i];
            path.add(candidates[i]);

            if (target == 0) {
                res.add(new ArrayList<>(path));
            } else {
                backtracking(candidates, i + 1, target);
            }

            target += candidates[i];
            path.removeLast();
        }
    }
}

// 思路二：选或者不选
class Solution40_attempt1 {
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();
    private int target;
    private int sum;
    private int[] candidates;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.target = target;
        this.candidates = candidates;

        backtracking(0);
        return res;
    }

    private void backtracking(int i){
        if(i == candidates.length){
            return;
        }
        int value = candidates[i];
        if(sum + value <= target){
            sum += value;
            path.add(value);

            if(sum == target){
                res.add(new ArrayList<>(path));
            } else {
                backtracking(i+1);
            }

            sum -= value;
            path.remove(path.size() - 1);
        }

        int nextI = i+1;
        while(nextI < candidates.length && candidates[nextI] == value){
            nextI++;
        }
        backtracking(nextI);
    }
}


class Solution40_attempt2 {
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();
    private int target;
    private int sum;
    private int[] candidates;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.target = target;
        this.candidates = candidates;

        backtracking(0);
        return res;
    }

    private void backtracking(int start){
        for(int i = start; i < candidates.length; i++){
            if(i != start && candidates[i] == candidates[i-1]) {
                continue;
            }
            int value = candidates[i];
            if(value + sum > target){
                continue;
            }
            sum += value;
            path.add(value);
            if(sum == target){
                res.add(new ArrayList<>(path));
            } else {
                backtracking(i+1);
            }

            sum -= value;
            path.remove(path.size() - 1);
        }
    }
}

class Solution {
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;
    private int target;
    private int sum;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;

        backtracking(0);
        return res;
    }

    private void backtracking(int start){
        int preSel = Integer.MAX_VALUE;
        for(int i = start; i < candidates.length; i++){
            int num = candidates[i];
            if(sum + num > target || preSel == num){
                continue;
            }

            preSel = num;
            sum += num;
            path.add(num);

            if(sum == target){
                res.add(new ArrayList<>(path));
            } else {
                backtracking(i+1);
            }

            sum -= num;
            path.remove(path.size() - 1);
        }
    }
}