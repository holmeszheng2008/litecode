package string;

import java.util.ArrayList;
import java.util.List;

// 228. Summary Ranges
public class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        int from = nums[0];
        int pre = nums[0];
        for(int i = 1; i < nums.length; i++){
            int cur = nums[i];
            if(cur == pre+1){
                pre = cur;
                continue;
            }
            if(from == pre) {
                res.add(String.valueOf(from));
            } else {
                res.add(from + "->" + pre);
            }
            from = cur;
            pre = cur;
        }

        if(from == pre) {
            res.add(String.valueOf(from));
        } else {
            res.add(from + "->" + pre);
        }

        return res;
    }
}
