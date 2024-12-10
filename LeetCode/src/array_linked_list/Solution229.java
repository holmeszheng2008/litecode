package array_linked_list;

import java.util.ArrayList;
import java.util.List;

// 229. Majority Element II
public class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0, candidate1 = Integer.MAX_VALUE, candidate2 = Integer.MAX_VALUE;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(candidate1 == nums[i]) {
                count1++;
            } else if(candidate2 == nums[i]){
                count2++;
            } else {
                if(count1 == 0){
                    count1++;
                    candidate1 = nums[i];
                } else if(count2 == 0) {
                    count2++;
                    candidate2 = nums[i];
                } else {
                    count1--;
                    count2--;
                }
            }
        }

        count1 = 0;
        count2 = 0;
        for(int i =0; i < nums.length; i++){
            if(candidate1 == nums[i]){
                count1++;
            } else if (candidate2 == nums[i]){
                count2++;
            }
        }

        if(count1 > nums.length / 3) {
            res.add(candidate1);
        }
        if(count2 > nums.length / 3){
            res.add(candidate2);
        }

        return res;
    }
}
