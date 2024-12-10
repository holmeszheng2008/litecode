package binary_tree.divide_and_conquer;

import util.TreeNode;

// 606. Construct String from Binary Tree
public class Solution606 {
    public String tree2str(TreeNode root) {
        String str = helper(root);
        return str.substring(1, str.length() - 1);
    }

    private String helper(TreeNode root) {
        if (root == null) {
            return "";
        }
        String left = null;
        if (root.left == null && root.right != null) {
            left = "()";
        } else {
            left = helper(root.left);
        }
        String right = helper(root.right);

        return "(" + root.val + left + right + ")";
    }

}
