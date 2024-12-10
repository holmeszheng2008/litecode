package binary_tree.one_time_traverse;

import util.TreeNode;

// 1022. Sum of Root To Leaf Binary Numbers
public class Solution1022 {
    private int sum;
    private int path;
    public int sumRootToLeaf(TreeNode root) {
        traverse(root);

        return sum;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        path = path * 2 + root.val;
        if (root.left == null && root.right == null) {
            sum += path;
        }
        traverse(root.left);
        traverse(root.right);
        path = (path - root.val) / 2;
    }
}
