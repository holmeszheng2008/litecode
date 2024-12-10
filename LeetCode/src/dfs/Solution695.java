package dfs;

public class Solution695 {
    private int[][] grid;
    private boolean[][] visited;
    private int m;
    private int n;
    private int size;
    private int maxSize;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                size = 0;
                dfs(i, j);
            }
        }

        return maxSize;
    }

    private void dfs(int i, int j) {
        if (i < 0 || i == m || j < 0 || j == n) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        size++;
        maxSize = Math.max(maxSize, size);

        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }
}
