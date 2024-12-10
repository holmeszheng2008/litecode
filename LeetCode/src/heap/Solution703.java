package heap;

import java.util.PriorityQueue;

// 703. Kth Largest Element in a Stream
public class Solution703 {
    class KthLargest {
        private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        private int k;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int i : nums) {
                add(i);
            }
        }

        public int add(int val) {
            minHeap.add(val);
            if (minHeap.size() > k) {
                minHeap.poll();
            }

            return minHeap.peek();
        }
    }
}
