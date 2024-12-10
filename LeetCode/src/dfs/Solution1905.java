package dfs;

// 1905. Count Sub Islands
public class Solution1905 {
    private int[][] grid1;
    private int[][] grid2;
    private int m;
    private int n;

    private boolean isValid = true;;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        this.grid1 = grid1;
        this.grid2 = grid2;
        this.m = grid1.length;
        this.n = grid1[0].length;

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    isValid = true;
                    dfs(i, j);
                    if (isValid) {
                        res++;
                    }
                }
            }
        }

        return res;
    }

    private void dfs(int x, int y) {
        if (x < 0 || x == m || y < 0 || y ==n) {
            return;
        }
        if (grid2[x][y] == 0) {
            return;
        }
        if (grid2[x][y] != grid1[x][y]) {
            isValid = false;
        }

        grid2[x][y] = 0;

        dfs(x - 1, y);
        dfs(x + 1, y);
        dfs(x, y - 1);
        dfs(x, y + 1);
    }
}