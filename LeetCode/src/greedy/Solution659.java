package greedy;

import java.util.HashMap;
import java.util.Map;

// 659. Split Array into Consecutive Subsequences
public class Solution659 {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> exist = new HashMap<>();
        Map<Integer, Integer> need = new HashMap<>();
        for(int num : nums){
            exist.put(num, exist.getOrDefault(num, 0) + 1);
        }

        for(int num : nums){
            if(exist.get(num) == 0){
                continue;
            }
            if(need.getOrDefault(num, 0) > 0){
                exist.put(num, exist.get(num) - 1);
                need.put(num, need.get(num) - 1);
                need.put(num + 1, need.getOrDefault(num + 1, 0) + 1);
            } else if (exist.getOrDefault(num, 0) > 0 && exist.getOrDefault(num + 1, 0) > 0 && exist.getOrDefault(num + 2, 0) > 0){
                exist.put(num, exist.get(num) -1);
                exist.put(num+1, exist.get(num+1) -1);
                exist.put(num+2, exist.get(num+2) -1);
                need.put(num + 3, need.getOrDefault(num + 3, 0) + 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
