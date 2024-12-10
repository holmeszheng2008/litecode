package backtracking.num_selection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 78. Subsets
public class Solution78 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        backtracking(nums, 0, new LinkedList<>());

        return res;
    }

    private void backtracking(int[] nums, int start, LinkedList<Integer> preSet) {
        if (start == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            preSet.add(nums[i]);
            res.add(new ArrayList<>(preSet));
            backtracking(nums, i + 1, preSet);
            preSet.removeLast();
        }
    }
}

class Solution78_attempt1 {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    private int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>(path));
        this.nums = nums;

        backtracking(0);
        return res;
    }

    private void backtracking(int start) {
        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);

            res.add(new ArrayList<>(path));
            backtracking(i + 1);

            path.removeLast();
        }
    }
}
