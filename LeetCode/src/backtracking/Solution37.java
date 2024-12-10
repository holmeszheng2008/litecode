package backtracking;

import java.util.HashSet;
import java.util.Set;

// 37. Sudoku Solver
public class Solution37 {
    private Set<String> memoSet = new HashSet<>();
    private char[][] board;
    private boolean resGot = false;

    public void solveSudoku(char[][] board) {
        this.board = board;
        for(int i =0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '0';
                    String rowString = genRowString(i, num);
                    String colString = genColString(j, num);
                    String blockString = genBlockString(i/3, j/3, num);
                    memoSet.add(rowString);
                    memoSet.add(colString);
                    memoSet.add(blockString);
                }
            }
        }

        backtracking(0, 0);
    }

    private void backtracking(int i, int j){
        if(i == 9 || j == 9){
            return;
        }
        if(board[i][j] != '.') {
            if(i == 8 && j == 8) {
                resGot = true;
                return;
            }
            // one level deeper
            int[] nextPosition = getNextPosition(i, j);
            backtracking(nextPosition[0], nextPosition[1]);

        } else {
            for(int num = 1; num <= 9; num++){
                String rowString = genRowString(i, num);
                String colString = genColString(j, num);
                String blockString = genBlockString(i/3, j/3, num);
                if(memoSet.contains(rowString) || memoSet.contains(colString) || memoSet.contains(blockString)){
                    continue;
                }

                memoSet.add(rowString);
                memoSet.add(colString);
                memoSet.add(blockString);
                board[i][j] = (char)(num + '0');

                if(i == 8 && j == 8) {
                    resGot = true;
                    return;
                } else {
                    int[] nextPosition = getNextPosition(i, j);
                    backtracking(nextPosition[0], nextPosition[1]);
                    if(resGot){
                        return;
                    }
                }

                memoSet.remove(rowString);
                memoSet.remove(colString);
                memoSet.remove(blockString);
                board[i][j] = '.';
            }
        }

    }

    private String genRowString(int i, int num) {
        return num + "- in row " + i;
    }

    private String genColString(int j, int num) {
        return num + "- in col " + j;
    }

    private String genBlockString(int i, int j, int num) {
        return num + "- in block " + i + "-" + j;
    }

    private int[] getNextPosition(int i, int j){
        j++;
        if(j == 9){
            i++;
            j = 0;
        }
        return new int[]{i, j};
    }
}

class Solution37_attempt1 {
    private Set<String> memoSet;
    private char[][] board;
    private boolean resGot = false;
    public void solveSudoku(char[][] board) {
        this.memoSet = new HashSet<>();
        this.board = board;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                char c = board[i][j];
                memoSet.add(rowString(c, i));
                memoSet.add(colString(c, j));
                memoSet.add(blockString(c, i, j));
            }
        }

        backtracking(0, 0);
    }

    private void backtracking(int i, int j){
        int[] nextNode = nextNode(i, j);
        if(board[i][j] != '.'){
            if(i == 8 && j == 8){
                resGot = true;
                return;
            } else {
                backtracking(nextNode[0], nextNode[1]);
                if(resGot){
                    return;
                }
            }
        } else {
            for(char c = '1'; c <= '9'; c++){
                String rowString = rowString(c, i);
                String colString = colString(c, j);
                String blockString = blockString(c, i, j);

                if(memoSet.contains(rowString) || memoSet.contains(colString) || memoSet.contains(blockString)){
                    continue;
                }
                memoSet.add(rowString);
                memoSet.add(colString);
                memoSet.add(blockString);
                board[i][j] = c;

                if(i == 8 && j == 8) {
                    resGot = true;
                    return;
                } else {
                    backtracking(nextNode[0], nextNode[1]);
                    if(resGot){
                        return;
                    }
                }

                memoSet.remove(rowString);
                memoSet.remove(colString);
                memoSet.remove(blockString);
                board[i][j] = '.';
            }
        }
    }

    private String rowString(char num, int i){
        return "num " + num + " row-" + i;
    }

    private String colString(char num, int j){
        return "num " + num + " col-" + j;
    }

    private String blockString(char num, int i, int j){
        return "num " + num + " block row-" + i/3 + " col-" + j/3;
    }

    private int[] nextNode(int i, int j){
        j++;
        if(j == 9){
            i++;
            j = 0;
        }

        return new int[]{i, j};
    }
}


class Solution37_attempt2 {
    private char[][] board;
    private Set<String> memo;
    private boolean resGot;

    public void solveSudoku(char[][] board) {
        this.board = board;
        this.memo = new HashSet<>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char c = board[i][j];
                memo.add(genRowString(i, c-'0'));
                memo.add(genColString(j, c-'0'));
                memo.add(genBlockString(i, j, c-'0'));
            }
        }

        backtracking(0, 0);
    }

    private void backtracking(int i, int j){
        if(board[i][j] != '.'){
            if(i == 8 && j == 8){
                resGot = true;
                return;
            } else {
                int[] nextNode = getNextNode(i, j);
                backtracking(nextNode[0], nextNode[1]);
            }
        } else {
            int[] nextNode = getNextNode(i, j);
            for(int num = 1; num <= 9; num++){
                String rowString = genRowString(i, num);
                String colString = genColString(j, num);
                String blockString = genBlockString(i, j, num);
                if(memo.contains(rowString) || memo.contains(colString) || memo.contains(blockString)){
                    continue;
                }

                board[i][j] = (char)(num + '0');
                memo.add(rowString);
                memo.add(colString);
                memo.add(blockString);

                if(i == 8 && j == 8){
                    resGot = true;
                    return;
                } else {
                    backtracking(nextNode[0], nextNode[1]);
                    if(resGot){
                        return;
                    }
                }

                board[i][j] = '.';
                memo.remove(rowString);
                memo.remove(colString);
                memo.remove(blockString);
            }
        }
    }

    private int[] getNextNode(int i, int j){
        j++;
        if(j == 9){
            j = 0;
            i++;
        }

        return new int[]{i, j};
    }

    private String genRowString(int row, int num){
        return String.format("row %d, num %d", row, num);
    }

    private String genColString(int col, int num){
        return String.format("col %d, num %d", col, num);
    }

    private String genBlockString(int row, int col, int num){
        return String.format("block i %d j %d, num %d", row / 3, col / 3, num);
    }
}