package graph.bipartite;

import java.util.ArrayList;
import java.util.List;

// 886. Possible Bipartition
public class Solution886 {
    private List<Integer>[] graph;
    private boolean res = true;
    private Boolean color[];
    private boolean visited[];


    public boolean possibleBipartition(int n, int[][] dislikes) {
        graph = new ArrayList[n + 1];
        color = new Boolean[n + 1];
        visited = new boolean[n + 1];
        buildGraph(dislikes);

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            dfs(i);
        }
        return res;
    }

    private void buildGraph(int[][] dislikes) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] dislike : dislikes) {
            int from = dislike[0], to = dislike[1];
            graph[from].add(to);
            graph[to].add(from);
        }
    }

    private void dfs(int v) {
        if (!res) {
            return;
        }

        if (color[v] == null) {
            color[v] = true;
        }
        for (int node : graph[v]) {
            if (visited[node]) {
                if (color[v] == color[node]) {
                    res = false;
                    return;
                }
            } else {
                visited[node] = true;
                color[node] = !color[v];
                dfs(node);
            }

        }
    }
}
