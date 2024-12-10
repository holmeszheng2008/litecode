package backtracking.num_selection;

import java.util.ArrayList;
import java.util.List;

// 216. Combination Sum III
public class Solution216 {
    private int k;
    private int n;
    private List<List<Integer>> res;
    private List<Integer> path;
    private int sum;
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n;
        this.res = new ArrayList<>();
        this.path = new ArrayList<>();

        backtracking(1);
        return res;
    }

    private void backtracking(int start){
        for(int i = start; i <= 9; i++){
            if(sum + i > n){
                break;
            }

            sum += i;
            path.add(i);
            if(path.size() == k){
                if(sum == n){
                    res.add(new ArrayList<>(path));
                }
            } else {
                backtracking(i + 1);
            }

            sum -= i;
            path.remove(path.size() - 1);
        }
    }
}
