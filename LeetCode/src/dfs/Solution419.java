package dfs;

// 419. Battleships in a Board
public class Solution419 {
    private char[][] board;
    private int m;
    private int n;
    private int[][] directs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int countBattleships(char[][] board) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;

        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'X'){
                    board[i][j] = '.';
                    res++;
                    dfs(i, j);
                }
            }
        }

        return res;
    }

    private void dfs(int i, int j){
        for(int[] direct : directs){
            int nextI = i + direct[0];
            int nextJ = j + direct[1];
            if(nextI < 0 || nextI >= m || nextJ < 0 || nextJ >= n || board[nextI][nextJ] == '.'){
                continue;
            }
            board[nextI][nextJ] = '.';
            dfs(nextI, nextJ);
        }
    }
}

class Solution419_followup {
    public int countBattleships(char[][] board) {
        int res = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'X'){
                    if((i == 0 || board[i-1][j] == '.') && (j == 0 || board[i][j-1] == '.')){
                        res++;
                    }
                }
            }
        }

        return res;
    }
}
