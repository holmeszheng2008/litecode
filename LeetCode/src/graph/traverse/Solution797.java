package graph.traverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 797. All Paths From Source to Target
public class Solution797 {
    private int[][] graph;
    private List<List<Integer>> res = new ArrayList<>();
    private int n;
    private LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.n = graph.length;
        this.graph = graph;
        dfs(0);
        return res;
    }

    private void dfs(int v) {
        path.add(v);
        if (v == n - 1) {
            res.add(new ArrayList<>(path));
        } else {
            for (int i : graph[v]) {
                dfs(i);
            }
        }

        path.removeLast();
    }
}
