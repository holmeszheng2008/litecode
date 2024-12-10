package array_linked_list.two_pointers;

import util.ListNode;

// 234. Palindrome Linked List
public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode slow = dummyHead, fast = dummyHead;

        boolean isOdd = true;
        while(true){
            slow = slow.next;
            fast = fast.next;
            if(fast == null){
                isOdd = false;
                break;
            }
            fast = fast.next;
            if(fast == null){
                isOdd = true;
                break;
            }
        }

        ListNode dummyHead2 = new ListNode();
        ListNode p = null;
        if(isOdd){
            p = slow.next;
        } else {
            p = slow;
        }
        for(; p != null; ){
            ListNode originalNext = p.next;
            p.next = dummyHead2.next;
            dummyHead2.next = p;

            p = originalNext;
        }

        for(ListNode p1 = head, p2 = dummyHead2.next; p1 != slow; p1 = p1.next, p2 = p2.next){
            if(p1.val != p2.val){
                return false;
            }
        }

        return true;
    }
}
