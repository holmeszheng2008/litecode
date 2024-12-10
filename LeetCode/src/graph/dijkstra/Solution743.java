package graph.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// 743. Network Delay Time
public class Solution743 {
    private class State {
        public int id;
        public int distFromStart;

        public State(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }

    // 0 is to vertex, 1 is weight
    private List<int[]>[] graph;
    public int networkDelayTime(int[][] times, int n, int k) {
        buildGraph(times, n);
        int[] distTo = new int[n + 1];
        Arrays.fill(distTo, -1);

        Queue<State> pq = new PriorityQueue<>((o1, o2) -> (o1.distFromStart - o2.distFromStart));
        pq.add(new State(k, 0));
        distTo[k] = 0;
        while (!pq.isEmpty()) {
            State state = pq.poll();
            int curVertexId = state.id;
            int curDistFromStart = state.distFromStart;
            if (distTo[curVertexId] != -1 && distTo[curVertexId] < curDistFromStart) {
                continue;
            }

            for (int[] nextNode : graph[curVertexId]) {
                int to = nextNode[0];
                int weight = nextNode[1];

                int nextDistFromStart = curDistFromStart + weight;
                if (distTo[to] == -1 || nextDistFromStart < distTo[to]) {
                    distTo[to] = nextDistFromStart;
                    pq.add(new State(to, nextDistFromStart));
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            if (distTo[i] == -1) {
                return -1;
            }
            res = Math.max(res, distTo[i]);
        }

        return res;
    }

    private void buildGraph(int[][] times, int n) {
        graph = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<int[]>();
        }
        for(int[] time : times) {
            graph[time[0]].add(new int[] {time[1], time[2]});
        }
    }
}