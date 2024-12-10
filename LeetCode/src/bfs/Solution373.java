package bfs;

import util.Pair;

import java.util.*;

// 373. Find K Pairs with Smallest Sums
public class Solution373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int m = nums1.length, n = nums2.length;
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    return (nums1[o1.getKey()] + nums2[o1.getValue()]) - (nums1[o2.getKey()] + nums2[o2.getValue()]);
                }
        );
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        Pair firstPair = new Pair(0, 0);
        visited.add(firstPair);
        pq.add(firstPair);

        while(!pq.isEmpty()){
            Pair<Integer, Integer> curPair = pq.poll();

            int i = curPair.getKey(), j = curPair.getValue();
            res.add(Arrays.asList(nums1[i], nums2[j]));

            k--;
            if(k == 0){
                break;
            }

            if(i + 1 < m){
                Pair<Integer, Integer> nextPair = new Pair<>(i+1, j);
                if(!visited.contains(nextPair)) {
                    visited.add(nextPair);
                    pq.add(nextPair);
                }
            }
            if(j + 1 < n){
                Pair<Integer, Integer> nextPair = new Pair<>(i, j+1);
                if(!visited.contains(nextPair)){
                    visited.add(nextPair);
                    pq.add(nextPair);
                }
            }
        }

        return res;
    }
}
