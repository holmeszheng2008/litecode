package greedy;

// 330. Patching Array
public class Solution330 {
    public int minPatches(int[] nums, int n) {
        int count = 0;
        long sum = 0;
        int i = 0;
        while(sum < n){
            if(i == nums.length || sum + 1 < nums[i]) {
                count++;
                sum += sum + 1;
            } else {
                sum += nums[i];
                i++;
            }
        }

        return count;
    }
}
