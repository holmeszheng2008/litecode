package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 1466. Reorder Routes to Make All Paths Lead to the City Zero
public class Solution1466 {
    private Map<Integer, List<Integer>> inMap;
    private Map<Integer, List<Integer>> outMap;
    private boolean[] visited;

    public int minReorder(int n, int[][] connections) {
        visited = new boolean[n];
        inMap = new HashMap<>();
        outMap = new HashMap<>();

        for (int[] connection : connections) {
            List<Integer> outList = outMap.get(connection[0]);
            if (outList == null) {
                outList = new ArrayList<>();
                outMap.put(connection[0], outList);
            }
            outList.add(connection[1]);

            List<Integer> inList = inMap.get(connection[1]);
            if (inList == null) {
                inList = new ArrayList<>();
                inMap.put(connection[1], inList);
            }
            inList.add(connection[0]);
        }

        visited[0] = true;
        return getNum(0);
    }

    private int getNum(int i){
        int tempRes = 0;
        List<Integer> inList = inMap.get(i);
        if(inList != null){
            for(int nextNode : inList){
                if(visited[nextNode]){
                    continue;
                }
                visited[nextNode] = true;
                tempRes += getNum(nextNode);
            }
        }

        List<Integer> outList = outMap.get(i);
        if(outList != null){
            for(int nextNode : outList){
                if(visited[nextNode]){
                    continue;
                }
                visited[nextNode] = true;
                tempRes = 1 + tempRes + getNum(nextNode);
            }
        }


        return tempRes;
    }
}

class Solution1466_attempt1 {
    private int res;
    private Map<Integer, List<Integer>> inMap;
    private Map<Integer, List<Integer>> outMap;
    private boolean[] visited;

    public int minReorder(int n, int[][] connections) {
        visited = new boolean[n];
        inMap = new HashMap<>();
        outMap = new HashMap<>();

        for (int[] connection : connections) {
            List<Integer> outList = outMap.get(connection[0]);
            if (outList == null) {
                outList = new ArrayList<>();
                outMap.put(connection[0], outList);
            }
            outList.add(connection[1]);

            List<Integer> inList = inMap.get(connection[1]);
            if (inList == null) {
                inList = new ArrayList<>();
                inMap.put(connection[1], inList);
            }
            inList.add(connection[0]);
        }

        visited[0] = true;
        dfs(0);
        return res;
    }

    private void dfs(int i){
        List<Integer> inList = inMap.get(i);
        if(inList != null){
            for(int nextNode : inList){
                if(!visited[nextNode]){
                    visited[nextNode] = true;
                    dfs(nextNode);
                }
            }
        }

        List<Integer> outList = outMap.get(i);
        if(outList != null){
            for(int nextNode : outList){
                if(!visited[nextNode]){
                    visited[nextNode] = true;
                    res++;
                    dfs(nextNode);
                }
            }
        }
    }
}
