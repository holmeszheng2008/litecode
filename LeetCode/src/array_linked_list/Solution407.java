package array_linked_list;

import java.util.PriorityQueue;

// 407. Trapping Rain Water II
public class Solution407 {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        if(m < 3 || n < 3){
            return 0;
        }

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        for(int i = 0; i < n; i++){
            visited[0][i] = true;
            pq.add(new int[]{0, i, heightMap[0][i]});

            visited[m-1][i] = true;
            pq.add(new int[]{m-1, i, heightMap[m-1][i]});
        }

        for(int i = 1; i < m-1; i++){
            visited[i][0] = true;
            pq.add(new int[]{i, 0, heightMap[i][0]});

            visited[i][n-1] = true;
            pq.add(new int[]{i, n-1, heightMap[i][n-1]});
        }

        int[][] directs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = 0;
        while(!pq.isEmpty()){
            int[] pair = pq.poll();
            int i = pair[0], j = pair[1], boundary = pair[2];
            int curHeight = heightMap[i][j];
            if(curHeight < boundary){
                res += boundary - curHeight;
            }

            for(int[] direct : directs){
                int nextI = direct[0] + i;
                int nextJ = direct[1] + j;
                if(nextI < 0 || nextI >= m || nextJ < 0 || nextJ >= n || visited[nextI][nextJ]){
                    continue;
                }
                visited[nextI][nextJ] = true;

                int nextHeight = heightMap[nextI][nextJ];
                int nextBoundary = Math.max(nextHeight, boundary);

                pq.add(new int[]{nextI, nextJ, nextBoundary});
            }
        }


        return res;
    }
}
