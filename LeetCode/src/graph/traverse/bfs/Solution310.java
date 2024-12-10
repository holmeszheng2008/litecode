package graph.traverse.bfs;

import java.util.*;

// 310. Minimum Height Trees
public class Solution310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1){
            return Arrays.asList(0);
        }
        Set<Integer>[] graph = new HashSet[n];
        for(int i = 0; i < n; i++){
            graph[i] = new HashSet<>();
        }
        constructGraph(graph, edges);


        Queue<Integer> queue = new LinkedList<>();
        int visitedNum = 0;
        for(int i = 0; i < n; i++){
            if(graph[i].size() == 1){
                queue.add(i);
                visitedNum++;
            }
        }

        while(visitedNum != n){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int node = queue.poll();
                Set<Integer> children = graph[node];
                for(int child : children){
                    graph[child].remove(node);
                    if(graph[child].size() == 1){
                        visitedNum++;
                        queue.add(child);
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>(queue);
        return res;
    }

    private void constructGraph(Set<Integer>[] graph, int[][] edges) {
        for(int[] edge: edges) {
            int a = edge[0], b = edge[1];
            graph[a].add(b);
            graph[b].add(a);
        }
    }
}
