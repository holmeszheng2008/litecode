package data_structure_design_to_satisfy;

// 307. Range Sum Query - Mutable
// Construct to fit the definition of segment tree but rangSum won't work
public class Solution307 {
    class NumArray {
        private int[] tree;
        private int n;
        private int[] nums;
        public NumArray(int[] nums) {
            this.n = nums.length;
            this.tree = new int[n*2];
            this.nums = nums;

            constructTree(1, 0, n-1);
        }

        private void constructTree(int treeIndex, int left, int right){
            if(left == right){
                tree[treeIndex] = nums[left];
                return;
            }

            int middle = (left + right) / 2;
            constructTree(2 * treeIndex, left, middle);
            constructTree(2 * treeIndex + 1, middle + 1, right);

            tree[treeIndex] = tree[2 * treeIndex] + tree[2*treeIndex+1];
        }

        public void update(int index, int val) {
            update(1, 0, n-1, index, val);
        }

        private void update(int treeIndex, int left, int right, int index, int val){
            if(index < left || index > right){
                return;
            }
            if(left == right && left == index){
                tree[treeIndex] = val;
                return;
            }
            int middle = (left + right) / 2;
            update(2 * treeIndex, index, val, left, middle);
            update(2 * treeIndex + 1, index, val, middle + 1, right);

            tree[treeIndex] = tree[2 * treeIndex] + tree[2 * treeIndex + 1];
        }

        public int sumRange(int left, int right) {
            int leftTreeIndex = 1, rightTreeIndex = 1;
            while(leftTreeIndex * 2 < 2 * n){
                leftTreeIndex = 2 * leftTreeIndex;
            }
            while(rightTreeIndex * 2  + 1 < 2 * n) {
                rightTreeIndex = rightTreeIndex * 2  + 1;
            }

            int sum = 0;
            while(leftTreeIndex <= rightTreeIndex){
                if(leftTreeIndex % 2 == 1) {
                    sum += tree[leftTreeIndex];
                    leftTreeIndex++;
                }
                if(rightTreeIndex % 2 == 0){
                    sum += tree[rightTreeIndex];
                    rightTreeIndex--;
                }

                leftTreeIndex /= 2;
                rightTreeIndex /= 2;
            }

            return sum;
        }
    }
}

// Structure doesn't make sense but works
class Solution307_pass{
    class NumArray {
        private int[] tree;
        private int[] nums;
        private int n;
        public NumArray(int[] nums) {
            this.n = nums.length;
            this.tree = new int[n*2];
            this.nums = nums;

            for(int i = n; i < 2 * n; i++){
                tree[i] = nums[i-n];
            }

            for(int i = n-1; i > 0; i--){
                tree[i] = tree[2*i] + tree[2*i+1];
            }
        }

        public void update(int index, int val) {
            tree[index + n] = val;
            for(int i = (index+n) / 2; i > 0; i /= 2){
                tree[i] = tree[2*i] + tree[2*i+1];
            }
        }

        public int sumRange(int left, int right) {
            left += n;
            right += n;
            int sum = 0;
            while(left <= right){
                if(left % 2 == 1){
                    sum += tree[left];
                    left++;
                }
                if(right % 2 == 0){
                    sum += tree[right];
                    right--;
                }
                left /= 2;
                right /= 2;
            }

            return sum;
        }
    }
}