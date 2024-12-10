package array_linked_list;

import util.ListNode;

// 445. Add Two Numbers II
// Avoid reversing input lists
public class Solution445 {
    private ListNode dummyHead = new ListNode();
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int m = 0, n = 0;
        for(ListNode node = l1; node != null; node = node.next){
            m++;
        }
        for(ListNode node = l2; node != null; node = node.next){
            n++;
        }
        int carry = 0;
        if(m >= n){
            carry = doAdd(l1, m, l2, n);
        } else {
            carry = doAdd(l2, n, l1, m);
        }

        if(carry != 0){
            ListNode node = new ListNode(carry);
            node.next = dummyHead.next;
            dummyHead.next = node;
        }

        return dummyHead.next;
    }

    private int doAdd(ListNode l1, int m, ListNode l2, int n) {
        if(m == 0 && n == 0){
            return 0;
        }
        if(m != n){
            int carry = doAdd(l1.next, m-1, l2, n);

            int value = l1.val + carry;
            ListNode node = new ListNode(value % 10);

            node.next = dummyHead.next;
            dummyHead.next = node;

            return value / 10;
        } else {
            int carry = doAdd(l1.next, m-1, l2.next, n-1);
            int value = l1.val + l2.val + carry;

            ListNode node = new ListNode(value % 10);
            node.next = dummyHead.next;
            dummyHead.next = node;

            return value / 10;
        }
    }
}

// By reversing input lists
class Solution445_attempt1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead1 = new ListNode();
        ListNode dummyHead2 = new ListNode();

        int m = 0, n = 0;
        for(ListNode node = l1; node != null; ){
            ListNode nextNode = node.next;
            node.next = dummyHead1.next;
            dummyHead1.next = node;

            node = nextNode;
            m++;
        }
        for(ListNode node = l2; node != null; ){
            ListNode nextNode = node.next;
            node.next = dummyHead2.next;
            dummyHead2.next = node;

            node = nextNode;
            n++;
        }

        if(m >= n){
            return doAdd(dummyHead1.next, dummyHead2.next);
        } else {
            return doAdd(dummyHead2.next, dummyHead1.next);
        }
    }

    private ListNode doAdd(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummyHead = new ListNode();
        while(l2 != null){
            int value = l1.val + l2.val + carry;
            ListNode node = new ListNode(value % 10);
            carry = value / 10;

            node.next = dummyHead.next;
            dummyHead.next = node;

            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int value = l1.val + carry;
            ListNode node = new ListNode(value % 10);
            carry = value / 10;

            node.next = dummyHead.next;
            dummyHead.next = node;

            l1 = l1.next;
        }

        if(carry != 0){
            ListNode node = new ListNode(carry);

            node.next = dummyHead.next;
            dummyHead.next = node;
        }

        return dummyHead.next;
    }
}