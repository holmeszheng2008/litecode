package array_linked_list;

import java.util.ArrayList;
import java.util.List;

// 442. Find All Duplicates in an Array
public class Solution442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n;){
            int num = nums[i];
            int index = num - 1;
            if(i == index) {
                i++;
                continue;
            }
            if(nums[index] == num){
                res.add(num);
                i++;
                continue;
            }

            nums[i] = nums[index];
            nums[index] = num;
            if(index < i){
                i++;
            }
        }

        return res;
    }
}
