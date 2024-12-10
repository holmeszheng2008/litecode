package array_linked_list.two_pointers.left_right_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 18. 4Sum
public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; ) {
            long diff1 = (long)target - nums[i];

            for (int j = i + 1; j < nums.length - 2; ) {
                long diff2 = diff1 - nums[j];

                int k = j + 1, w = nums.length - 1;
                while (k < w) {
                    if (nums[k] + nums[w] == diff2) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[w]));

                        k++;
                        while (k < w && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        w--;
                        while (k < w && nums[w] == nums[w + 1]) {
                            w--;
                        }
                    } else if (nums[k] + nums[w] < diff2) {
                        k++;
                        while (k < w && nums[k] == nums[k - 1]) {
                            k++;
                        }
                    } else if (nums[k] + nums[w] > diff2) {
                        w--;
                        while (k < w && nums[w] == nums[w + 1]) {
                            w--;
                        }
                    }
                }

                j++;
                while (j < nums.length - 2 && nums[j] == nums[j - 1]) {
                    j++;
                }
            }

            i++;
            while (i < nums.length - 3 && nums[i] == nums[i - 1]) {
                i++;
            }
        }

        return res;
    }
}
