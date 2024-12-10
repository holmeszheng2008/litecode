package backtracking.num_selection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 39. Combination Sum
public class Solution39 {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, 0, target);

        return res;
    }

    private void backtracking(int[] candidates, int start, int target) {
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) {
                continue;
            }

            target -= candidates[i];
            path.add(candidates[i]);

            if (target == 0) {
                res.add(new ArrayList<>(path));
            } else {
                backtracking(candidates, i, target);
            }

            target += candidates[i];
            path.removeLast();
        }
    }
}

// 思路二
class Solution39_attempt1 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private int sum = 0;
    private int[] candidates;
    private int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        for(int i = 0, j = candidates.length - 1; i < j; i++, j--){
            candidates[i] ^= candidates[j];
            candidates[j] ^= candidates[i];
            candidates[i] ^= candidates[j];
        }
        this.candidates = candidates;
        this.target = target;

        backtracking(0);

        return res;
    }

    private void backtracking(int i){
        if(i == candidates.length){
            return;
        }
        int num = candidates[i];
        if(num + sum <= target){
            path.add(num);
            sum += num;
            if(sum == target) {
                res.add(new ArrayList<>(path));
            } else {
                backtracking(i);
            }
            path.remove(path.size() - 1);
            sum -= num;
        }


        backtracking(i+1);
    }
}


class Solution39_attempt2 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private int sum = 0;
    private int[] candidates;
    private int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;

        backtracking(0);

        return res;
    }

    private void backtracking(int start){
        for(int i = start; i < candidates.length; i++){
            int value = candidates[i];
            if(value + sum > target){
                continue;
            }
            sum += value;
            path.add(value);
            if(sum == target) {
                res.add(new ArrayList<>(path));
            } else {
                backtracking(i);
            }

            sum -= value;
            path.remove(path.size() - 1);
        }
    }
}