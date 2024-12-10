package queue_stack;

import java.util.Stack;

// 232. Implement Queue using Stacks
public class Solution232 {
    private static class MyQueue {

        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack2.push(x);
        }

        public int pop() {
            if (stack1.isEmpty()) {
                refill();
            }
            return stack1.pop();
        }

        public int peek() {
            if (stack1.isEmpty()) {
                refill();
            }
            return stack1.peek();
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.empty();
        }

        private void refill() {
            if (stack2.isEmpty()) {
                throw new RuntimeException("exceptioin");
            }
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }
    }
}

class Solution232_attempt1 {
    private class MyQueue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public MyQueue() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        public void push(int x) {
            stack2.push(x);
        }

        public int pop() {
            if(stack1.empty()){
                flush();
            }
            return stack1.pop();
        }

        public int peek() {
            if(stack1.empty()){
                flush();
            }
            return stack1.peek();
        }

        public boolean empty() {
            if(stack1.empty() && stack2.empty()){
                return true;
            }
            return false;
        }

        private void flush(){
            while(!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }
    }
}