package graph.topological_sort;

import java.util.*;

// 210. Course Schedule II
public class Solution210 {
    private List<Integer>[] graph;
    private LinkedList<Integer> res = new LinkedList<>();
    private boolean hasCycle = false;
    private boolean[] visited;
    private Set<Integer> path = new HashSet<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                dfs(i);
                if (hasCycle) {
                    return new int[] {};
                }
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    private void buildGraph(int n, int[][] prerequisites) {
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];
            graph[from].add(to);
        }
    }

    private void dfs(int v) {
        if (hasCycle) {
            return;
        }
        if (path.contains(v)) {
            hasCycle = true;
            return;
        }
        if (visited[v]) {
            return;
        }
        visited[v] = true;

        path.add(v);
        for (int nextNode : graph[v]) {
            dfs(nextNode);
        }
        
        path.remove(v);
        res.addFirst(v);
    }
}


class Solution210_attempt1 {
    private List<Integer>[] graph;
    private LinkedList<Integer> res;
    private Set<Integer> onPath;
    private boolean[] visited;
    private boolean hasCycle;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] prerequisite : prerequisites){
            graph[prerequisite[1]].add(prerequisite[0]);
        }
        this.res = new LinkedList<>();
        this.onPath = new HashSet<>();
        this.visited = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                dfs(i);
                if(hasCycle){
                    return new int[0];
                }
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(int i){
        if(onPath.contains(i)) {
            hasCycle = true;
            return;
        }
        if(visited[i]){
            return;
        }
        visited[i] = true;
        onPath.add(i);

        List<Integer> nextNodes = graph[i];
        for(int nextNode : nextNodes) {
            dfs(nextNode);
            if(hasCycle){
                return;
            }
        }
        res.addFirst(i);

        onPath.remove(i);
    }
}