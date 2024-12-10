package array_linked_list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 350. Intersection of Two Arrays II
public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> valToFreq = new HashMap<>();
        for(int i = 0; i < nums1.length; i++){
            int num = nums1[i];
            valToFreq.put(num, valToFreq.getOrDefault(num, 0) + 1);
        }

        for(int i = 0; i < nums2.length; i++){
            int num = nums2[i];
            Integer freq = valToFreq.get(num);
            if(freq != null){
                list.add(num);
                freq--;
                if(freq == 0){
                    valToFreq.remove(num);
                } else {
                    valToFreq.put(num, freq);
                }
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
