package binary_search_tree;

import util.TreeNode;

// 1373. Maximum Sum BST in Binary Tree
public class Solution1373 {
    private static class Pair {
        public boolean isBST;
        public int min;
        public int max;
        public int sum;

        public Pair(boolean isBST, int min, int max, int sum) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    private int maxSum = Integer.MIN_VALUE;

    public int maxSumBST(TreeNode root) {
        check(root);
        return maxSum;
    }

    private Pair check(TreeNode root) {
        if (root == null) {
            return new Pair(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        Pair pairLeft = check(root.left);
        Pair pairRight = check(root.right);
        if (pairLeft.isBST && pairRight.isBST && pairLeft.max < root.val && pairRight.min > root.val) {
            int min = Math.min(pairLeft.min, root.val);
            int max = Math.max(pairRight.max, root.val);
            int sum = pairLeft.sum + pairRight.sum + root.val;
            maxSum = (sum > maxSum) ? sum : maxSum;
            return new Pair(true, min, max, sum);
        } else {
            return new Pair(false, 0, 0, 0);
        }
    }
}
