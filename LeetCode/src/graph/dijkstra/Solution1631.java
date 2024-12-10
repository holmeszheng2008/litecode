package graph.dijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// 1631. Path With Minimum Effort
public class Solution1631 {
    private int[][] graph;
    private int m;
    private int n;

    private class State {
        public int x;
        public int y;
        public int distFromStart;

        public State(int x, int y, int distFromStart) {
            this.x = x;
            this.y = y;
            this.distFromStart = distFromStart;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        this.graph = heights;
        this.m = graph.length;
        this.n = graph[0].length;

        int[][] distTo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                distTo[i][j] = Integer.MAX_VALUE;
            }
        }

        distTo[0][0] = 0;
        Queue<State> pq = new PriorityQueue<>((o1, o2) -> (o1.distFromStart - o2.distFromStart));
        pq.add(new State(0, 0, 0));
        while (!pq.isEmpty()) {
            State state = pq.poll();
            int currentX = state.x;
            int currentY = state.y;
            int currentDistFromStart = state.distFromStart;

            if (currentX == m - 1 && currentY == n - 1) {
                return currentDistFromStart;
            }
            if (distTo[currentX][currentY] < currentDistFromStart) {
                continue;
            }

            for (int[] nextNode : getAdjacentNodes(currentX, currentY)) {
                int nextX = nextNode[0];
                int nextY = nextNode[1];
                int weight = Math.abs(graph[nextX][nextY] - graph[currentX][currentY]);
                int nextDistFromStart = Math.max(currentDistFromStart, weight);

                if (distTo[nextX][nextY] > nextDistFromStart) {
                    distTo[nextX][nextY] = nextDistFromStart;
                    pq.add(new State(nextX, nextY, nextDistFromStart));
                }
            }

        }

        return -1;
    }

    private List<int[]> getAdjacentNodes(int x, int y) {
        List<int[]> res = new ArrayList<>();
        if (x - 1 >= 0) {
            res.add(new int[] {x - 1, y});
        }
        if (x + 1 < m) {
            res.add(new int[] {x + 1, y});
        }
        if (y - 1 >= 0) {
            res.add(new int[] {x, y - 1});
        }
        if (y + 1 < n) {
            res.add(new int[] {x, y + 1});
        }

        return res;
    }
}