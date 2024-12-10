package backtracking;

import java.util.*;

// 46. Permutations
public class Solution46 {
    private List<List<Integer>> res = new ArrayList<>();
    private Set<Integer> used = new HashSet<>();
    private LinkedList<Integer> path = new LinkedList<>();
    private int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        backtracking();

        return res;
    }

    private void backtracking(){
        for(int num : nums){
            if(used.contains(num)){
                continue;
            }
            path.add(num);
            used.add(num);

            if(path.size() == nums.length){
                res.add(new ArrayList<>(path));
            } else {
                backtracking();
            }

            path.removeLast();
            used.remove(num);
        }
    }
}

class Solution46_attempt1 {
    private Set<Integer> set = new HashSet<>();
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();
    private int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;

        backtracking();

        return res;
    }

    private void backtracking(){
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(set.contains(num)){
                continue;
            }
            set.add(num);
            path.add(num);

            if(path.size() == nums.length){
                res.add(new ArrayList<>(path));
            } else {
                backtracking();
            }

            set.remove(num);
            path.remove(path.size()-1);
        }
    }
}


class Solution46_attempt2 {
    private List<List<Integer>> res;
    private boolean[] used;
    private List<Integer> path;
    private int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        this.res = new ArrayList<>();
        this.used = new boolean[n];
        this.path = new ArrayList<>();
        this.nums = nums;

        backtracking();

        return res;
    }

    private void backtracking(){
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            if(path.size() == nums.length){
                res.add(new ArrayList<>(path));
            } else {
                backtracking();
            }

            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}