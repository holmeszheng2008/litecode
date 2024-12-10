package graph.traverse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 802. Find Eventual Safe States
public class Solution802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Set<Integer> safeNodesSet = new HashSet<>();
        int n = graph.length;
        List<Integer>[] fromGraph = new ArrayList[n];

        for(int i = 0; i < graph.length; i++){
            int[] nextNodes = graph[i];
            if(nextNodes.length == 0) {
                safeNodesSet.add(i);
            } else {
                for(int j : nextNodes){
                    List<Integer> list = fromGraph[j];
                    if(list == null){
                        list = new ArrayList<>();
                        fromGraph[j] = list;
                    }
                    list.add(i);
                }
            }
        }

        List<Integer> newSafeNodes=  new ArrayList<>(safeNodesSet);
        while(!newSafeNodes.isEmpty()) {
            List<Integer> tempNewSafeNodes= new ArrayList<>();
            for(int safeNode : newSafeNodes){
                List<Integer> fromNodes = fromGraph[safeNode];
                if(fromNodes == null){
                    continue;
                }
                for(int from : fromNodes){
                    int[] nextNodes = graph[from];
                    boolean valid = true;
                    for(int nextNode : nextNodes){
                        if(!safeNodesSet.contains(nextNode)) {
                            valid = false;
                            break;
                        }
                    }
                    if(valid){
                        tempNewSafeNodes.add(from);
                        safeNodesSet.add(from);
                    }
                }
            }

            newSafeNodes = tempNewSafeNodes;
        }


        List<Integer> res = new ArrayList<>(safeNodesSet);
        res.sort(Integer::compare);

        return res;
    }
}

class Solution802_attempt1 {
    private boolean[] visited;
    private int[][] graph;
    private Set<Integer> notSafeNodes = new HashSet<>();
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        this.graph = graph;
        this.visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, new HashSet<>());
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(!notSafeNodes.contains(i)){
                res.add(i);
            }
        }

        return res;
    }

    private boolean dfs(int node, Set<Integer> path){
        if(path.contains(node)){
            return false;
        }
        if(visited[node]){
            if(notSafeNodes.contains(node)){
                return false;
            } else {
                return true;
            }
        }

        visited[node] = true;
        path.add(node);
        int[] nextNodes = graph[node];

        boolean safe = true;
        for(int nextNode : nextNodes){
            boolean nextSafe = dfs(nextNode, path);
            safe = safe && nextSafe;
        }

        if(!safe){
            notSafeNodes.add(node);
        }

        path.remove(node);
        return safe;
    }
}