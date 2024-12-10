package graph.divide;

import java.util.ArrayList;
import java.util.List;

// 2477. Minimum Fuel Cost to Report to the Capital
public class Solution2477 {
    private long res = 0;
    private boolean visited[];
    private List<Integer>[] graph;
    private int seats;
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        if(n == 1){
            return 0;
        }
        this.graph = new ArrayList[n];
        this.visited = new boolean[n];
        this.seats = seats;
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] road : roads){
            int city1 = road[0];
            int city2 = road[1];
            graph[city1].add(city2);
            graph[city2].add(city1);
        }

        visited[0] = true;
        divide(0);
        return res;
    }

    // returns the num of people including the root
    private long divide(int root){
        long num = 1;
        for(int node : graph[root]){
            if(visited[node] == false){
                visited[node] = true;
                num += divide(node);
            }
        }

        if(root != 0){
            res += (num + seats-1) / seats;
        }

        return num;
    }
}
