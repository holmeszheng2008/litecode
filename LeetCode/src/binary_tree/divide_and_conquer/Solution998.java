package binary_tree.divide_and_conquer;

import util.TreeNode;

// 998. Maximum Binary Tree II
public class Solution998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        root.right = insertIntoMaxTree(root.right, val);

        return root;
    }
}
