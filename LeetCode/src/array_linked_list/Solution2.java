package array_linked_list;

import util.ListNode;

// 2. Add Two Numbers
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode p = dummyHead;
        int carry = 0;
        while(!(l1 == null && l2 == null)){
            int val = carry;
            if(l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                val += l2.val;
                l2 = l2.next;
            }
            carry = val / 10;
            val = val % 10;
            p.next = new ListNode(val);
            p = p.next;
        }
        if(carry != 0){
            p.next = new ListNode(carry);
        }

        return dummyHead.next;
    }
}
