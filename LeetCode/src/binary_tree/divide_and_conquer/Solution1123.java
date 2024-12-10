package binary_tree.divide_and_conquer;

import util.TreeNode;

// 1123. Lowest Common Ancestor of Deepest Leaves
// Divide
public class Solution1123 {

    private TreeNode lca;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int depth = getDepth(root);
        divide(root, depth);

        return lca;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);

        return 1 + Math.max(left, right);
    }

    private int divide(TreeNode root, int depth) {
        if (root == null) {
            return 0;
        }

        int left = divide(root.left, depth - 1);
        int right = divide(root.right, depth - 1);
        if (left == right && left + 1 == depth) {
            lca = root;
        }

        return 1 + Math.max(left, right);
    }

}

// Divide
class Solution1123_attempt1 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int maxDepth = getMaxDepth(root);

        return divide(root, maxDepth);
    }

    private TreeNode divide(TreeNode root, int depth){
        if(root == null){
            return null;
        }
        if(depth == 1){
            return root;
        }

        TreeNode leftLca = divide(root.left, depth - 1);
        TreeNode rightLca = divide(root.right, depth - 1);

        if(leftLca != null) {
            if (rightLca != null) {
                return root;
            } else {
                return leftLca;
            }
        } else {
            return rightLca;
        }
    }

    private int getMaxDepth(TreeNode root){
        if(root == null) {
            return 0;
        }

        int left = getMaxDepth(root.left);
        int right = getMaxDepth(root.right);

        return 1 + Math.max(left, right);
    }
}
