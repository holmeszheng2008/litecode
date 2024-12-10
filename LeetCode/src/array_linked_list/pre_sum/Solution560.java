package array_linked_list.pre_sum;

import java.util.HashMap;
import java.util.Map;

// 560. Subarray Sum Equals K
// PreSum + 2Sum
public class Solution560 {
    Map<Integer, Integer> map = new HashMap<>();
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        for (int i = 0; i < preSum.length; i++) {
            int val = preSum[i];
            int count = map.getOrDefault(val - k, 0);
            res += count;
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        return res;
    }
}
