package array_linked_list.two_pointers.left_right_pointers;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 3Sum
class Solution55 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2;) {
            int a = nums[i];
            int balance = 0 - a;
            int j = i + 1, k = n - 1;
            while (j < k) {
                if (nums[j] + nums[k] < balance) {
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                } else if (nums[j] + nums[k] > balance) {
                    k--;
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
            i++;
            while (i < n - 2 && nums[i] == nums[i - 1]) {
                i++;
            }
        }
        return result;
    }
}

class Solution15_try1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2;){
            int diff = 0 - nums[i];
            int j = i + 1, k = nums.length - 1;
            while(j < k){
                if (nums[j] + nums[k] == diff){
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    while(j < nums.length && nums[j] == nums[j-1] && j < k) {
                        j++;
                    }
                    k--;
                    while(k >= 0 && nums[k] == nums[k+1] && j<k) {
                        k--;
                    }
                } else if (nums[j] + nums[k] < diff){
                    j++;
                    while(j < nums.length && nums[j] == nums[j-1] && j<k) {
                        j++;
                    }
                } else if (nums[j] + nums[k] > diff) {
                    k--;
                    while(k >= 0 && nums[k] == nums[k+1] && j < k) {
                        k--;
                    }
                }
            }

            i++;
            while(i < nums.length - 2 && nums[i] == nums[i-1]){
                i++;
            }
        }

        return res;
    }
}