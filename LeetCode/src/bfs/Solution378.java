package bfs;

import java.util.PriorityQueue;

// 378. Kth Smallest Element in a Sorted Matrix
public class Solution378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        boolean[][] visited = new boolean[n][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        pq.add(new int[]{matrix[0][0], 0, 0});
        visited[0][0] = true;
        while(!pq.isEmpty()){
            int[] tuple = pq.poll();
            int value = tuple[0], x = tuple[1], y = tuple[2];
            k--;
            if(k == 0){
                return value;
            }
            if(x != n-1 && !visited[x+1][y]){
                visited[x+1][y] = true;
                pq.add(new int[]{matrix[x+1][y], x + 1, y});
            }

            if(y != n-1 && !visited[x][y+1]){
                visited[x][y+1] = true;
                pq.add(new int[]{matrix[x][y+1], x, y+1});
            }
        }

        return -1;
    }
}
