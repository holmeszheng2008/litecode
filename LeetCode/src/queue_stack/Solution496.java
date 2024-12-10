package queue_stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 496. Next Greater Element I (monotonic stack)
public class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            indexMap.put(nums1[i], i);
        }
        int[] res = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty()) {
                if (stack.peek() <= nums2[i]) {
                    stack.pop();
                } else {
                    break;
                }
            }
            if (indexMap.containsKey(nums2[i])) {
                if (stack.isEmpty()) {
                    res[indexMap.get(nums2[i])] = -1;
                } else {
                    res[indexMap.get(nums2[i])] = stack.peek();
                }
            }
            stack.push(nums2[i]);
        }

        return res;
    }
}
