package binary_search_tree;

import util.TreeNode;

// 538. Convert BST to Greater Tree
public class Solution538 {
    private int preSum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        traverse(root);

        return root;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.right);
        int oldValue = root.val;
        root.val = root.val + preSum;
        preSum = preSum + oldValue;
        traverse(root.left);
    }
}
