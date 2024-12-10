package binary_tree.divide_and_conquer;

import util.TreeNode;

// 226. Invert Binary Tree
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftInverted = invertTree(root.left);
        TreeNode rightInverted = invertTree(root.right);

        root.left = rightInverted;
        root.right = leftInverted;

        return root;
    }
}

class Solution226_attempt1 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode orgLeft = root.left;
        TreeNode orgRight = root.right;

        root.left = invertTree(orgRight);
        root.right = invertTree(orgLeft);

        return root;
    }
}