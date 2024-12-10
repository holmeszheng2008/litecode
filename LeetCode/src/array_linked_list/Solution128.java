package array_linked_list;

import java.util.HashSet;
import java.util.Set;

// 128. Longest Consecutive Sequence
public class Solution128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int res = 0;
        for(int num : nums){
            if(set.contains(num-1)){
                continue;
            }

            int curNum = num;
            int curLen = 1;
            curNum++;
            while(set.contains(curNum)){
                curNum++;
                curLen++;
            }

            res = Math.max(res, curLen);
        }

        return res;
    }
}
