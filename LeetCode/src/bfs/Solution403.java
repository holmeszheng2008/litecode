package bfs;

import util.Pair;

import java.util.*;

// 403. Frog Jump
public class Solution403 {
    public boolean canCross(int[] stones) {
        if(stones[1] != 1){
            return false;
        }

        Set<Integer> stoneSet = new HashSet<>();
        for(int stone : stones){
            stoneSet.add(stone);
        }
        int goal = stones[stones.length - 1];

        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        Pair<Integer, Integer> firstPair = new Pair<>(1, 1);
        visited.add(firstPair);
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(firstPair);

        int[] choices = new int[]{-1, 0, 1};
        while(!queue.isEmpty()){
            Pair<Integer, Integer> pair = queue.poll();
            int curStep = pair.getKey();
            int curPosition = pair.getValue();
            if(curPosition == goal){
                return true;
            }

            for(int choice : choices){
                int nextStep = curStep + choice;
                if(nextStep <= 0){
                    continue;
                }
                int nextPosition = curPosition + nextStep;
                if(!stoneSet.contains(nextPosition)){
                    continue;
                }

                Pair<Integer, Integer> nextPair = new Pair<>(nextStep, nextPosition);
                if(visited.contains(nextPair)){
                    continue;
                }

                visited.add(nextPair);
                queue.add(nextPair);
            }
        }

        return false;
    }
}

class Solution403_dp {
    HashMap<Integer,Integer> mark = new HashMap<Integer,Integer>();

    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        // Mark stones in the map to identify if such stone exists or not.
        for (int i = 0 ; i < n; i++) {
            mark.put(stones[i], i);
        }

        dp[0][0] = true;
        for (int index = 0; index < n; index++) {
            for (int prevJump = 0; prevJump <= index; prevJump++) {
                // If stone exists, mark the value with position and jump as 1.
                if (dp[index][prevJump]) {
                    if (mark.containsKey(stones[index] + prevJump)) {
                        dp[mark.get(stones[index] + prevJump)][prevJump] = true;
                    }
                    if (mark.containsKey(stones[index] + prevJump + 1)) {
                        dp[mark.get(stones[index] + prevJump + 1)][prevJump + 1] = true;
                    }
                    if (mark.containsKey(stones[index] + prevJump - 1)) {
                        dp[mark.get(stones[index] + prevJump - 1)][prevJump - 1] = true;
                    }
                }


            }
        }

        // If any value with index as n - 1 is true, return true.
        for (int index = 0; index < n; index++) {
            if (dp[n - 1][index]) {
                return true;
            }
        }
        return false;
    }
}
