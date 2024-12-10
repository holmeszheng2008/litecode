package array_linked_list.pre_sum;

// 209. Minimum Size Subarray Sum
public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] preSums = new int[n+1];
        for(int i = 1; i < n+1; i++){
            preSums[i] = preSums[i-1] + nums[i-1];
        }

        int minLength = Integer.MAX_VALUE;
        for(int i = 0; i <= n; i++){
            int thisTarget = preSums[i] + target;
            int low = i, high = n;
            while(low <= high){
                int middle = low + (high - low) / 2;
                int value = preSums[middle];
                if(value > thisTarget){
                    high = middle - 1;
                } else if (value < thisTarget){
                    low = middle + 1;
                } else if (value == thisTarget){
                    high = middle - 1;
                }
            }

            if(low <= n){
                minLength = Math.min(minLength, low - i);
            }
        }

        if(minLength == Integer.MAX_VALUE){
            return 0;
        }
        return minLength;
    }
}

// Sliding window
class Solution209_slidingWindow {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        while(right < nums.length){
            sum += nums[right];
            right++;

            while(sum >= target){
                minLength = Math.min(minLength, right - left);
                sum -= nums[left];
                left++;
            }
        }

        if(minLength == Integer.MAX_VALUE){
            return 0;
        }
        return minLength;
    }
}