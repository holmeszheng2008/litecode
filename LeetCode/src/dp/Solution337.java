package dp;

import util.TreeNode;

public class Solution337 {
    public int rob(TreeNode root) {
        int[] res = takeOrNot(root);

        return Math.max(res[0], res[1]);
    }

    public int[] takeOrNot(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        int[] left = takeOrNot(root.left);
        int[] right = takeOrNot(root.right);

        int take = root.val + left[0] + right[0];
        int notTake = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[] {notTake, take};
    }
}
