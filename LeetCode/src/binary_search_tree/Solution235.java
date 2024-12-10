package binary_search_tree;

import util.TreeNode;

// 235. Lowest Common Ancestor of a Binary Search Tree
public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int smaller = Math.min(p.val, q.val);
        int bigger = Math.max(p.val, q.val);
        return lowestCommonAncestor(root, smaller, bigger);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, int smaller, int bigger) {
        if (root.val >= smaller && root.val <= bigger) {
            return root;
        }
        if (root.val < smaller) {
            return lowestCommonAncestor(root.right, smaller, bigger);
        }
        if (root.val > bigger) {
            return lowestCommonAncestor(root.left, smaller, bigger);
        }

        return null;
    }
}
