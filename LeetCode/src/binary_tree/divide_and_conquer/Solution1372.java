package binary_tree.divide_and_conquer;

import util.TreeNode;

// 1372. Longest ZigZag Path in a Binary Tree
public class Solution1372 {
    private class Pair {
        public int leftDirection;
        public int rightDirection;

        public Pair(int leftDirection, int rightDirection) {
            this.leftDirection = leftDirection;
            this.rightDirection = rightDirection;
        }
    }

    private int res = Integer.MIN_VALUE;

    public int longestZigZag(TreeNode root) {
        getTraverse(root);
        return res;
    }

    private Pair getTraverse(TreeNode root) {
        if (root == null) {
            return new Pair(-1, -1);
        }

        Pair leftPair = getTraverse(root.left);
        Pair rightPair = getTraverse(root.right);

        int goLeft = 1 + leftPair.rightDirection;
        int goRight = 1 + rightPair.leftDirection;


        res = Math.max(res, goLeft);
        res = Math.max(res, goRight);
        return new Pair(goLeft, goRight);
    }
}
