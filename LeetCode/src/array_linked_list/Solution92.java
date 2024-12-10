package array_linked_list;

import util.ListNode;

// 92. Reverse Linked List II
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode preFirst = dummyHead;
        ListNode end = dummyHead;
        for (int i = 0; i < left-1; i++) {
            preFirst = preFirst.next;
        }
        ListNode first = preFirst.next;
        ListNode p1 = first;
        for (int i = 0; i <= right; i++) {
            end = end.next;
        }
        ListNode p2 = p1.next;
        ListNode p3 = p2.next;
        while (p3 != end) {
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        }

        p2.next = p1;

        preFirst.next = p2;
        first.next = end;

        return dummyHead.next;
    }
}

class Solution92_attempt1 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }

        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode preStart = dummyHead;
        for(int i = 0; i < left - 1; i++){
            preStart = preStart.next;
        }


        ListNode tail = null, p = preStart.next;
        for(int i = left; i <= right; i++){
            if(tail == null){
                tail = p;
            }
            ListNode orgPNext = p.next;
            p.next = preStart.next;
            preStart.next = p;
            p = orgPNext;
        }

        tail.next = p;

        return dummyHead.next;
    }
}