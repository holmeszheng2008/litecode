package data_structure_design_to_satisfy;

import java.util.Stack;

// 155. Min Stack
public class Solution155 {
    private static class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if(minStack.isEmpty()){
                minStack.push(val);
            } else {
                int minTop = minStack.peek();
                minStack.push(Math.min(val, minTop));
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
