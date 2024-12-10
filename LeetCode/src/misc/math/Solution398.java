package misc.math;

import java.util.*;

// 398. Random Pick Index
public class Solution398 {
    private int[] nums;
    private Random random = new Random();

    public Solution398(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int res = 0, j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                j++;
            } else {
                continue;
            }

            int randomNum = random.nextInt(j);
            if (randomNum == 0){
                res = i;
            }
        }

        return res;
    }
}

class Solution398_Hash {
    private Map<Integer, List<Integer>> map;
    private Random random = new Random();

    public Solution398_Hash(int[] nums) {
        map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            List<Integer> list = map.get(nums[i]);
            if (list == null){
                list = new ArrayList<>();
                map.put(nums[i], list);
            }
            list.add(i);
        }
    }

    public int pick(int target) {
        int res = -1;
        List<Integer> list = map.get(target);
        return list.get(random.nextInt(list.size()));
    }
}
