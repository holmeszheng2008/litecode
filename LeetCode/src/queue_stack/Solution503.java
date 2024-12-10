package queue_stack;

import java.util.Stack;

// 503. Next Greater Element II (monotonic stack)
public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int length = nums.length;
        int[] res = new int[length];
        for (int i = 2 * length - 1; i >= 0; i--) {
            int index = i % length;
            while (!stack.isEmpty()) {
                if (stack.peek() <= nums[index]) {
                    stack.pop();
                } else {
                    break;
                }
            }
            if (i <= length - 1) {
                if (stack.isEmpty()) {
                    res[i] = -1;
                } else {
                    res[i] = stack.peek();
                }
            }

            stack.push(nums[index]);
        }

        return res;
    }
}
