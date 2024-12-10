package array_linked_list;

import util.ListNode;

// 21. Merge Two Sorted Lists
public class Solution21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode current = head;
        while (!(list1 == null && list2 == null)) {
            if (list1 == null) {
                current.next = list2;
                list2 = null;
            } else if (list2 == null) {
                current.next = list1;
                list1 = null;
            } else {
                if (list1.val < list2.val) {
                    current.next = list1;
                    list1 = list1.next;
                    current = current.next;
                } else {
                    current.next = list2;
                    list2 = list2.next;
                    current = current.next;
                }
            }
        }

        return head.next;
    }

    public ListNode mergeTwoListsDummy(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0), p = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
                p = p.next;
            } else {
                p.next = list2;
                list2 = list2.next;
                p = p.next;
            }
        }
        if (list1 == null) {
            p.next = list2;
        } else {
            p.next = list1;
        }
        return head.next;
    }
}


class Solution21_attempt1 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode p = dummyHead, p1 = list1, p2 = list2;
        while(!(p1 == null && p2 == null)){
            if(p1 == null){
                p.next = p2;
                p = p.next;
                p2 = p2.next;
            } else if (p2 == null){
                p.next = p1;
                p = p.next;
                p1 = p1.next;
            } else {
                int val1 = p1.val;
                int val2 = p2.val;
                if(val1 <= val2){
                    p.next = p1;
                    p = p.next;
                    p1 = p1.next;
                } else {
                    p.next = p2;
                    p = p.next;
                    p2 = p2.next;
                }
            }
        }

        return dummyHead.next;
    }
}