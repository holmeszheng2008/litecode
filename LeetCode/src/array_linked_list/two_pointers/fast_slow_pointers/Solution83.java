package array_linked_list.two_pointers.fast_slow_pointers;

import util.ListNode;

// 83. Remove Duplicates from Sorted List
public class Solution83 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode slow = head, fast = head;
        if (head == null) {
            return null;
        }
        while (fast != null){
            int pre = fast.val;
            if (slow != fast) {
                slow.next = fast;
            }
            slow = fast;
            fast = fast.next;
            while(fast!=null && fast.val == pre) {
                fast = fast.next;
            }
        }
        slow.next = null;

        return head;
    }
}


class Solution83_attempt1 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                // nums[slow] = nums[fast];
                slow.next = fast;
                // slow++;
                slow = slow.next;
            }
            // fast++
            fast = fast.next;
        }
        // 断开与后面重复元素的连接
        slow.next = null;
        return head;
    }
}

class Solution83_attempt2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead, p = head;
        int pre = Integer.MIN_VALUE;
        while(p != null){
            if(p.val == pre){
                p = p.next;
                continue;
            }

            pre = p.val;
            tail.next = p;
            tail = tail.next;
            p = p.next;
        }

        tail.next = null;
        return dummyHead.next;
    }
}