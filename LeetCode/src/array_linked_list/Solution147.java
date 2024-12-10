package array_linked_list;

import util.ListNode;

// 147. Insertion Sort List
public class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode p = head, tail = dummyHead;
        while(p != null){
            ListNode orgPNext = p.next;
            ListNode p1 = dummyHead;
            ListNode p2 = p1.next;
            while(p1 != tail){
                if(p1.val <= p.val && (p2 == null || p.val <= p2.val)){
                    break;
                }
                p1 = p1.next;
                p2 = p1.next;
            }

            p1.next = p;
            p.next = p2;
            if(p1 == tail){
                tail = p;
            }

            p = orgPNext;
        }

        return dummyHead.next;
    }
}
