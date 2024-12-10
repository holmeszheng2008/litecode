package array_linked_list;

import util.ListNode;

// 203. Remove Linked List Elements
public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        for(ListNode node = head; node != null; ){
            ListNode nextNode = node.next;
            if(node.val != val) {
                node.next = null;
                tail.next = node;
                tail = node;
            }

            node = nextNode;
        }

        return dummyHead.next;
    }
}


class Solution203_divide {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }
        ListNode nextNode = removeElements(head.next, val);
        head.next = nextNode;
        if(head.val == val){
            return head.next;
        } else {
            return head;
        }
    }
}