package array_linked_list;

import util.ListNode;

// 86. Partition List
public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead = new ListNode();
        ListNode firstTail = dummyHead, secondTail = dummyHead;
        ListNode p = head;

        while(p != null){
            if(p.val < x) {
                ListNode originalNextP = p.next;
                ListNode orgFirstTailNext = firstTail.next;
                firstTail.next = p;
                p.next = orgFirstTailNext;
                if (secondTail == firstTail) {
                    secondTail = p;
                }
                firstTail = p;

                p = originalNextP;
            } else {
                ListNode originalNextP = p.next;
                secondTail.next = p;
                p.next = null;
                secondTail = p;

                p = originalNextP;
            }
        }

        secondTail.next = null;

        return dummyHead.next;
    }
}

// two lists
class Solution86_anotherWay {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode();
        ListNode dummyHead2 = new ListNode();
        ListNode tail1 = dummyHead1, tail2 = dummyHead2, p = head;

        while(p != null){
            if(p.val < x){
                tail1.next = p;
                tail1 = p;
                p = p.next;
            } else {
                tail2.next = p;
                tail2 = p;
                p = p.next;
            }
        }

        tail2.next = null;
        tail1.next = dummyHead2.next;

        return dummyHead1.next;
    }
}
