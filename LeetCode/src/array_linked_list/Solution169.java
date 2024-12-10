package array_linked_list;

// 169. Majority Element
public class Solution169 {
    public int majorityElement(int[] nums) {
        int target = 0;
        int count = 0;
        for(int num : nums){
            if(count == 0) {
                count++;
                target = num;
            } else {
                if(target == num) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        return target;
    }
}
