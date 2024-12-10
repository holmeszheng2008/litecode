package queue_stack.monotonic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 1673. Find the Most Competitive Subsequence
public class Solution1673 {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        LinkedList<Integer> deque = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int[] res = null;
        for(int i = 0; i < n; i++){
            int value = nums[i];
            while(!deque.isEmpty() && deque.getLast() > value){
                if(deque.size() + n - i == k) {
                    list.addAll(deque);
                    for (; i < n; i++) {
                        list.add(nums[i]);
                    }
                    res = convert(list);
                    return res;
                } else {
                    deque.removeLast();
                }
            }
            deque.add(value);
        }

        res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = deque.removeFirst();
        }

        return res;
    }

    private int[] convert(List<Integer> list){
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
