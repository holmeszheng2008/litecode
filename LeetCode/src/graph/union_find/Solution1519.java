package graph.union_find;

import java.util.ArrayList;
import java.util.List;

// 1519. Number of Nodes in the Sub-Tree With the Same Label
public class Solution1519 {
    private List<Integer>[] graph;
    private String labels;
    private int[] res;
    private boolean[] visited;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        this.graph = new ArrayList[n];
        this.labels = labels;
        this.res = new int[n];
        this.visited = new boolean[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        divide(0);

        return res;
    }

    private int[] divide(int index){
        int[] tempRes = new int[26];
        if(visited[index]){
            return tempRes;
        }
        visited[index] = true;
        for(int nextNode : graph[index]){
            int[] nextRes = divide(nextNode);
            for(int i = 0; i < 26; i++){
                tempRes[i] += nextRes[i];
            }
        }

        tempRes[labels.charAt(index) - 'a']++;
        res[index] = tempRes[labels.charAt(index) - 'a'];

        return tempRes;
    }
}
