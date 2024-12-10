package backtracking.num_selection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 90. Subsets II
public class Solution90 {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res.add(new ArrayList<>());
        backtracking(nums, 0);

        return res;
    }

    private void backtracking(int[] nums, int start) {
        int pre = Integer.MAX_VALUE;
        for (int i = start; i < nums.length; i++) {
            if (nums[i] == pre) {
                continue;
            }
            pre = nums[i];
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            backtracking(nums, i + 1);

            path.removeLast();
        }
    }
}


class Solution90_attempt1 {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    private int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);
        res.add(new ArrayList<>());

        backtracking(0);
        return res;
    }

    private void backtracking(int start){
        int pre = Integer.MAX_VALUE;
        for(int i = start; i < nums.length; i++){
            if(nums[i] == pre){
                continue;
            }
            pre = nums[i];
            path.add(nums[i]);

            res.add(new ArrayList<>(path));
            backtracking(i+1);

            path.removeLast();
        }
    }
}