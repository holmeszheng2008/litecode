package array_linked_list;

import util.ListNode;

// 61. Rotate List
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        int size = 0;
        for(ListNode p = head; p != null; p = p.next){
            size++;
        }

        int mk = k % size;

        if (mk == 0){
            return head;
        }
        int moves = size - 1 - mk;
        ListNode preNew = head;
        for(int move = 0; move < moves; move++){
            preNew = preNew.next;
        }

        ListNode newHead = preNew.next;
        preNew.next = null;

        for(ListNode p = newHead; ;p = p.next) {
            if(p.next == null){
                p.next = head;
                break;
            }
        }

        return newHead;
    }
}

class Solution61_attempt1 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        int size = 0;
        ListNode lastNode = null;
        for(ListNode p = head; p != null; p = p.next){
            size++;
            if(p.next == null){
                lastNode = p;
            }
        }
        k = k % size;
        if(k == 0){
            return head;
        }

        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode preNode = dummyHead;

        for(int i = 0; i < size - k; i++){
            preNode = preNode.next;
        }

        dummyHead.next = preNode.next;
        preNode.next = null;
        lastNode.next = head;

        return dummyHead.next;
    }
}