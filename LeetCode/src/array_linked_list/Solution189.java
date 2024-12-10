package array_linked_list;

// 189. Rotate Array
public class Solution189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        if(k == 0){
            return;
        }

        int[] backup = new int[k];
        for(int i = n-k; i < n; i++){
            backup[k - n + i] = nums[i];
        }

        for(int i = n-k-1; i >= 0; i--){
            nums[i+k] = nums[i];
        }

        for(int i = 0; i < k; i++){
            nums[i] = backup[i];
        }
    }
}

class Solution_inplace {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        rotateij(nums, 0, nums.length - 1);
        rotateij(nums, 0, k - 1);
        rotateij(nums, k, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        final int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void rotateij(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}