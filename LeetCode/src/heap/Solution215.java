package heap;

import java.util.PriorityQueue;
import java.util.Random;

// 215. Kth Largest Element in an Array
public class Solution215 {
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }

    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        k = nums.length - k;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int p = partition(nums, low, high);
            if (p < k) {
                low = p + 1;
            } else if (p > k) {
                high = p - 1;
            } else {
                return nums[p];
            }
        }

        return -1;

    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i = low, j = high;
        while (i <= j) {
            while (i <= high && nums[i] <= pivot) {
                i++;
            }
            while (j >= 0 && nums[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(nums, i, j);
            }
        }
        swap(nums, j, low);

        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void shuffle(int[] nums) {
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int r = i + random.nextInt(nums.length - i);
            swap(nums, i, r);
        }
    }
}

class Solution215_attempt1 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < k; i++){
            pq.offer(nums[i]);
        }
        for(int i = k; i < nums.length; i++){
            pq.offer(nums[i]);
            pq.poll();
        }

        return pq.poll();
    }
}