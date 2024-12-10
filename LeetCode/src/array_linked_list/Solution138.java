package array_linked_list;

import java.util.HashMap;
import java.util.Map;

// 138. Copy List with Random Pointer
public class Solution138 {
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        if(head == null){
            return null;
        }

        Node dummyHead = new Node(1);
        Node tail = dummyHead;
        Node p2 = head;
        while(p2 != null){
            Node newNode = new Node(p2.val);
            map.put(p2, newNode);
            tail.next = newNode;
            tail = tail.next;
            p2 = p2.next;
        }

        Node newHead = dummyHead.next, p1 = newHead;
        p2 = head;
        while(p1 != null){
            Node orgRandom = p2.random;
            if(orgRandom == null){
                p1.random = null;
            } else {
                p1.random = map.get(orgRandom);
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return newHead;
    }
}
