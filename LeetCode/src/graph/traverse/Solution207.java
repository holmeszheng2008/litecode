package graph.traverse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 207. Course Schedule
public class Solution207 {
    private List<Integer>[] graph;
    private boolean visited[];
    private Set<Integer> path = new HashSet<>();
    private boolean hasCycle = false;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        visited = new boolean[numCourses];
        buildGraph(prerequisites);

        for (int i = 0; i < numCourses; i++) {
            traverse(i);
        }

        return !hasCycle;
    }

    private void buildGraph(int[][] prerequisites) {
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[0], to = prerequisite[1];
            graph[from].add(to);
        }
    }

    private void traverse(int s) {
        if (path.contains(s)) {
            hasCycle = true;
            return;
        }
        if (hasCycle) {
            return;
        }
        if (visited[s]) {
            return;
        }
        visited[s] = true;
        path.add(s);
        List<Integer> nextNodes = graph[s];
        for (int nextNode : nextNodes) {
            traverse(nextNode);
        }
        path.remove(s);
    }
}


class Solution207_attempt1 {
    private boolean[] visited;
    private boolean hasCycle = false;
    private List<Integer>[] graph;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.graph = new ArrayList[numCourses];
        this.visited = new boolean[numCourses];
        for(int[] prerequisite : prerequisites){
            List<Integer> list = graph[prerequisite[0]];
            if(list == null){
                list = new ArrayList<>();
                graph[prerequisite[0]] = list;
            }

            list.add(prerequisite[1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                dfs(i, new HashSet<>());
            }
        }

        return !hasCycle;
    }

    private void dfs(int node, Set<Integer> path){
        if(path.contains(node)){
            hasCycle = true;
            return;
        }
        if(visited[node]){
            return;
        }

        visited[node] = true;
        path.add(node);

        List<Integer> nextNodes = graph[node];
        if(nextNodes != null){
            for(int nextNode : nextNodes){
                dfs(nextNode, path);
                if(hasCycle){
                    return;
                }
            }
        }

        path.remove(node);
    }
}