package array_linked_list;


import util.ListNode;

import java.util.PriorityQueue;

// 148. Sort List
public class Solution148 {
    public ListNode sortList(ListNode head) {
        ListNode dummyHead = new ListNode(), tail = dummyHead;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> (o1.val - o2.val));

        ListNode p = head;
        while(p != null){
            pq.offer(p);
            p = p.next;
        }

        while(!pq.isEmpty()) {
            tail.next = pq.poll();
            tail = tail.next;
        }

        tail.next = null;

        return dummyHead.next;
    }
}
