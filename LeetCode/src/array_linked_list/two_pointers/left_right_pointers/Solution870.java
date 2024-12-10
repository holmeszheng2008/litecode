package array_linked_list.two_pointers.left_right_pointers;

import java.util.Arrays;
import java.util.PriorityQueue;

// 870. Advantage Shuffle
public class Solution870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        int left = 0, right = nums1.length - 1;
        Arrays.sort(nums1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] o1, int[] o2) -> {
            return o2[1] - o1[1];
        });
        for (int i = 0; i < nums2.length; i++) {
            pq.add(new int[] {i, nums2[i]});
        }
        while (!pq.isEmpty()) {
            int[] tuple = pq.poll();
            if (nums1[right] > tuple[1]) {
                result[tuple[0]] = nums1[right];
                right--;
            } else {
                result[tuple[0]] = nums1[left];
                left++;
            }
        }

        return result;
    }
}
