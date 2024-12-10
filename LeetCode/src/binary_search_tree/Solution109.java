package binary_search_tree;

import util.ListNode;
import util.TreeNode;

import java.util.ArrayList;

public class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        for (ListNode i = head; i != null; i = i.next) {
            list.add(i.val);
        }

        return build(list, 0, list.size() - 1);
    }

    private TreeNode build(ArrayList<Integer> list, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = build(list, low, mid - 1);
        node.right = build(list, mid + 1, high);

        return node;
    }
}


class Solution109_attempt1 {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode start, ListNode end){
        if(start == end){
            return null;
        }

        ListNode slow = start, fast = start;
        while(fast != end && fast.next != end){
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }

        TreeNode rootNode = new TreeNode(slow.val);
        rootNode.left = buildTree(start, slow);
        rootNode.right = buildTree(slow.next, end);

        return rootNode;
    }
}