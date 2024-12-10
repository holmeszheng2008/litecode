package queue_stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution239 {
    private class MonotonicQueue {
        private Deque<Integer> deque = new LinkedList<>();

        public void offer(Integer e) {
            while (!deque.isEmpty() && deque.peekLast() < e) {
                deque.pollLast();
            }
            deque.offerLast(e);
        }

        public void remove(Integer e) {
            if (deque.peekFirst().equals(e)) {
                deque.pollFirst();
            }
        }
        public int max() {
            return deque.peekFirst();
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue mq = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();
        int left = 0, right = 0;
        while (right - left < k) {
            mq.offer(nums[right]);
            right++;
        }
        res.add(mq.max());
        while (right < nums.length) {
            int in = nums[right];
            right++;
            mq.offer(in);
            int out = nums[left];
            left++;
            mq.remove(out);
            res.add(mq.max());
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}


class Solution239_attempt1 {
    private LinkedList<Integer> window;
    public int[] maxSlidingWindow(int[] nums, int k) {
        this.window = new LinkedList<>();

        List<Integer> res = new ArrayList<>();
        int left = 0, right = k;
        for(int i = left; i < right; i++){
            addToWindow(nums[i]);
        }

        res.add(window.peekFirst());
        while(right != nums.length){
            removeFromWindow(nums[left++]);
            addToWindow(nums[right++]);
            res.add(window.peekFirst());
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    private void addToWindow(int num){
        while(!window.isEmpty()) {
            int last = window.peekLast();
            if(num > last){
                window.removeLast();
            } else {
                break;
            }
        }
        window.addLast(num);
    }

    private void removeFromWindow(int num){
        if(window.isEmpty()){
            return;
        }
        int first = window.peekFirst();
        if(first == num){
            window.removeFirst();
        }
    }


}