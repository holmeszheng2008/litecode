package array_linked_list;

import util.ListNode;

// 328. Odd Even Linked List
public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddDummyHead = new ListNode();
        ListNode evenDummyHead = new ListNode();
        ListNode oddTail = oddDummyHead;
        ListNode evenTail = evenDummyHead;

        int i = 1;
        for(ListNode node = head; node != null; node = node.next){
            if(i % 2 == 1) {
                oddTail.next = node;
                oddTail = node;
            } else {
                evenTail.next = node;
                evenTail = node;
            }
            i++;
        }

        evenTail.next = null;
        oddTail.next = evenDummyHead.next;
        return oddDummyHead.next;
    }
}
