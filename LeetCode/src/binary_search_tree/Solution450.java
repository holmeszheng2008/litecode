package binary_search_tree;

import util.TreeNode;

// 450. Delete Node in a BST
public class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            return doDelete(root);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    private TreeNode doDelete(TreeNode root) {
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        TreeNode rightMin = getMin(root.right);
        root.right = deleteNode(root.right, rightMin.val);
        rightMin.left = root.left;
        rightMin.right = root.right;

        return rightMin;
    }

    private TreeNode getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }
}
