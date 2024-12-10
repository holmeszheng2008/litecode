package binary_tree.divide_and_conquer;

import util.TreeNode;

public class Solution124 {
    private int maxRes = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        oneDirectMaxPathSum(root);
        return maxRes;
    }

    private int oneDirectMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = oneDirectMaxPathSum(root.left);
        int maxRight = oneDirectMaxPathSum(root.right);

        maxLeft = Math.max(maxLeft, 0);
        maxRight = Math.max(maxRight, 0);

        int maxOneDirect = Math.max(maxLeft, maxRight) + root.val;
        int maxThrough = root.val + maxLeft + maxRight;

        maxRes = Math.max(maxRes, maxThrough);

        return maxOneDirect;
    }
}
