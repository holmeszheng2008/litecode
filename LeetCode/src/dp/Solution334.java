package dp;

// 334. Increasing Triplet Subsequence
class Solution334_dp {
    public boolean increasingTriplet(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if(dp[i] == 3){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}

/*
The question only asks whether it exists. The key to prove this solution is always correct is that there is always a number before c2 that is less than c2, which might or might not be c1 (otherwise, c2==INT_MAX and wont get updated). Now if a number is greater than c2, we can safely return true.
 */
class Solution334 {
    public boolean increasingTriplet(int[] nums) {
        int c1 = Integer.MAX_VALUE, c2 = Integer.MAX_VALUE;
        for(int num : nums){
            if(num <= c1){
                c1 = num;
            } else if (num <= c2){
                c2 = num;
            }

            if(c2 != Integer.MAX_VALUE && num > c2){
                return true;
            }
        }

        return false;
    }
}