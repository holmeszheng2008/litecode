package graph.traverse;

import java.util.ArrayList;
import java.util.List;

// 1319. Number of Operations to Make Network Connected
public class Solution1319 {
    private boolean[] visited;
    private List<Integer>[] graph;

    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1){
            return -1;
        }

        visited = new boolean[n];
        graph = new ArrayList[n];

        int componentSize = 0;
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] connection : connections){
            graph[connection[0]].add(connection[1]);
            graph[connection[1]].add(connection[0]);
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                componentSize++;
                dfs(i);
            }
        }

        return componentSize - 1;
    }

    private void dfs(int i){
        List<Integer> nextNodes = graph[i];
        for(int nextNode : nextNodes){
            if(!visited[nextNode]) {
                visited[nextNode] = true;
                dfs(nextNode);
            }
        }
    }
}

class Solution1319_attempt1 {
    private boolean[] visited;
    private List<Integer>[] graph;

    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1){
            return -1;
        }

        visited = new boolean[n];
        graph = new ArrayList[n];

        int componentSize = 0;
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] connection : connections){
            graph[connection[0]].add(connection[1]);
            graph[connection[1]].add(connection[0]);
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                componentSize++;
                dfs(i);
            }
        }

        return componentSize - 1;
    }

    private void dfs(int i){
        if(visited[i]){
            return;
        }
        visited[i] = true;
        List<Integer> nextNodes = graph[i];
        for(int nextNode : nextNodes){
                dfs(nextNode);
        }
    }
}

class Solution1319_attempt2 {
    private static class UF{
        private int n;
        private int[] parent;

        public UF(int n) {
            this.n = n;
            parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }

        private int count(){
            return n;
        }

        private boolean connected(int i, int j){
            int rootI = findRoot(i);
            int rootJ = findRoot(j);

            if(rootI == rootJ){
                return true;
            }

            return false;
        }

        private void union(int i, int j){
            int rootI = findRoot(i);
            int rootJ = findRoot(j);

            if(rootI == rootJ){
                return;
            }
            n--;

            parent[rootJ] = rootI;
        }

        private int findRoot(int i){
            if(parent[i] == i){
                return i;
            }

            parent[i] = findRoot(parent[i]);
            return parent[i];
        }
    }
    public int makeConnected(int n, int[][] connections) {

        if(connections.length < n-1){
            return -1;
        }

        UF uf = new UF(n);

        for(int[] connection : connections){
            uf.union(connection[0], connection[1]);
        }

        return uf.count() - 1;
    }
}