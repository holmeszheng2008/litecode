package array_linked_list;

import java.util.HashSet;
import java.util.Set;

// 217. Contains Duplicate
public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }

        return false;
    }
}
