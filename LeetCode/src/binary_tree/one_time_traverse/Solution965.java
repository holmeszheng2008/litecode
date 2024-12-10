package binary_tree.one_time_traverse;

import util.TreeNode;

// 965. Univalued Binary Tree
public class Solution965 {
    private boolean res = true;

    private Integer firstVal = null;

    public boolean isUnivalTree(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (!res) {
            return;
        }
        if (firstVal == null) {
            firstVal = root.val;
        } else {
            if (firstVal != root.val) {
                res = false;
            }
        }

        traverse(root.left);
        traverse(root.right);
    }
}
