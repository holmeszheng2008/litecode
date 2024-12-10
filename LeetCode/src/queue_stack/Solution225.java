package queue_stack;

import java.util.LinkedList;
import java.util.Queue;

// 225. Implement Stack using Queues
public class Solution225 {
    private static class MyStack {
        private Queue<Integer> op;
        private Queue<Integer> buf;
        public MyStack() {
            op = new LinkedList<>();
            buf = new LinkedList<>();
        }

        public void push(int x) {
            op.offer(x);
        }

        public int pop() {
            int size = op.size();
            if (size == 0) {
                throw new RuntimeException("Exception");
            }
            while (size > 1) {
                buf.offer(op.poll());
                size--;
            }

            int element = op.poll();
            Queue<Integer> temp = op;
            op = buf;
            buf = temp;

            return element;
        }

        public int top() {
            int size = op.size();
            if (size == 0) {
                throw new RuntimeException("Exception");
            }
            while (size > 1) {
                buf.offer(op.poll());
                size--;
            }

            int element = op.poll();
            buf.offer(element);
            Queue<Integer> temp = op;
            op = buf;
            buf = temp;

            return element;
        }

        public boolean empty() {
            return op.isEmpty();
        }
    }

    private static class MyStack1 {
        private Queue<Integer> queue;
        private Integer topElement;

        public MyStack1() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            topElement = x;
            queue.offer(x);
        }

        public int pop() {
            int size = queue.size();
            if (size == 0) {
                throw new RuntimeException("Exception");
            }
            if (size == 1) {
                topElement = null;
                return queue.poll();
            }
            while (size > 2) {
                queue.offer(queue.poll());
                size--;
            }

            topElement = queue.poll();
            queue.offer(topElement);

            return queue.poll();
        }

        public int top() {
            if (topElement == null) {
                throw new RuntimeException("exception");
            }
            return topElement;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

    /**
     * Your MyStack object will be instantiated and called as such: MyStack obj = new MyStack();
     * obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top(); boolean param_4 = obj.empty();
     */
}
