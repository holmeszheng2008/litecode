package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 368. Largest Divisible Subset
public class Solution368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer>[] dp = new ArrayList[n];

        dp[0] = new ArrayList<>();
        dp[0].add(nums[0]);
        List<Integer> res = dp[0];

        for(int i = 1; i < n; i++){
            List<Integer> tempList = new ArrayList<>();
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 && dp[j].size() > tempList.size()){
                    tempList = new ArrayList<>(dp[j]);
                }
            }

            tempList.add(nums[i]);
            dp[i] = tempList;
            if(tempList.size() > res.size()){
                res = tempList;
            }
        }


        return res;
    }
}