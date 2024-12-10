package graph;

import java.util.HashSet;
import java.util.Set;

// 1615. Maximal Network Rank
public class Solution1615 {
    public int maximalNetworkRank(int n, int[][] roads) {
        Set<Integer>[] graph = new Set[n];
        for(int i = 0; i < n; i++){
            graph[i] = new HashSet<>();
        }
        for(int[] road : roads){
            int from = road[0];
            int to = road[1];
            graph[from].add(to);
            graph[to].add(from);
        }

        int maxRank = 0;
        for(int i = 0; i < n; i++){
            Set<Integer> list1 = graph[i];
            for(int j = 0; j < n; j++){
                if(i == j){
                    continue;
                }
                Set<Integer> list2 = graph[j];
                if(list2.contains(i)){
                    maxRank = Math.max(maxRank, list1.size() + list2.size() - 1);
                } else {
                    maxRank = Math.max(maxRank, list1.size() + list2.size());
                }

            }
        }

        return maxRank;
    }
}
