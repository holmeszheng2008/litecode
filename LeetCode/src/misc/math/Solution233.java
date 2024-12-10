package misc.math;

// 233. Number of Digit One
public class Solution233 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = nums[0];
        suffix[n - 1] = nums[n - 1];

        for(int i = 1; i < n; i++){
            prefix[i] = nums[i] * prefix[i-1];
        }
        for(int i = n-2; i >= 0; i--){
            suffix[i] = nums[i] * suffix[i+1];
        }

        int[] res = new int[n];
        res[0] = suffix[1];
        res[n-1] = prefix[n-2];
        for(int i = 1; i < n-1; i++){
            res[i] = prefix[i-1] * suffix[i+1];
        }

        return res;
    }
}

class Solution233_o1_storage {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--){
            res[i] = res[i+1] * nums[i];
        }

        int prefix = 1;
        for(int i = 0; i < nums.length - 1; i++){
            res[i] = prefix * res[i+1];
            prefix *= nums[i];
        }

        res[n-1] = prefix;

        return res;
    }
}

class Solution233_attempt1 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[n-1] = 1;
        for(int i = n-2; i >= 0; i--){
            res[i] = res[i+1] * nums[i+1];
        }

        int prefix = 1;
        for(int i = 0; i < n; i++){
            res[i] = prefix * res[i];
            prefix = prefix * nums[i];
        }

        return res;
    }
}