package binary_tree.one_time_traverse;

import util.TreeNode;

// 572. Subtree of Another Tree
public class Solution572 {
    private boolean res = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        traverse(root, subRoot);
        return res;
    }

    private void traverse(TreeNode root, TreeNode subRoot) {
        if (res) {
            return;
        }
        if (root == null) {
            return;
        }
        res = isSame(root, subRoot);
        traverse(root.left, subRoot);
        traverse(root.right, subRoot);
    }

    private boolean isSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }

        return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
    }
}
