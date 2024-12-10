package binary_search_tree;

import util.Pair;

import java.util.HashMap;
import java.util.Map;

// 96. Unique Binary Search Trees
public class Solution96 {
    private Integer[] memo;
    public int numTrees(int n) {
        memo = new Integer[n + 1];
        return helper(n);
    }

    public int helper(int n) {
        int count = 0;
        if (n == 0 || n == 1) {
            return 1;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        for (int i = 1; i <= n; i++) {
            count += helper(i - 1) * helper(n - i);
        }

        memo[n] = count;
        return count;
    }
}

class Solution96_attempt1 {
    private Map<Pair<Integer, Integer>, Integer> memo = new HashMap<>();
    public int numTrees(int n) {
        return create(1, n);
    }

    private int create(int low, int high){
        if(low >= high){
            return 1;
        }

        Pair<Integer, Integer> key = new Pair<>(low, high);
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        int res = 0;
        for(int i = low; i <= high; i++){
            int left = create(low, i-1);
            int right = create(i+1, high);
            res += left * right;
        }

        memo.put(key, res);
        return res;
    }
}