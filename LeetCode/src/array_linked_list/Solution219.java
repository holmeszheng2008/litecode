package array_linked_list;

import java.util.HashMap;
import java.util.Map;

// 219. Contains Duplicate II
public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int value = nums[i];
            if(map.containsKey(value)){
                int j = map.get(value);
                if(i - j <= k){
                    return true;
                } else {
                    map.put(value, i);
                }
            } else {
                map.put(value, i);
            }
        }

        return false;
    }
}
