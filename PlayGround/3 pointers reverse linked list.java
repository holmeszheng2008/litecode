package leetcode;

public class PlayGround {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.next = null;
        node2.next = node3;
        node3.next = null;

        Node head = reverseList(node1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static class Node {
        public Node(int val) {
            this.val = val;
        }

        public Node next;
        public int val;
    }

    public static Node reverseList(Node head) {
        Node p1 = head;
        Node p2 = head.next;
        if (p2 == null) {
            return head;
        }
        Node p3 = p2.next;
        
        p1.next = null;
        while (p3 != null) {
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        }
        p2.next = p1;
        return p2;
    }
}
