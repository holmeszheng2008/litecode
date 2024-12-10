package binary_tree.divide_and_conquer;

import util.TreeNode;

// 1038. Binary Search Tree to Greater Sum Tree
public class Solution1038 {
    private int preSum = 0;
    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.right);
        preSum += root.val;
        root.val = preSum;
        traverse(root.left);
    }
}
