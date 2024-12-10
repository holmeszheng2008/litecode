package binary_search_tree;

import util.TreeNode;

// 230. Kth Smallest Element in a BST
public class Solution230 {
    private int res = -1;
    private int k = 0;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        traverse(root);

        return res;
    }

    private void traverse(TreeNode root) {
        if (k == 0) {
            return;
        }
        if (root == null) {
            return;
        }
        traverse(root.left);
        k--;
        if (k == 0) {
            res = root.val;
        }
        traverse(root.right);
    }
}
