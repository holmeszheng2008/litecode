package array_linked_list;

import java.util.PriorityQueue;

// 313. Super Ugly Number
public class Solution313 {
    private static class ValueTriple implements Comparable<ValueTriple>{
        public int curIndex;

        public int multiplier;

        public long value;

        @Override
        public int compareTo(ValueTriple o) {
            return (value <= o.value) ? -1 : 1;
        }

        public ValueTriple(int curIndex, int multiplier, long value) {
            this.curIndex = curIndex;
            this.multiplier = multiplier;
            this.value = value;
        }
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n+1];
        PriorityQueue<ValueTriple> pq = new PriorityQueue<>();
        for(int i = 0; i < primes.length; i++){
            pq.add(new ValueTriple(2, primes[i], primes[i]));
        }
        for(int i = 2; i <= n; i++){
            ValueTriple valueTriple = pq.poll();
            long value = valueTriple.value;
            dp[i] = (int)value;
            pq.add(new ValueTriple(valueTriple.curIndex + 1, valueTriple.multiplier, (long)valueTriple.multiplier * dp[valueTriple.curIndex]));

            while(pq.peek().value == value){
                ValueTriple sameValueTriple = pq.poll();
                pq.add(new ValueTriple(sameValueTriple.curIndex + 1, sameValueTriple.multiplier, (long)sameValueTriple.multiplier * dp[sameValueTriple.curIndex]));
            }
        }

        return dp[n];
    }
}
