package graph.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// 1514. Path with Maximum Probability
public class Solution1514 {
    private class State {
        public int id;
        public double distFromStart;

        public State(int id, double distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }

    private class Pair {
        public int to;
        public double weight;

        public Pair(int to, double weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private List<Pair>[] graph;
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        buildGraph(n, edges, succProb);

        double[] distTo = new double[n];
        Arrays.fill(distTo, Double.MIN_VALUE);

        Queue<State> pq = new PriorityQueue<>((o1, o2) -> {
            double diff = o2.distFromStart - o1.distFromStart;
            if (diff < 0) {
                return -1;
            } else if (diff > 0) {
                return 1;
            } else {
                return 0;
            }
        });
        pq.add(new State(start, 1));
        distTo[start] = 1;

        while (!pq.isEmpty()) {
            State state = pq.poll();
            int curId = state.id;
            double curDistFromStart = state.distFromStart;

            if (curId == end) {
                return curDistFromStart;
            }
            if (distTo[curId] > curDistFromStart) {
                continue;
            }

            for (Pair nextNode : graph[curId]) {
                int to = nextNode.to;
                double weight = nextNode.weight;
                double nextDistFromStart = curDistFromStart * weight;

                if (nextDistFromStart > distTo[to]) {
                    distTo[to] = nextDistFromStart;
                    pq.add(new State(to, nextDistFromStart));
                }
            }
        }

        return 0;
    }

    private void buildGraph(int n, int[][] edges, double[] succProb) {
        this.graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Pair>();
        }
        for(int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int from = edge[0];
            int to = edge[1];
            double weight = succProb[i];

            graph[from].add(new Pair(to, weight));
            graph[to].add(new Pair(from, weight));
        }
    }
}
