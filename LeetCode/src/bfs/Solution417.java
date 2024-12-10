package bfs;

import util.Pair;

import java.util.*;

// 417. Pacific Atlantic Water Flow
public class Solution417 {
    private int[][] directs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private int[][] heights;
    private int m;
    private int n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;
        boolean[][] pacificVisited = new boolean[m][n];
        Queue<int[]> pacificQueue = new LinkedList<>();
        Set<Pair<Integer, Integer>> pacificSet = new HashSet<>();

        boolean[][] atlanticVisited = new boolean[m][n];
        Queue<int[]> atlanticQueue = new LinkedList<>();
        Set<Pair<Integer, Integer>> atlanticSet = new HashSet<>();

        for(int i = 0; i < m; i++){
            pacificQueue.add(new int[]{i, 0});
            pacificVisited[i][0] = true;
        }
        for(int j = 1; j < n; j++){
            pacificQueue.add(new int[]{0, j});
            pacificVisited[0][j] = true;
        }

        for(int i = 0; i < m; i++){
            atlanticQueue.add(new int[]{i, n-1});
            atlanticVisited[i][n-1] = true;
        }
        for(int j = 0; j < n-1; j++){
            atlanticQueue.add(new int[]{m-1, j});
            atlanticVisited[m-1][j] = true;
        }

        fillSets(pacificVisited, pacificSet, pacificQueue);
        fillSets(atlanticVisited, atlanticSet, atlanticQueue);

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                Pair<Integer, Integer> pair = new Pair<>(i, j);
                if(pacificSet.contains(pair) && atlanticSet.contains(pair)){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void fillSets(boolean[][] visited, Set<Pair<Integer, Integer>> resultSet, Queue<int[]> queue){
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int i = node[0], j = node[1];
            resultSet.add(new Pair<>(i ,j));

            for(int direct[] : directs){
                int nextI = i + direct[0];
                int nextJ = j + direct[1];
                if(nextI < 0 || nextI >= m || nextJ < 0 || nextJ >= n || visited[nextI][nextJ]) {
                    continue;
                }
                if(heights[nextI][nextJ] < heights[i][j]){
                    continue;
                }
                visited[nextI][nextJ] = true;
                queue.add(new int[]{nextI, nextJ});
            }
        }
    }
}


class Solution417_dfs {
    private int[][] directs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private int[][] heights;
    private int m;
    private int n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;
        boolean[][] pacificVisited = new boolean[m][n];
        Set<Pair<Integer, Integer>> pacificSet = new HashSet<>();

        boolean[][] atlanticVisited = new boolean[m][n];
        Set<Pair<Integer, Integer>> atlanticSet = new HashSet<>();

        for(int i = 0; i < m; i++){
            if(!pacificVisited[i][0]) {
                pacificVisited[i][0] = true;
            }
            dfs(pacificVisited, i, 0, pacificSet);
        }
        for(int j = 1; j < n; j++){
            if(!pacificVisited[0][j]) {
                pacificVisited[0][j] = true;
            }
            dfs(pacificVisited, 0, j, pacificSet);
        }

        for(int i = 0; i < m; i++){
            if(!pacificVisited[i][n-1]) {
                pacificVisited[i][n-1] = true;
            }
            dfs(atlanticVisited, i, n-1, atlanticSet);
        }
        for(int j = 0; j < n-1; j++){
            if(!pacificVisited[m-1][j]) {
                pacificVisited[m-1][j] = true;
            }
            dfs(atlanticVisited, m-1, j, atlanticSet);
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                Pair<Integer, Integer> pair = new Pair<>(i, j);
                if(pacificSet.contains(pair) && atlanticSet.contains(pair)){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    // in check
    private void dfs(boolean[][] visited, int i, int j, Set<Pair<Integer, Integer>> resultSet){
        resultSet.add(new Pair<>(i, j));

        for(int[] direct : directs){
            int nextI = i + direct[0];
            int nextJ = j + direct[1];
            if(nextI < 0 || nextI >= m || nextJ < 0 || nextJ >= n || visited[nextI][nextJ]){
                continue;
            }
            if(heights[nextI][nextJ] < heights[i][j]){
                continue;
            }

            visited[nextI][nextJ] = true;
            dfs(visited, nextI, nextJ, resultSet);
        }
    }
}
