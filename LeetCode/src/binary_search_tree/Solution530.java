package binary_search_tree;

import util.TreeNode;

// 530. Minimum Absolute Difference in BST
public class Solution530 {
    private int minAbs = Integer.MAX_VALUE;
    private Integer pre;
    public int getMinimumDifference(TreeNode root) {
        traverse(root);

        return minAbs;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (pre != null) {
            minAbs = Math.min(minAbs, Math.abs(root.val - pre));
        }
        pre = root.val;
        traverse(root.left);
        traverse(root.right);
    }
}
