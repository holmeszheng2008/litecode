package array_linked_list;

import util.ListNode;

// 206. Reverse Linked List
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head, p2 = p1.next, p3 = p2.next;
        p1.next = null;
        while (true) {
            p2.next = p1;
            if (p3 == null) {
                break;
            }
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        }

        return p2;
    }
}


class Solution206_attempt1 {
    public ListNode reverseList(ListNode head) {
        ListNode dummyHead = new ListNode();
        ListNode p = head;

        while(p != null){
            ListNode orgPNext = p.next;
            p.next = dummyHead.next;
            dummyHead.next = p;
            p = orgPNext;
        }

        return dummyHead.next;
    }
}


class Solution206_attempt2 {
    private ListNode overallHead = null;
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        doReverseList(head);

        return overallHead;
    }

    private ListNode doReverseList(ListNode head){
        if(head.next == null){
            overallHead = head;
            return head;
        }

        ListNode tail = doReverseList(head.next);
        tail.next = head;
        head.next = null;

        return head;
    }
}

class Solution206_attempt4 {
    private ListNode dummyHead = new ListNode();
    private ListNode tail = dummyHead;
    public ListNode reverseList(ListNode head) {
        dfs(head);
        return dummyHead.next;
    }

    private void dfs(ListNode head){
        if(head == null){
            return;
        }
        dfs(head.next);

        head.next = null;
        tail.next = head;
        tail = head;
    }
}