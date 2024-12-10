package dfs;

// 52. N-Queens II
public class Solution52 {
    private boolean[][] chess;
    private int res = 0;
    private int n;
    public int totalNQueens(int n) {
        this.chess = new boolean[n][n];
        this.n = n;
        backtracking(0);

        return res;
    }
    private void backtracking(int i){
        for(int j = 0; j < n; j++){
            if(!isValid(i, j)){
                continue;
            }
            chess[i][j] = true;
            if(i == n-1){
                res++;
            } else {
                backtracking(i+1);
            }
            chess[i][j] = false;
        }
    }

    private boolean isValid(int i, int j){
        for(int row = i - 1; row >= 0; row--){
            if(chess[row][j] == true){
                return false;
            }
        }

        for(int row = i-1, col = j-1; row >= 0 && col >= 0; row--, col--){
            if(chess[row][col] == true){
                return false;
            }
        }

        for(int row = i-1, col = j+1; row >= 0 && col < n; row--, col++) {
            if(chess[row][col] == true){
                return false;
            }
        }

        return true;
    }
}
