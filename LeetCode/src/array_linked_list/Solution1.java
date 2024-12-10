package array_linked_list;

import java.util.HashMap;
import java.util.Map;

// unsorted 2 sum, 2 minus
// 2sum nums[i] + nums[j] = k
// 2minus nums[i] - nums[j] = k;
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = null;
        if (nums == null || nums.length < 2) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int balance = target - nums[i];
            if (map.containsKey(balance)) {
                return new int[] {i, map.get(balance)};
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}