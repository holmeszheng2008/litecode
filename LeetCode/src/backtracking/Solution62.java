package backtracking;

// 62. Unique Paths
public class Solution62 {
    private int m;
    private int n;
    private int res;
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;

        backtracking(0, 0);

        return res;
    }

    private void backtracking(int x, int y){
        int[][] nextSteps = nextSteps(x, y);
        for(int[] nextStep : nextSteps){
            int currentX = nextStep[0];
            int currentY = nextStep[1];
            if(currentX == m-1 && currentY == n-1){
                res++;
            } else {
                backtracking(currentX, currentY);
            }
        }
    }

    private int[][] nextSteps(int x, int y){
        if(x == m-1 && y == n-1){
            return new int[0][2];
        } else if (x == m-1){
            return new int[][]{
                    {x, y + 1}
            };
        } else if (y == n-1){
            return new int[][] {
                    {x + 1, y}
            };
        } else {
            return new int[][] {
                    {x, y+1},
                    {x+1, y}
            };
        }
    }
}

class Solution62_attempt1 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            dp[0][j] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}