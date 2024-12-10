package binary_tree.divide_and_conquer;

import util.TreeNode;

// 563. Binary Tree Tilt
public class Solution563 {
    private int tiltSum;

    public int findTilt(TreeNode root) {
        getSum(root);

        return tiltSum;
    }

    private int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);

        tiltSum += Math.abs(rightSum - leftSum);

        return root.val + leftSum + rightSum;
    }
}
