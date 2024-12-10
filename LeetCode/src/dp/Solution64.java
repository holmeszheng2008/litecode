package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// 64. Minimum Path Sum
public class Solution64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }
}

class Solution64_attempt1 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < m; i++){
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }

        for(int j = 1; j < n; j++){
            dp[0][j] = grid[0][j] + dp[0][j-1];
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[m-1][n-1];
    }
}

// Dijkstra's Algorithm
class Solution64_attempt2 {
    private class State{
        public int x;
        public int y;
        public int distance;
        public State(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    private int m;
    private int n;
    private int[][] distTo;
    public int minPathSum(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.distTo = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(distTo[i], Integer.MAX_VALUE);
        }

        distTo[0][0] = grid[0][0];

        PriorityQueue<State> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.distance - o2.distance;
        });

        pq.add(new State(0, 0, grid[0][0]));
        while(!pq.isEmpty()){
            State currentNode = pq.poll();
            int x = currentNode.x;
            int y = currentNode.y;
            int dist = currentNode.distance;
            if(dist > distTo[x][y]){
                continue;
            }
            if(x == m-1 && y == n-1) {
                return dist;
            }

            List<int[]> nextNodes = getNextNodes(x, y);
            for(int[] nextNode : nextNodes){
                int newX = nextNode[0];
                int newY = nextNode[1];
                int newDist = dist + grid[newX][newY];

                if(newDist < distTo[newX][newY]){
                    distTo[newX][newY] = newDist;
                    pq.offer(new State(newX, newY, newDist));
                }
            }
        }

        return -1;
    }


    private List<int[]> getNextNodes(int x, int y){
        List<int[]> res = new ArrayList<>();
        if(x != m-1){
            res.add(new int[]{x+1, y});
        }
        if(y != n-1){
            res.add(new int[]{x, y+1});
        }

        return res;
    }


}

class Solution64_attempt3 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < m; i++){
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }
        for(int j = 1; j < n; j++){
            dp[0][j] = grid[0][j] + dp[0][j-1];
        }

        for(int i = 1; i < m; i++){
            for(int j =1; j < n; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[m-1][n-1];
    }
}