package dp;

import util.Pair;

import java.util.*;

// 365. Water and Jug Problem
public class Solution365 {

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if(targetCapacity > jug1Capacity + jug2Capacity){
            return false;
        }
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        Pair<Integer, Integer> rootNode = new Pair<>(0, 0);
        queue.add(rootNode);
        visited.add(rootNode);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Pair<Integer, Integer> node = queue.poll();
                int curJug1 = node.getKey();
                int curJug2 = node.getValue();

                List<Pair<Integer, Integer>> nextPairs = new ArrayList<>();
                // fill jug1
                nextPairs.add(new Pair<>(jug1Capacity, curJug2));
                // fill jug2
                nextPairs.add(new Pair<>(curJug1, jug2Capacity));
                // empty jug1
                nextPairs.add(new Pair<>(0, curJug2));
                // empty jug2
                nextPairs.add(new Pair<>(curJug1, 0));
                // pour jug1 to jug2
                int jug2LeftRoom = jug2Capacity - curJug2;
                if(jug2LeftRoom >= curJug1) {
                    nextPairs.add(new Pair<>(0, curJug2 + curJug1));
                } else {
                    nextPairs.add(new Pair<>(curJug1 - jug2LeftRoom, jug2Capacity));
                }
                // pour jug2 to jug1
                int jug1LeftRoom = jug1Capacity - curJug1;
                if(jug1LeftRoom >= curJug2){
                    nextPairs.add(new Pair<>(curJug1 + curJug2, 0));
                } else {
                    nextPairs.add(new Pair<>(jug1Capacity, curJug2 - jug1LeftRoom));
                }

                for(Pair<Integer, Integer> nextPair : nextPairs){
                    if(visited.contains(nextPair)){
                        continue;
                    }
                    visited.add(nextPair);
                    int nextCurJug1 = nextPair.getKey();
                    int nextCurJug2 = nextPair.getValue();
                    if(nextCurJug1 == targetCapacity || nextCurJug2 == targetCapacity || (nextCurJug1 + nextCurJug2) == targetCapacity){
                        return true;
                    }

                    queue.offer(nextPair);
                }
            }
        }

        return false;
    }
}
