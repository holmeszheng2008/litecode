package dfs;

import java.util.ArrayList;
import java.util.List;

// 1254. Number of Closed Islands
public class Solution1254 {
    private int[][] grid;
    private int m;
    private int n;
    public int closedIsland(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;

        int res = 0;
        for (int i = 0; i < m; i++) {
            dfs(i, 0);
            dfs(i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j);
            dfs(m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    dfs(i, j);
                }
            }
        }

        return res;
    }

    private void dfs(int x, int y) {
        if (x < 0 || x == m || y < 0 || y == n) {
            return;
        }
        if (grid[x][y] == 1) {
            return;
        }
        grid[x][y] = 1;

        dfs(x - 1, y);
        dfs(x + 1, y);
        dfs(x, y - 1);
        dfs(x, y + 1);
    }
}


class Solution1254_attempt1 {
    private int m;
    private int n;
    private boolean visited[][];
    private int[][] grid;
    public int closedIsland(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.visited = new boolean[m][n];

        int res = 0;
        for(int i = 0; i < m; i++){
            dfs(i, 0);
            dfs(i, n-1);
        }
        for(int j = 0; j < n; j++){
            dfs(0, j);
            dfs(m-1, j);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0 && !visited[i][j]){
                    res++;
                    dfs(i, j);
                }
            }
        }

        return res;
    }

    private void dfs(int i, int j){
        if(grid[i][j] == 1){
            return;
        }
        if(visited[i][j]) {
            return;
        }
        visited[i][j] = true;

        List<int[]> nextNodes = getNextNodes(i, j);
        for(int[] nextNode : nextNodes){
            dfs(nextNode[0], nextNode[1]);
        }
    }

    private List<int[]> getNextNodes(int i, int j){
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