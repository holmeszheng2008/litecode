package binary_tree.divide_and_conquer;

import util.TreeNode;

// 1325. Delete Leaves With a Given Value
public class Solution1325 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        TreeNode left = removeLeafNodes(root.left, target);
        TreeNode right = removeLeafNodes(root.right, target);

        root.left = left;
        root.right = right;

        if (root.val == target && left == null && right == null) {
            return null;
        }

        return root;
    }
}
