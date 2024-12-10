package binary_search_tree;

import util.TreeNode;

// 783. Minimum Distance Between BST Nodes
public class Solution783 {
    private int minDiff = Integer.MAX_VALUE;
    private Integer pre;

    public int minDiffInBST(TreeNode root) {
        traverse(root);
        return minDiff;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);
        if (pre != null) {
            int diff = Math.abs(root.val - pre);
            minDiff = Math.min(minDiff, diff);
        }
        pre = root.val;
        traverse(root.right);
    }
}


class Solution783_attempt1 {
    private int pre = -1;
    private int minDiff = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return minDiff;
    }

    private void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.left);
        if(pre != -1){
            minDiff = Math.min(minDiff, Math.abs(node.val - pre));
        }
        pre = node.val;

        dfs(node.right);
    }
}