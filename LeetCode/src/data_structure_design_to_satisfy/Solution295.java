package data_structure_design_to_satisfy;

import java.util.PriorityQueue;

// 295. Find Median from Data Stream
public class Solution295 {
    class MedianFinder {
        // upperPQ is min heap
        PriorityQueue<Integer> upperPQ = new PriorityQueue<>();

        // lowerPQ is max heap
        PriorityQueue<Integer> lowerPQ = new PriorityQueue<>((Integer a, Integer b) -> {
            return b - a;
        });

        public MedianFinder() {

        }

        public void addNum(int num) {
            if (upperPQ.size() >= lowerPQ.size()) {
                upperPQ.add(num);
                lowerPQ.add(upperPQ.poll());
            } else {
                lowerPQ.add(num);
                upperPQ.add(lowerPQ.poll());
            }
        }

        public double findMedian() {
            if (upperPQ.size() > lowerPQ.size()) {
                return upperPQ.peek();
            } else if (upperPQ.size() < lowerPQ.size()) {
                return lowerPQ.peek();
            } else {
                return (upperPQ.peek() + lowerPQ.peek()) / 2.0;
            }
        }
    }

}
