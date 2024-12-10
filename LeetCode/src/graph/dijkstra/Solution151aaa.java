package graph.dijkstra;

import java.util.LinkedList;
import java.util.List;

// 1514. Path with Maximum Probability
public class Solution151aaa {
    // 记录被访问过的节点
    boolean[] visited;
    // 记录当前遍历从起点到当前节点的路径
    LinkedList<Integer> path = new LinkedList<>();
    // adjacent list representing a graph
    List<Integer>[] graph;

    public void dfs(int v) {
        // 仅在每个连通分量的入口的时候需要，因为已经visited的不能作为入口，入口进来以后需要set成visited
        // 对于连通分量内的其他vertex来说，被poll出来后一定是visited
        // 因为入stack时已经验证他们没有之前visited过，并set了visited
        visited[v] = true;

        path.add(v);
        for (int nextNode : graph[v]) {
            if (!visited[nextNode]) {
                visited[nextNode] = true;
                dfs(nextNode);
            }
        }
        path.removeLast();
    }
}
