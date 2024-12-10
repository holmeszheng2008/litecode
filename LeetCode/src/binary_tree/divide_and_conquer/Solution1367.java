package binary_tree.divide_and_conquer;

import util.ListNode;
import util.TreeNode;

// 1367. Linked List in Binary Tree
public class Solution1367 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return helper(head, root, false);
    }

    // restrict = true means that the root val must equal to head val
    private boolean helper(ListNode head, TreeNode root, boolean restrict) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }

        if (restrict) {
            if (head.val == root.val) {
                return helper(head.next, root.left, true) || helper(head.next, root.right, true);
            } else {
                return false;
            }
        } else {
            if (head.val == root.val) {
                return helper(head.next, root.left, true) || helper(head.next, root.right, true)
                        || helper(head, root.left, false) || helper(head, root.right, false);
            } else {
                return helper(head, root.left, false) || helper(head, root.right, false);
            }
        }
    }
}
