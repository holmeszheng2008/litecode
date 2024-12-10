package array_linked_list;

import java.util.*;

// 347. Top K Frequent Elements
public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Set<Integer>> freqToNumsMap = new HashMap<>();
        Map<Integer, Integer> numToFreqMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int freq = numToFreqMap.getOrDefault(num, 0);
            if(freq == 0) {

            } else {
                Set<Integer> numsSet = freqToNumsMap.get(freq);
                numsSet.remove(num);
                if(numsSet.isEmpty()){
                    freqToNumsMap.remove(freq);
                }
            }

            freq++;
            numToFreqMap.put(num, freq);
            Set<Integer> newNumsSet = freqToNumsMap.get(freq);
            if(newNumsSet == null){
                newNumsSet = new HashSet<>();
                freqToNumsMap.put(freq, newNumsSet);
            }
            newNumsSet.add(num);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((o2, o1) -> o1 - o2);
        for(int freq : freqToNumsMap.keySet()){
            pq.add(freq);
        }
        for(int i = 0; i < k;){
            int freq = pq.poll();
            Set<Integer> numsSet = freqToNumsMap.get(freq);
            for(int num : numsSet){
                res[i++] = num;
                if(i == k){
                    break;
                }
            }
        }

        return res;
    }
}
