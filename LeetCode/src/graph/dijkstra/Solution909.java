package graph.dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;

// 909. Snakes and Ladders
public class Solution909 {
    private int n;

    private static class State {
        public int index;
        public int distTo;

        public State(int index, int distTo) {
            this.index = index;
            this.distTo = distTo;
        }
    }

    public int snakesAndLadders(int[][] board) {
        this.n = board.length;
        int[] distFromStart = new int[n*n+1];

        Arrays.fill(distFromStart, Integer.MAX_VALUE);

        PriorityQueue<State> pq = new PriorityQueue<>((o1, o2) -> o1.distTo - o2.distTo);
        pq.add(new State(1, 0));
        distFromStart[1] = 0;
        while(!pq.isEmpty()){
            State state = pq.poll();
            int currentIndex = state.index;
            int currentDisTo = state.distTo;
            if(currentIndex == n * n){
                return currentDisTo;
            }
            if(distFromStart[currentIndex] < currentDisTo){
                continue;
            }

            int maxRange = Math.min(currentIndex + 6, n*n);
            for(int next = currentIndex + 1; next <= maxRange; next++){
                int[] position = convert(next);
                int nextDistTo = currentDisTo + 1;
                int actualNext;
                if(board[position[0]][position[1]] == -1){
                    actualNext = next;
                } else {
                    actualNext = board[position[0]][position[1]];
                }

                if(nextDistTo < distFromStart[actualNext]) {
                    distFromStart[actualNext] = nextDistTo;
                    pq.offer(new State(actualNext, nextDistTo));
                }
            }
        }

        return -1;
    }


    private int[] convert(int index){
        int row = n-1 - (index-1) / n;
        int col = 0;
        if(row % 2 + n % 2 == 1){
            col = (index-1) % n;
        } else {
            col = n - 1 - (index-1) % n;
        }

        return new int[]{row, col};
    }
}
