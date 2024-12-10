package bfs;

import util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 1162. As Far from Land as Possible
public class Solution1162 {
    public int maxDistance(int[][] grid) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int step = 0, m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    queue.offer(new Pair<>(i, j));
                }
            }
        }
        if(queue.isEmpty()){
            return -1;
        }
        if(queue.size() == m * n){
            return -1;
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Pair<Integer, Integer> node = queue.poll();
                List<int[]> nextNodes = getNextNodes(node.getKey(), node.getValue(), m, n);

                for(int[] nextNode : nextNodes){
                    int nextI = nextNode[0];
                    int nextJ = nextNode[1];
                    if(grid[nextI][nextJ] != 1){
                        grid[nextI][nextJ] = 1;
                        queue.add(new Pair<>(nextI, nextJ));
                    }
                }
            }

            step++;
        }

        return step - 1;
    }

    private List<int[]> getNextNodes(int i, int j, int m, int n){
        List<int[]> list = new ArrayList<>();
        if(i != 0){
            list.add(new int[]{i-1, j});
        }
        if(i != m-1){
            list.add(new int[]{i+1, j});
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
