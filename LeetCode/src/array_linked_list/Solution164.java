package array_linked_list;

import java.util.PriorityQueue;

// 164. Maximum Gap

// O(nlogn)
public class Solution164 {
    public int maximumGap(int[] nums) {
        if(nums.length == 1){
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.offer(num);
        }

        int maxGap = Integer.MIN_VALUE;
        int previous = pq.poll();
        while(!pq.isEmpty()){
            int next = pq.poll();
            maxGap = Math.max(maxGap, next - previous);
            previous = next;
        }

        return maxGap;
    }
}

// O(n)
class Solution_bucket {
    public int maximumGap(int[] nums) {
        if(nums.length == 1){
            return 0;
        }

        int maxNum = Integer.MIN_VALUE, minNum = Integer.MAX_VALUE;

        for(int num : nums){
            maxNum = Math.max(maxNum, num);
            minNum = Math.min(minNum, num);
        }

        int bucketNum = nums.length;
        int bucketSize = (maxNum - minNum + nums.length - 2) / (nums.length - 1);
        if(bucketSize == 0){
            return 0;
        }

        int[][] buckets = new int[bucketNum][2];
        for(int i = 0; i < bucketNum; i++){
            buckets[i][0] = Integer.MAX_VALUE;
            buckets[i][1] = Integer.MIN_VALUE;
        }

        for(int num : nums){
            int index = (num - minNum) / bucketSize;
            buckets[index][0] = Math.min(buckets[index][0], num);
            buckets[index][1] = Math.max(buckets[index][1], num);
        }

        int maxGap = Integer.MIN_VALUE;
        int previousBucketIndex = 0;
        for(int i = 0; i < bucketNum; i++){
            if(buckets[i][0] != Integer.MAX_VALUE) {
                previousBucketIndex = i;
                break;
            }
        }
        for(int i = previousBucketIndex + 1; i < bucketNum; i++){
            if(buckets[i][0] != Integer.MAX_VALUE){
                maxGap = Math.max(maxGap, buckets[i][0] - buckets[previousBucketIndex][1]);
                previousBucketIndex = i;
            }
        }


        return maxGap;
    }
}
