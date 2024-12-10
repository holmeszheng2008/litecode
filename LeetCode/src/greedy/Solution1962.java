package greedy;

import java.util.PriorityQueue;

// 1962. Remove Stones to Minimize the Total
public class Solution1962 {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int pile : piles){
            pq.offer(pile);
        }
        for(int i = 0; i < k; i++){
            int head = pq.poll();
            pq.offer(head - head/2);
        }

        int res = 0;
        while(!pq.isEmpty()) {
            res += pq.poll();
        }

        return res;
    }
}

class Solution1962_attempt1 {
    private int piles[];
    private int size;
    public int minStoneSum(int[] piles, int k) {
        this.piles = piles;
        this.size = piles.length;

        buildHeap();
        for(int i = 0; i < k; i++){
            int head = poll();
            offer(head - head/2);
        }

        int res = 0;
        for(int num : piles){
            res += num;
        }
        return res;
    }

    private void sink(int i, int n){
        while(true){
            if(2 * i + 1 > n){
                break;
            }
            int targetIndex = 0;
            if(2*i + 2 > n){
                targetIndex = 2 * i + 1;
            } else {
                if(piles[2 * i + 1] > piles[2 * i + 2]) {
                    targetIndex = 2 * i + 1;
                } else {
                    targetIndex = 2 * i  + 2;
                }
            }

            if(piles[i] >= piles[targetIndex]){
                break;
            }
            int temp = piles[i];
            piles[i] = piles[targetIndex];
            piles[targetIndex] = temp;

            i = targetIndex;
        }
    }
    private void swim(int i){
        int parent = (i-1) / 2;
        while(true){
            if(i == 0){
                break;
            }
            if(piles[i] > piles[parent]) {
                int temp = piles[i];
                piles[i] = piles[parent];
                piles[parent] = temp;
                i = parent;
            } else {
                break;
            }
        }
    }
    private int poll(){
        int top = piles[0];
        int end = piles[size -1];

        piles[0] = end;
        size--;

        sink(0, size-1);

        return top;
    }
    private void offer(int num){
        size++;
        piles[size-1] = num;
        swim(size - 1);
    }
    private void buildHeap(){
        for(int i = (piles.length-2) / 2; i >=0; i--){
            sink(i, size - 1);
        }
    }

}
