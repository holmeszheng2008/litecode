package graph.dijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 64. Minimum Path Sum
public class Solution64 {
    private class State {
        public int x;
        public int y;
        public int dist;

        public State(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    private int m;
    private int n;
    public int minPathSum(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        int[][] distTo = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                distTo[i][j] = Integer.MAX_VALUE;
            }
        }
        distTo[0][0] = grid[0][0];
        PriorityQueue<State> pq = new PriorityQueue<>((obj1, obj2) -> {
            return obj1.dist - obj2.dist;
        });
        pq.offer(new State(0, 0, grid[0][0]));
        while (!pq.isEmpty()) {
            State currentNode = pq.poll();
            int currentX = currentNode.x;
            int currentY = currentNode.y;
            int currentDist = currentNode.dist;
            if (currentX == m-1 && currentY == n-1) {
                return currentDist;
            }
            if (currentDist > distTo[currentX][currentY]) {
                continue;
            }

            for (int[] nextNode : nextNodes(currentX, currentY)) {
                int nextX = nextNode[0];
                int nextY = nextNode[1];
                int nextDist = currentDist + grid[nextX][nextY];
                if (nextDist < distTo[nextX][nextY]) {
                    distTo[nextX][nextY] = nextDist;
                    pq.add(new State(nextX, nextY, nextDist));
                }
            }

        }

        return 0;
    }

    private List<int[]> nextNodes(int x, int y) {
        List<int[]> res = new ArrayList<>();
        if (x + 1 < m) {
            res.add(new int[] {x + 1, y});
        }
        if (y + 1 < n) {
            res.add(new int[] {x, y + 1});
        }

        return res;
    }
}
