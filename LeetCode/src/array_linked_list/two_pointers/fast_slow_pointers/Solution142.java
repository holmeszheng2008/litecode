package array_linked_list.two_pointers.fast_slow_pointers;

import util.ListNode;

// 142. Linked List Cycle II
public class Solution142 {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}


class Solution142_attempt1 {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                break;
            }
        }

        if(fast.next == null || fast.next.next == null){
            return null;
        }

        slow = head;
        while(true){
            if(slow == fast){
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
        }
    }
}