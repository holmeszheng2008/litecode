package binary_tree.one_time_traverse;

import util.TreeNode;

// 993. Cousins in Binary Tree
public class Solution993 {
    private TreeNode xParent;
    private TreeNode yParent;
    private int xDepth;
    private int yDepth;
    private int x;
    private int y;
    private int depth;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        traverse(root, null);
        if (xDepth == yDepth && xParent != yParent) {
            return true;
        }
        return false;
    }

    private void traverse(TreeNode root, TreeNode parentNode) {
        if (root == null) {
            return;
        }
        depth++;
        if (root.val == x) {
            xParent = parentNode;
            xDepth = depth;
        }
        if (root.val == y) {
            yParent = parentNode;
            yDepth = depth;
        }
        traverse(root.left, root);
        traverse(root.right, root);
        depth--;
    }
}
