package graph.traverse;

import java.util.*;

public class Solution332 {
    private boolean resGot;
    private LinkedList<String> path = new LinkedList<>();
    private Map<String, List<String>> graph;
    private Map<String, boolean[]> used;
    private int edgeSize;
    public List<String> findItinerary(List<List<String>> tickets) {
        this.graph = new HashMap<>();
        this.edgeSize = tickets.size();
        this.used = new HashMap<>();
        for(List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            List<String> list = graph.get(from);
            if(list == null){
                list = new ArrayList<>();
                graph.put(from, list);
            }
            list.add(to);
        }

        for(String key : graph.keySet()){
            List<String> list = graph.get(key);
            Collections.sort(list);
            used.put(key, new boolean[list.size()]);
        }

        path.add("JFK");
        dfs("JFK");
        return path;
    }

    private void dfs(String node){
        List<String> children = graph.get(node);
        if(children == null){
            return;
        }
        String preChoice = null;

        for(int i = 0; i < children.size(); i++){
            boolean[] usedArray = used.get(node);
            if(usedArray[i]){
                continue;
            }
            String nextChoice = children.get(i);
            if(nextChoice == preChoice){
                continue;
            }
            preChoice = nextChoice;
            path.add(nextChoice);
            usedArray[i] = true;

            if(path.size() == edgeSize+1){
                resGot = true;
                return;
            } else {
                dfs(nextChoice);
                if(resGot){
                    return;
                }
            }

            path.removeLast();
            usedArray[i] = false;
        }
    }
}
