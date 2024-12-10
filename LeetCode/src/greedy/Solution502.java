package greedy;

import util.Pair;

import java.util.*;

// 502. IPO
public class Solution502 {
        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
            List<Pair<Integer, Integer>> list = new ArrayList<>();
            for(int i = 0; i < profits.length; i++){
                list.add(new Pair<>(capital[i], profits[i]));
            }

            Collections.sort(list, Comparator.comparingInt(o -> o.getKey()));

            int finalCapital = w;
            int j = 0;
            PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
            for(int i = 0; i < k; i++){
                while(j < list.size() && list.get(j).getKey() <= finalCapital){
                    pq.offer(list.get(j));
                    j++;
                }

                if(pq.isEmpty()){
                    break;
                }
                Pair<Integer, Integer> optimal = pq.poll();
                finalCapital += optimal.getValue();
            }

            return finalCapital;
    }
}
