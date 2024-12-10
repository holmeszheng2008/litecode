package array_linked_list;

import util.ListNode;

// 92. Reverse Linked List II
public class Solution92_recursion {

    private ListNode successor = null;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        ListNode nextHead = reverseN(pre.next, right + 1 - left);
        pre.next = nextHead;

        return dummyHead.next;
    }

    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode nextHead = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;

        return nextHead;
    }

}
