package dfs;

import java.util.ArrayList;
import java.util.List;

// 79. Word Search
public class Solution79 {
    private int m;
    private int n;
    private char[][] board;
    private String word;
    private boolean[][] used;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        if(m * n < word.length()){
            return false;
        }
        this.word = word;
        this.board = board;
        this.used = new boolean[m][n];


        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                boolean res = false;
                res = divide(i, j, 0);
                if(res){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean divide(int x, int y, int i){
        if(board[x][y] != word.charAt(i)){
            return false;
        }
        if(i == word.length() - 1){
            return true;
        }
        used[x][y] = true;
        List<int[]> nextNodes = getNextNodes(x, y);

        boolean res = false;
        for(int[] nextNode : nextNodes){
            if(used[nextNode[0]][nextNode[1]]){
                continue;
            }
            res = divide(nextNode[0], nextNode[1], i+1);
            if(res){
                break;
            }
        }

        used[x][y] = false;
        return res;
    }

    private List<int[]> getNextNodes(int x, int y) {
        List<int[]> nextNodes = new ArrayList<>();
        if(x != 0){
            nextNodes.add(new int[]{x-1, y});
        }
        if(x != m-1){
            nextNodes.add(new int[]{x+1, y});
        }
        if(y != 0){
            nextNodes.add(new int[]{x, y-1});
        }
        if(y != n-1){
            nextNodes.add(new int[]{x, y+1});
        }

        return nextNodes;
    }
}
