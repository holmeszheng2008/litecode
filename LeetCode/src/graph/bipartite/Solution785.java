package graph.bipartite;

import java.util.LinkedList;
import java.util.Queue;

// 785. Is Graph Bipartite?
public class Solution785 {
    private boolean color[];
    private boolean visited[];
    private boolean isInvalid;
    private int[][] graph;

    public boolean isBipartite(int[][] graph) {
        this.graph = graph;
        color = new boolean[graph.length];
        visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            dfs(i);
        }
        return !isInvalid;
    }

    private void dfs(int v) {
        if (isInvalid) {
            return;
        }
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        for (int nextNode : graph[v]) {
            if (visited[nextNode]) {
                if (color[nextNode] == color[v]) {
                    isInvalid = true;
                    return;
                }
            } else {
                color[nextNode] = !color[v];
                dfs(nextNode);
            }
        }
    }
}


class Solution785_BFS {
    private Boolean[] color;
    private int[][] graph;
    private boolean[] visited;
    private boolean res = true;

    public boolean isBipartite(int[][] graph) {
        color = new Boolean[graph.length];
        visited = new boolean[graph.length];
        this.graph = graph;

        for (int v = 0; v < graph.length; v++) {
            if (visited[v]) {
                continue;
            }
            bfs(v);
        }

        return res;

    }

    private void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        color[v] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int nextNode : graph[node]) {
                    if (!res) {
                        return;
                    }
                    if (visited[nextNode]) {
                        if (color[nextNode] == color[node]) {
                            res = false;
                            return;
                        }
                    } else {
                        visited[nextNode] = true;
                        color[nextNode] = !color[node];
                        queue.add(nextNode);
                    }
                }
            }
        }
    }
}
