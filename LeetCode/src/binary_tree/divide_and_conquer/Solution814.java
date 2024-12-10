package binary_tree.divide_and_conquer;

import util.TreeNode;

// 814. Binary Tree Pruning
class Solution814 {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode left = pruneTree(root.left);
        TreeNode right = pruneTree(root.right);

        if(root.val == 0 && left == null && right == null){
            return null;
        }

        root.left = left;
        root.right = right;

        return root;
    }
}
