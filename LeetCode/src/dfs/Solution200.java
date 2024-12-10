package dfs;

import java.util.ArrayList;
import java.util.List;

// 200. Number of Island
public class Solution200 {
    private boolean[][] visited;
    private char[][] grid;
    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.visited = new boolean[m][n];

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    res++;
                    dfs(i, j);
                }
            }
        }

        return res;
    }

    private void dfs(int i, int j) {
        if (i < 0 || i == m || j < 0 || j == n) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;

        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }
}

class Solution200_attempt1 {
    private boolean[][] visited;
    private char[][] grid;
    private int m;
    private int n;
    private int res = 0;
    public int numIslands(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        this.visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && !visited[i][j]) {
                    res++;
                    dfs(i,j);
                }
            }
        }

        return res;
    }

    private void dfs(int i, int j){
        if(grid[i][j] == '0'){
            return;
        }
        if(visited[i][j]){
            return;
        }
        visited[i][j] = true;

        List<int[]> nextNodes = getNextNodes(i, j);
        for(int[] nextNode : nextNodes){
            dfs(nextNode[0], nextNode[1]);
        }
    }

    private List<int[]> getNextNodes(int i, int j){
        List<int[]> nextNodes = new ArrayList<>();
        if(i != 0){
            nextNodes.add(new int[]{i-1, j});
        }
        if(i != m-1){
            nextNodes.add(new int[]{i+1, j});
        }
        if (j != 0) {
            nextNodes.add(new int[]{i, j-1});
        }
        if (j != n-1){
            nextNodes.add(new int[]{i, j+1});
        }

        return nextNodes;
    }
}