package dfs;

import java.util.ArrayList;
import java.util.List;

// 1219. Path with Maximum Gold
public class Solution1219 {
    private boolean[][] onPath;
    private int[][] grid;
    private int m;
    private int n;
    private int maxPathSum;
    private int pathSum;

    public int getMaximumGold(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        this.onPath = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    onPath[i][j] = true;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!onPath[i][j]){
                    dfs(i, j);
                }
            }
        }

        return maxPathSum;
    }

    private void dfs(int i, int j){
        if(onPath[i][j]){
            return;
        }

        onPath[i][j] = true;
        pathSum += grid[i][j];
        maxPathSum = Math.max(maxPathSum, pathSum);


        List<int[]> nextNodes = getNextNodes(i, j);
        for(int[] nextNode : nextNodes){
            dfs(nextNode[0], nextNode[1]);
        }

        onPath[i][j] = false;
        pathSum -= grid[i][j];
    }

    private List<int[]> getNextNodes(int i, int j){
        List<int[]> nextNodes = new ArrayList<>();
        if(i != 0){
            nextNodes.add(new int[]{i-1, j});
        }
        if(i != m-1){
            nextNodes.add(new int[]{i+1, j});
        }
        if(j != 0){
            nextNodes.add(new int[]{i, j-1});
        }
        if(j != n-1){
            nextNodes.add(new int[]{i, j+1});
        }

        return nextNodes;
    }
}
