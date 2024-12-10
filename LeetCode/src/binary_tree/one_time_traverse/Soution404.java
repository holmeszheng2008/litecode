package binary_tree.one_time_traverse;

import util.TreeNode;

// 404. Sum of Left Leaves
public class Soution404 {
    private int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        traverse(root);
        return sum;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            sum += root.left.val;
        }
        traverse(root.left);
        traverse(root.right);
    }
}
