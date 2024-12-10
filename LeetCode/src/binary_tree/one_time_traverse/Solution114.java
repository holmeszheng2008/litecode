package binary_tree.one_time_traverse;

import util.TreeNode;

// 114. Flatten Binary Tree to Linked List
public class Solution114 {
    private TreeNode tail = new TreeNode();

    public void flatten(TreeNode root) {
        traverse(root);
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        tail.right = root;
        tail = root;

        traverse(left);
        traverse(right);
    }
}


class Solution114_attempt1 {
    private TreeNode head = new TreeNode();
    private TreeNode tail = head;
    public void flatten(TreeNode root) {
        dfs(root);
    }

    private void dfs(TreeNode node){
        if(node == null){
            return;
        }

        tail.right = node;
        tail = node;

        TreeNode orgLeft = node.left;
        TreeNode orgRight = node.right;

        node.left = null;

        dfs(orgLeft);
        dfs(orgRight);
    }
}