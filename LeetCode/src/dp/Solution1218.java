package dp;

import java.util.HashMap;
import java.util.Map;

// 1218. Longest Arithmetic Subsequence of Given Difference
public class Solution1218 {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        Map<Integer, Integer> numToLastIndexMap = new HashMap<>();
        int res = 1;
        int[] memo = new int[n];
        memo[0] = 1;
        numToLastIndexMap.put(arr[0], 0);

        for(int i = 1; i < n; i++){
            int num = arr[i];
            int preNum = num - difference;

            Integer preNumLastIndex = numToLastIndexMap.get(preNum);
            if(preNumLastIndex == null){
                memo[i] = 1;
            } else {
                memo[i] = 1 + memo[preNumLastIndex];
                res = Math.max(res, memo[i]);
            }

            numToLastIndexMap.put(num, i);
        }

        return res;
    }
}
