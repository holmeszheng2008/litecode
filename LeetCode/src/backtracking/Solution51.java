package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 51. N-Queens
public class Solution51 {
    private int n;
    private List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        boolean[][] used = new boolean[n][n];
        backtracking(0, new LinkedList<>(), used);

        return res;
    }

    private void backtracking(int row, LinkedList<String> placed, boolean[][] used) {
        if (row == n) {
            return;
        }
        for(int i = 0; i < n; i++) {
            if (used(row, i, placed, used)) {
                continue;
            }
            used[row][i] = true;
            String rowStr = generateRow(i);
            placed.add(rowStr);
            if (row == n - 1) {
                res.add(new ArrayList<>(placed));
            }
            backtracking(row + 1, placed, used);
            used[row][i] = false;
            placed.removeLast();
        }
    }

    private String generateRow(int i) {
        StringBuilder sb = new StringBuilder();
        for (int a = 0; a < i; a++) {
            sb.append(".");
        }
        sb.append("Q");
        for (int a = 0; a < n - 1 - i; a++) {
            sb.append(".");
        }
        return sb.toString();
    }

    private boolean used(int row, int i, LinkedList<String> placed, boolean[][] used) {
        for (int x = row - 1, y = i - 1; x >= 0 && y >= 0; x--, y--) {
            if (used[x][y]) {
                return true;
            }
        }
        for (int x = row - 1, y = i + 1; x >= 0 && y < n; x--, y++) {
            if (used[x][y]) {
                return true;
            }
        }
        for (int x = row - 1, y = i; x >= 0; x--) {
            if (used[x][y]) {
                return true;
            }
        }

        return false;
    }
}


class Solution51_attempt1 {
    private char[][] path;
    private List<List<String>> res = new ArrayList<>();
    private int n;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.path = new char[n][n];
        for(int i = 0; i < n; i++){
            path[i] = generateEmptyString();
        }

        backtracking(0);
        return res;
    }

    private void backtracking(int row){
        for(int j = 0; j < n; j++){
            if(!isValid(row, j)){
                continue;
            }

            path[row][j] = 'Q';
            if(row == n-1) {
                List<String> list = new ArrayList<>();
                for(int i = 0; i < n; i++){
                    list.add(String.valueOf(path[i]));
                }
                res.add(list);
            } else {
                backtracking(row + 1);
            }

            path[row][j] = '.';
        }
    }

    private boolean isValid(int row, int col){
        for(int i = row - 1; i >=0; i--){
            if(path[i][col] == 'Q'){
                return false;
            }
        }
        for(int i = row - 1, j = col - 1; i >=0 && j >= 0; i--, j--){
            if(path[i][j] == 'Q'){
                return false;
            }
        }

        for(int i = row - 1, j = col + 1; i >=0 && j < n; i--, j++){
            if(path[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    private char[] generateEmptyString(){
        char[] cArray = new char[n];
        for(int i = 0; i < n; i++){
            cArray[i] = '.';
        }

        return cArray;
    }


}