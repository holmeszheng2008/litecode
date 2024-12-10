package array_linked_list.two_pointers.fast_slow_pointers;

import util.ListNode;

// 82. Remove Duplicates from Sorted List II
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead, p = head;

        while(p != null){
            if(p.next == null) {
                tail.next = p;
                tail = tail.next;
                p = p.next;
            } else {
                if(p.val == p.next.val) {
                    int value = p.val;
                    p = p.next;
                    while (p != null && p.val == value) {
                        p = p.next;
                    }
                } else {
                    tail.next = p;
                    tail = tail.next;
                    p = p.next;
                }
            }
        }

        tail.next = null;
        return dummyHead.next;
    }
}
