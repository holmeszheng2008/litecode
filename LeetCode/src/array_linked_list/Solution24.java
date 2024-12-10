package array_linked_list;

import util.ListNode;

// 24. Swap Nodes in Pairs
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode();
        ListNode firstNode = null;
        ListNode secondNode = null;
        ListNode p = dummyHead;
        for(ListNode node = head; node != null;) {
            if(firstNode == null){
                firstNode = node;
                node = node.next;
            } else {
                secondNode = node;
                node = node.next;
                secondNode.next = firstNode;
                p.next = secondNode;
                p = firstNode;
                p.next = null;

                firstNode = null;
                secondNode = null;
            }
        }

        if(firstNode != null && secondNode == null){
            p.next = firstNode;
        }

        return dummyHead.next;
    }
}

class Solution24_attempt1 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode();
        ListNode p = dummyHead;
        ListNode tempHead = null;
        ListNode tempTail = null;
        int i = 0;
        while(head != null){
            if(i % 2 == 0) {
                tempHead = head;
                tempTail = head;

                head = head.next;
                i++;
            } else {
                ListNode temp = head.next;

                head.next = tempHead;
                tempHead= head;

                p.next = tempHead;
                p = tempTail;
                p.next = null;

                head = temp;
                i++;
            }
        }

        if(i % 2 != 0){
            p.next = tempHead;
            tempTail.next = null;
        }

        return dummyHead.next;
    }
}