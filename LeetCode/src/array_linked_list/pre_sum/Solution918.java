package array_linked_list.pre_sum;

// 918. Maximum Sum Circular Subarray
public class Solution918 {
    public int maxSubarraySumCircular(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        for(int i = 1; i < preSum.length; i++){
            preSum[i] = preSum[i-1] + nums[i-1];
        }

        int sum = preSum[nums.length] - preSum[0];

        int tempMin = 0;
        int tempMax = 0;
        int tempMaxIndex = 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minI = 0, minJ = 0;
        for(int i = 1; i < preSum.length; i++){
            min = Math.min(min, preSum[i] - tempMax);
            if(min == preSum[i] - tempMax){
                minI = tempMaxIndex;
                minJ = i-1;
            }
            max = Math.max(max, preSum[i] - tempMin);

            tempMin = Math.min(tempMin, preSum[i]);
            tempMax = Math.max(tempMax, preSum[i]);
            if(tempMax == preSum[i]){
                tempMaxIndex = i;
            }
        }


        if(minI == 0 && minJ == nums.length - 1){
            return max;
        } else {
            return Math.max(max, sum - min);
        }
    }
}
