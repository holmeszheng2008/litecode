package array_linked_list;

// 289. Game of Life
public class Solution289 {
    private int m;
    private int n;
    private int[][] board;
    public void gameOfLife(int[][] board) {
        this.m = board.length;
        this.n = board[0].length;
        this.board = board;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int surOnes = getSurOnes(i, j);
                if(board[i][j] == 0 && surOnes == 3){
                    board[i][j] = -1;
                }
                if(board[i][j] == 1 && !(surOnes == 2 || surOnes == 3)) {
                    board[i][j] = 2;
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }
                if(board[i][j] == -1){
                    board[i][j] = 1;
                }
            }
        }
    }

    private int getSurOnes(int i, int j){
        int count = 0;
        for(int k1 = -1; k1 <= 1; k1++){
            for(int k2 = -1; k2 <= 1; k2++){
                if(k1 == 0 && k2 == 0){
                    continue;
                }
                int newI = i + k1;
                int newJ = j + k2;
                if(newI < 0 || newI >= m){
                    continue;
                }
                if(newJ < 0 || newJ >= n){
                    continue;
                }
                if(board[newI][newJ] >= 1){
                    count++;
                }
            }
        }

        return count;
    }
}
