package binary_search_tree;

import java.util.TreeSet;

// 220. Contains Duplicate III
public class Solution220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Integer> values = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            int value = nums[i];
            Integer ceiling = values.ceiling(value);
            Integer floor = values.floor(value);

            if((ceiling != null && ceiling - value <= valueDiff) || (floor != null && value - floor <= valueDiff)){
                return true;
            }

            if(i >= indexDiff){
                values.remove(nums[i - indexDiff]);
            }
            values.add(value);
        }

        return false;
    }
}
