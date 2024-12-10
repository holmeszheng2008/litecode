package array_linked_list;

import java.util.Random;

// 384. Shuffle an Array
public class Solution384 {
    class Solution {
        private Random random;
        private int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
            this.random = new Random();
        }

        public int[] reset() {
            return nums;
        }

        public int[] shuffle() {
            int[] cloned = nums.clone();
            int n = cloned.length;
            for(int i = 0; i < n; i++){
                int j = random.nextInt(i, n);
                int temp = cloned[i];
                cloned[i] = cloned[j];
                cloned[j] = temp;
            }

            return cloned;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
}
