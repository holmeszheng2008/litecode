package binary_tree.divide_and_conquer;

import util.TreeNode;

// 101. Symmetric Tree
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        return (p.val == q.val) && isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }
}

class Solution101_attempt1 {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.val == root2.val){
            return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
        }

        return false;
    }
}