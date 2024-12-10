package array_linked_list.two_pointers.fast_slow_pointers;

import util.ListNode;

// 19. Remove Nth Node From End of List
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return head;
    }
}

class Solution19_attempt1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode dummyHead = new ListNode();
       dummyHead.next = head;
       ListNode preTarget = dummyHead;
       ListNode afterTarget = dummyHead;
       for(int i = 0; i < n+1; i++){
           afterTarget = afterTarget.next;
       }
       while(afterTarget != null){
            preTarget = preTarget.next;
            afterTarget = afterTarget.next;
        }

       preTarget.next = preTarget.next.next;

       return dummyHead.next;
    }
}