package array_linked_list.two_pointers.fast_slow_pointers;

import util.ListNode;

// 160. Intersection of Two Linked Lists
public class Solution160 {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int l1 = 0, l2 = 0;
            ListNode p1 = headA, p2 = headB;
            while (p1 != null) {
                l1++;
                p1 = p1.next;
            }
            p1 = headB;
            while (p1 != null) {
                l2++;
                p1 = p1.next;
            }
            p1 = headA;
            if (l1 > l2) {
                for (int i = 0; i < l1 - l2; i++) {
                    p1 = p1.next;
                }
            } else if (l2 > l1) {
                for (int i = 0; i < l2 - l1; i++) {
                    p2 = p2.next;
                }
            }
            while (p1 != null) {
                if (p1 == p2) {
                    return p1;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
            return null;
        }

        public ListNode getIntersectionNode_better(ListNode headA, ListNode headB) {
            ListNode p1 = headA, p2 = headB;
            boolean p1Null = false, p2Null = false;
            while (p1 != p2) {
                p1 = p1.next;
                p2 = p2.next;
                if (p1 == null && !p1Null) {
                    p1Null = true;
                    p1 = headB;
                }
                if (p2 == null && !p2Null) {
                    p2Null = true;
                    p2 = headA;
                }
            }
            return p1;
        }
    }
}
