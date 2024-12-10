package dp;

// 410. Split Array Largest Sum
public class Solution410 {
    private int[] preSums;
    private Integer[][][] memo;
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        preSums = new int[n + 1];
        memo = new Integer[n][n][51];
        for(int i = 0; i < n; i++){
            preSums[i+1] = preSums[i] + nums[i];
        }
        return split(nums, 0, n - 1, k);
    }

    private int split(int[] nums, int left, int right, int k){
        if(memo[left][right][k] != null){
            return memo[left][right][k];
        }
        if(k == 1){
            return preSums[right+1] - preSums[left];
        }

        if(right + 1 - left == k){
            int res = Integer.MIN_VALUE;
            for(int i = left; i <= right; i++){
                res = Math.max(res, nums[i]);
            }

            return res;
        }

        int res = Integer.MAX_VALUE;
        int leftB = left + 1, rightB = right + 2 - k;
        while(leftB <= rightB){
            int middle = leftB + (rightB - leftB) / 2;

            int preSum = preSums[middle] - preSums[left];
            int rightSumMax = split(nums, middle, right, k-1);

            res = Math.min(res, Math.max(preSum, rightSumMax));
            if(preSum > rightSumMax){
                rightB = middle - 1;
            } else if(preSum < rightSumMax){
                leftB = middle + 1;
            } else {
                res = preSum;
                break;
            }
        }

        memo[left][right][k] = res;
        return res;
    }
}


class Solution410_binarySearch {
    public int splitArray(int[] nums, int k) {
        int maxNum = Integer.MIN_VALUE;
        for(int num : nums){
            maxNum = Math.max(maxNum, num);
        }

        int left = maxNum, right = 1_000_000_000;
        while(left <= right){
            int middle = left + (right - left) / 2;
            int arrayNum = getArrayNums(nums, middle);
            if(arrayNum > k){
                left = middle + 1;
            } else if(arrayNum < k){
                right = middle - 1;
            } else if(arrayNum == k){
                right = middle - 1;
            }
        }

        return left;
    }

    private int getArrayNums(int[] nums, int largestSum){
        int sum = 0;
        int res = 0;
        for(int i = 0; i < nums.length;){
            if(sum + nums[i] > largestSum) {
                res++;
                sum = 0;
            } else {
                sum += nums[i];
                i++;
            }
        }

        if(sum > 0){
            res++;
        }

        return res;
    }
}
