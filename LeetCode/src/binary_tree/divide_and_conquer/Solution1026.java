package binary_tree.divide_and_conquer;

import util.TreeNode;

// 1026. Maximum Difference Between Node and Ancestor
public class Solution1026 {
    private class Pair {
        public int min;
        public int max;

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    private int maxDiff = Integer.MIN_VALUE;

    public int maxAncestorDiff(TreeNode root) {
        getPair(root);
        return maxDiff;
    }

    private Pair getPair(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new Pair(root.val, root.val);
        }
        if (root.left != null && root.right == null) {
            Pair leftPair = getPair(root.left);
            int min = Math.min(root.val, leftPair.min);
            int max = Math.max(root.val, leftPair.max);
            maxDiff = Math.max(maxDiff, Math.max(Math.abs(root.val - leftPair.min), Math.abs(root.val - leftPair.max)));
            return new Pair(min, max);
        }
        if (root.left == null && root.right != null) {
            Pair rightPair = getPair(root.right);
            int min = Math.min(root.val, rightPair.min);
            int max = Math.max(root.val, rightPair.max);
            maxDiff = Math.max(maxDiff, Math.max(Math.abs(root.val - rightPair.min), Math.abs(root.val - rightPair.max)));
            return new Pair(min, max);
        }
        Pair leftPair = getPair(root.left);
        Pair rightPair = getPair(root.right);
        int childMin = Math.min(leftPair.min, rightPair.min);
        int childMax = Math.max(leftPair.max, rightPair.max);
        int min = Math.min(root.val, childMin);
        int max = Math.max(root.val, childMax);
        maxDiff = Math.max(maxDiff, Math.max(Math.abs(root.val - childMin), Math.abs(root.val - childMax)));

        return new Pair(min, max);
    }
}
