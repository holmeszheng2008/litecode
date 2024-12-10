package greedy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Solution2244 {
    public int minimumRounds(int[] tasks) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int task : tasks){
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        Collection<Integer> freqs = map.values();
        for(int freq : freqs){
            if(freq == 1) {
                return -1;
            }
            res += (freq + 2) / 3;
        }

        return res;
    }
}
