package backtracking.num_selection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 77. Combinations
public class Solution77 {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, 1, k);

        return res;
    }

    private void backtracking(int n, int start, int k) {
        if (start == n + 1) {
            return;
        }
        if (path.size() == k + 1) {
            return;
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            if (path.size() == k) {
                res.add(new ArrayList<>(path));
            }

            backtracking(n, i + 1, k);
            path.removeLast();
        }
    }
}


class Solution77_attempt1 {
    private LinkedList<Integer> path = new LinkedList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(1, n, k);

        return res;
    }

    private void backtracking(int start, int n, int k){
        for(int i = start; i <= n; i++){
            if(n+1 - i + path.size() < k){
                break;
            }

            path.add(i);
            if(path.size() == k){
                res.add(new ArrayList<>(path));
            } else {
                backtracking(i+1, n, k);
            }

            path.removeLast();
        }
    }
}