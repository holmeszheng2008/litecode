package graph.dijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 1129. Shortest Path with Alternating Colors
public class Solution1129 {
    private static class State {
        public int distTo;
        public int node;
        // 0 -> red, 1 -> blue
        public int lastColor;

        public State(int node, int distTo, int lastColor) {
            this.node = node;
            this.distTo = distTo;
            this.lastColor = lastColor;
        }
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] redEdge : redEdges){
            int from = redEdge[0];
            int to = redEdge[1];
            int color = 0;
            graph[from].add(new int[]{to, color});
        }

        for(int[] blueEdge : blueEdges){
            int from = blueEdge[0];
            int to = blueEdge[1];
            int color = 1;
            graph[from].add(new int[]{to, color});
        }


        // 0 -> red to i, 1 -> blue to i
        int[][] distTos = new int[n][2];
        PriorityQueue<State> pq = new PriorityQueue<>((o1, o2) -> o1.distTo - o2.distTo);
        for(int i = 0; i < n; i++){
            distTos[i][0] = Integer.MAX_VALUE;
            distTos[i][1] = Integer.MAX_VALUE;
        }

        pq.add(new State(0, 0, 0));
        pq.add(new State(0, 0, 1));
        distTos[0][0] = 0;
        distTos[0][1] = 0;

        while(!pq.isEmpty()){
            State state = pq.poll();
            int currentNodeNum = state.node;
            int currentDistTo = state.distTo;
            int lastColor = state.lastColor;

            if(currentDistTo > distTos[currentNodeNum][lastColor]){
                continue;
            }

            List<int[]> nextNodes = graph[currentNodeNum];
            for(int[] nextNode : nextNodes){
                int nextNodeNum = nextNode[0];
                int nextNodeColor = nextNode[1];
                if(lastColor == nextNodeColor){
                    continue;
                }
                int nextDistTo = currentDistTo + 1;
                if(nextDistTo < distTos[nextNodeNum][nextNodeColor]){
                    distTos[nextNodeNum][nextNodeColor] = nextDistTo;
                    pq.add(new State(nextNodeNum, nextDistTo, nextNodeColor));
                }
            }
        }

        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            int num = Math.min(distTos[i][0], distTos[i][1]);
            res[i] = (num == Integer.MAX_VALUE) ? -1 : num;
        }

        return res;
    }

}
