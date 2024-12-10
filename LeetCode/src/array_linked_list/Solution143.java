package array_linked_list;

import util.ListNode;

// 143. Reorder List
public class Solution143 {
    public void reorderList(ListNode head) {
        if(head.next == null || head.next.next == null){
            return;
        }

        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode dummyFastHead = new ListNode();
        ListNode tempTail = dummyFastHead.next, fastHead = slow.next, p = fastHead;

        while(p != null){
            ListNode orgNext = p.next;
            dummyFastHead.next = p;
            p.next = tempTail;
            tempTail = p;
            p = orgNext;
        }

        fastHead = dummyFastHead.next;
        slow.next = null;

        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;

        ListNode p1 = head, p2 = fastHead;
        while(p1 != null){
            ListNode orgP1Next = p1.next;
            tail.next = p1;
            p1.next = p2;

            tail = p2;

            if(p2 == null){
                break;
            }
            p1 = orgP1Next;
            p2 = p2.next;
        }

        head = dummyHead.next;
    }
}
