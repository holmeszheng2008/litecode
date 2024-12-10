package dfs;

import java.util.ArrayList;
import java.util.List;

// 85. Maximal Rectangle (TLE)
public class Solution85 {
    private int m;
    private int n;
    private char[][] matrix;

    private int res;

    public int maximalRectangle(char[][] matrix) {
        this.matrix = matrix;
        this.m = matrix.length;
        this.n = matrix[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dfs(i, j, i, j);
            }
        }

        return res;
    }

    private void dfs(int si, int sj, int i, int j){
        if(matrix[i][j] != '1'){
            return;
        }
        int lowI = Math.min(si, i);
        int highI = Math.max(si, i);
        int lowJ = Math.min(sj, j);
        int highJ = Math.max(sj, j);

        for(int x = lowI; x <= highI; x++){
            for(int y = lowJ; y <= highJ; y++){
                if(matrix[x][y] == '0'){
                    return;
                }
            }
        }

        res = Math.max(res, (highI + 1 - lowI) * (highJ + 1 - lowJ));
        matrix[i][j] = '2';

        for(int[] nextNode : getNextNodes(i, j)){
            if(matrix[nextNode[0]][nextNode[1]] != '1'){
                continue;
            }
            dfs(si, sj, nextNode[0], nextNode[1]);
        }

        matrix[i][j] = '1';
    }

    private List<int[]> getNextNodes(int i, int j){
        List<int[]> list = new ArrayList<>();
        if(i != 0){
            list.add(new int[]{i-1, j});
        }
        if(i != m-1){
            list.add(new int[]{i +1, j});
        }
        if(j != 0){
            list.add(new int[]{i, j-1});
        }
        if(j != n-1){
            list.add(new int[]{i, j+1});
        }

        return list;
    }
}
