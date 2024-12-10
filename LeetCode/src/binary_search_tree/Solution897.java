package binary_search_tree;

import util.TreeNode;

// 897. Increasing Order Search Tree
public class Solution897 {
    private TreeNode dummyHead = new TreeNode();
    private TreeNode tail = dummyHead;
    public TreeNode increasingBST(TreeNode root) {
        traverse(root);
        return dummyHead.right;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        tail.right = root;
        root.left = null;
        tail = root;

        traverse(root.right);
    }
}
