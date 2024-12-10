package backtracking.num_selection;

import java.util.*;

// 491. Non-decreasing Subsequences
public class Solution491 {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<Integer>();
    private int[] nums;

    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums= nums;
        if(nums.length == 1){
            return res;
        }

        backtracking(0);

        return res;
    }

    private void backtracking(int start){
        Set<Integer> previous = new HashSet<>();
        for(int i = start; i < nums.length; i++){
            if(previous.contains(nums[i])){
                continue;
            }
            if(!(path.size() == 0 || path.peekLast() <= nums[i])){
                continue;
            }
            previous.add(nums[i]);

            path.add(nums[i]);
            if(path.size() >= 2){
                res.add(new ArrayList<>(path));
            }
            backtracking(i + 1);

            path.removeLast();
        }
    }
}
