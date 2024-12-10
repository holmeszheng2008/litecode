package dfs;

import java.util.ArrayList;
import java.util.List;

// 130. Surrounded Regions
public class Solution130 {
    private boolean visited[][];
    private char[][] graph;
    private int m;
    private int n;
    public void solve(char[][] board) {
        graph = board;
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            traverse(i, 0);
            traverse(i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            traverse(0, i);
            traverse(m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void traverse(int x, int y) {
        if (x < 0 || x == m || y < 0 || y == n) {
            return;
        }
        if (graph[x][y] == 'X') {
            return;
        }
        if (visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        traverse(x - 1, y);
        traverse(x + 1, y);
        traverse(x, y - 1);
        traverse(x, y + 1);
    }
}


class Solution130_attempt1 {
    private char[][] board;
    private int m;
    private int n;
    public void solve(char[][] board) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;

        for(int i = 0; i < m; i++){
            dfs(i, 0);
            dfs(i, n-1);
        }

        for(int j = 0; j < n; j++) {
            dfs(0, j);
            dfs(m-1, j);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'Y') {
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int i, int j){
        if(board[i][j] != 'O'){
            return;
        }

        board[i][j] = 'Y';
        List<int[]> nextNodes = nextNodes(i, j);
        for(int[] nextNode : nextNodes){
            dfs(nextNode[0], nextNode[1]);
        }
    }

    private List<int[]> nextNodes(int i, int j){
        List<int[]> res = new ArrayList<>();
        if(i != 0){
            res.add(new int[]{i-1, j});
        }
        if(i != m-1){
            res.add(new int[]{i+1, j});
        }
        if(j != 0) {
            res.add(new int[]{i, j - 1});
        }

        if(j != n-1){
            res.add(new int[]{i, j+1});
        }

        return res;
    }
}

class Solution130_attempt2 {
    private char[][] board;
    private boolean[][] visited;
    private int m;
    private int n;
    public void solve(char[][] board) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        this.visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            dfs(i, 0);
            dfs(i, n-1);
        }

        for(int j = 0; j < n; j++) {
            dfs(0, j);
            dfs(m-1, j);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
               if(!visited[i][j]){
                   board[i][j] = 'X';
               }
            }
        }
    }

    private void dfs(int i, int j){
        if(board[i][j] == 'X'){
            return;
        }
        if(visited[i][j]){
            return;
        }

        visited[i][j] = true;

        List<int[]> nextNodes = nextNodes(i, j);
        for(int[] nextNode : nextNodes){
            dfs(nextNode[0], nextNode[1]);
        }
    }

    private List<int[]> nextNodes(int i, int j){
        List<int[]> res = new ArrayList<>();
        if(i != 0){
            res.add(new int[]{i-1, j});
        }
        if(i != m-1){
            res.add(new int[]{i+1, j});
        }
        if(j != 0) {
            res.add(new int[]{i, j - 1});
        }

        if(j != n-1){
            res.add(new int[]{i, j+1});
        }

        return res;
    }
}