package array_linked_list;

import util.ListNode;

import java.util.PriorityQueue;

// 23. Merge k Sorted Lists
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode();
        ListNode p = dummyHead;
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> (o1.val - o2.val));
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            p = p.next;
            if (node.next != null) {
                pq.add(node.next);
            }
        }

        return dummyHead.next;
    }

    public ListNode mergeKLists_better(ListNode[] lists) {
        ListNode head = new ListNode(0), p = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode o1, ListNode o2) -> o1.val - o2.val);
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.offer(node.next);
            }
            p = p.next;
        }

        return head.next;
    }
    /*
     * 优先队列 pq 中的元素个数最多是 k，所以⼀次 poll 或者 add ⽅法的时间复杂度是 O(logk)；所有的链表 节点都会被加⼊和弹出 pq，所以算法整体的时间复杂度是
     * O(Nlogk)，其中 k 是链表的条数，N 是这些链表 的节点总数。
     */
}

class Solution23_attempt1 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode();
        ListNode p = dummyHead;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for(int i = 0; i < lists.length; i++){
            ListNode list = lists[i];
            if(list != null){
                pq.add(list);
            }
        }

        while(!pq.isEmpty()){
            ListNode list = pq.poll();
            p.next = list;
            p = p.next;

            if(list.next != null){
                pq.offer(list.next);
            }
        }

        return dummyHead.next;
    }
}

class Solution_attempt2 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode(), tail = dummyHead;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null){
                pq.offer(lists[i]);
            }
        }
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            tail.next = node;
            tail = node;
            if(node.next != null){
                pq.offer(node.next);
            }
        }
        tail.next = null;

        return dummyHead.next;
    }
}