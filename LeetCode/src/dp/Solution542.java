package dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 542. 01 Matrix
public class Solution542 {
    private int m;
    private int n;
    public int[][] updateMatrix(int[][] mat) {
        this.m = mat.length;
        this.n = mat[0].length;
        int[][] distance = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (mat[i][j] == 0) {
                    distance[i][j] = 0;
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                } else {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int step = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] node = queue.poll();
                List<int[]> children = getChildren(node[0], node[1]);
                for(int[] child : children){
                    int nextX = child[0];
                    int nextY = child[1];
                    if(!visited[nextX][nextY]){
                        distance[nextX][nextY] = step;
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }

            step++;
        }

        return distance;
    }

    private List<int[]> getChildren(int i, int j){
        List<int[]> res = new ArrayList<>();
        if(i != 0){
            res.add(new int[]{i-1, j});
        }
        if(i != m-1){
            res.add(new int[]{i+1, j});
        }
        if(j != 0){
            res.add(new int[]{i, j-1});
        }
        if(j != n-1){
            res.add(new int[]{i, j+1});
        }

        return res;
    }
}

class Solution542_arrayFindChilren {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] distance = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (mat[i][j] == 0) {
                    distance[i][j] = 0;
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                } else {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int step = 1;
        int[][] directs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] node = queue.poll();
                for(int[] direct : directs){
                    int nextX = node[0] + direct[0];
                    int nextY = node[1] + direct[1];
                    if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY]){
                        distance[nextX][nextY] = step;
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }

            step++;
        }

        return distance;
    }
}