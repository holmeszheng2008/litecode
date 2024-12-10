package binary_tree.divide_and_conquer;

import util.TreeNode;

// 687. Longest Univalue Path
public class Solution687 {
    private int res;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        oneSideLongest(root, 0);
        return res;
    }

    private int oneSideLongest(TreeNode root, int parentValue) {
        if (root == null) {
            return 0;
        }
        int left = oneSideLongest(root.left, root.val);
        int right = oneSideLongest(root.right, root.val);

        res = Math.max(res, left + right);
        if (root.val != parentValue) {
            return 0;
        }

        return 1 + Math.max(left, right);
    }
}
