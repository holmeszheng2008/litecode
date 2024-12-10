package backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 698. Partition to K Equal Sum Subsets
public class Solution698 {
    private boolean res = false;
    private int[] nums;
    private int k;
    private Set<Integer> memo = new HashSet<>();

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        if (k > nums.length) {
            return false;
        }
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum/k;
        this.nums = nums;
        this.k = k;

        backtracking(0, 0, 0, target, 0);

        return res;
    }

    private void backtracking(int bucketI, int preSum, int start, int target, int used) {
        if (res) {
            return;
        }
        if (memo.contains(used)) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (((used >> i) & 1) == 1) {
                continue;
            }
            if (preSum + nums[i] > target) {
                continue;
            }
            used |= 1 << i;
            preSum += nums[i];

            if (preSum == target && bucketI == k - 1) {
                res = true;
                return;
            } else {
                if (preSum == target) {
                    backtracking(bucketI + 1, 0, 0, target, used);
                } else {
                    backtracking(bucketI, preSum, i + 1, target, used);
                }
            }

            used &= ~(1 << i);
            preSum -= nums[i];
        }

        memo.add(used);
    }
}


// 以数字（球）为视角，桶是选择
class Solution698_attempt1 {

    boolean res;
    int[] pSums;
    int k;
    int[] nums;
    int target;
    Set<String> memo = new HashSet<>();

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum % k != 0) {
            return false;
        }

        this.target = sum / k;
        this.pSums = new int[k];
        this.k = k;
        this.nums = nums;

        backtracking(0);

        return res;
    }

    private void backtracking(int i){
        if(res){
            return;
        }

       if(memo.contains(createMemoKey())) {
            return;
        }
        for(int bucket = 0; bucket < k; bucket++){
            if(pSums[bucket] + nums[i] > target) {
                continue;
            }
            pSums[bucket] += nums[i];
            if(pSums[bucket] == target && allEquals()){
                res = true;
                return;
            } else {
                backtracking(i+1);
            }

            pSums[bucket] -= nums[i];
        }
        memo.add(createMemoKey());
    }

    private boolean allEquals(){
        for(int pSum : pSums){
            if(pSum != target){
                return false;
            }
        }
        return true;
    }

    private String createMemoKey(){
        int[] clone = pSums.clone();
        Arrays.sort(clone);

        return Arrays.toString(clone);
    }
}

// 以桶为视角，数字作为选择
class Solution698_attempt2 {
    int target;
    int[] nums;
    int used;
    boolean res;
    int k;
    Set<Integer> memo = new HashSet<>();

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum % k != 0) {
            return false;
        }

        this.target = sum / k;
        this.nums = nums;
        this.k = k;

        backtracking(0, 0);
        return res;
    }

    private void backtracking(int bucketI, int sum) {
        if (res){
            return;
        }
        if(bucketI == k){
            return;
        }
        if(memo.contains(used)){
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(((used >> i) & 1) == 1){
                continue;
            }
            if(sum + nums[i] > target){
                continue;
            }
            sum += nums[i];
            used = used | (1 << i);

            if(sum == target && bucketI == k-1) {
                res = true;
                return;
            } else {
                if(sum < target) {
                    backtracking(bucketI, sum);
                } else {
                    backtracking(bucketI + 1, 0);
                }
            }

            sum -= nums[i];
            used = used & ~(1 << i);
        }
        memo.add(used);
    }
}