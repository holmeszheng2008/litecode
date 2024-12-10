package dfs;

// 1020. Number of Enclaves
public class Solution1020 {
    private int[][] grid;
    private int m;
    private int n;

    public int numEnclaves(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        for (int i = 0; i < m; i++) {
            dfs(i, 0);
            dfs(i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j);
            dfs(m - 1, j);
        }

        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += grid[i][j];
            }
        }

        return sum;
    }

    private void dfs(int x, int y) {
        if (x < 0 || x == m || y < 0 || y == n) {
            return;
        }
        if (grid[x][y] == 0) {
            return;
        }
        grid[x][y] = 0;
        dfs(x - 1, y);
        dfs(x + 1, y);
        dfs(x, y - 1);
        dfs(x, y + 1);
    }
}
