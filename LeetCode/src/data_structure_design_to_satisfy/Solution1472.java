package data_structure_design_to_satisfy;

// 1472. Design Browser History
public class Solution1472 {
    class BrowserHistory {
        private class ListNode {
            public String value;
            public ListNode pre;
            public ListNode next;
        }
        private ListNode head = new ListNode();
        private ListNode currentNode;
        public BrowserHistory(String homepage) {
            ListNode newNode = new ListNode();
            newNode.value = homepage;
            newNode.pre = head;
            head.next = newNode;

            currentNode = newNode;
        }

        public void visit(String url) {
            ListNode newNode = new ListNode();
            newNode.pre = currentNode;
            newNode.value = url;
            currentNode.next = newNode;
            currentNode = newNode;
        }

        public String back(int steps) {
            ListNode p = currentNode;
            for(int i = 0; i < steps; i++){
               if(p.pre == head){
                   currentNode = p;

                   return p.value;
               }

               p = p.pre;
            }

            currentNode = p;
            return p.value;
        }

        public String forward(int steps) {
            ListNode p = currentNode;
            for(int i = 0; i < steps; i++){
                if(p.next == null){
                    currentNode = p;

                    return p.value;
                }

                p = p.next;
            }

            currentNode = p;
            return p.value;
        }
    }
}
