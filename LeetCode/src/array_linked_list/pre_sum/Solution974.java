package array_linked_list.pre_sum;

import java.util.HashMap;
import java.util.Map;

// 974. Subarray Sums Divisible by K
public class Solution974 {
    public int subarraysDivByK(int[] nums, int k) {
        int res = 0;
        int n = nums.length;
        int[] preSums = new int[n+1];
        for(int i = 1; i < preSums.length; i++){
            preSums[i] = preSums[i-1] + nums[i-1];
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int i = 1; i < preSums.length; i++){
            int remainder = preSums[i] % k;
            res += map.getOrDefault(remainder, 0);
            res += map.getOrDefault(remainder - k, 0);
            res += map.getOrDefault(remainder + k, 0);

            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return res;
    }
}
