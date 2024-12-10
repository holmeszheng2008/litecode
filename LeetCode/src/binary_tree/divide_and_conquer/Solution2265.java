package binary_tree.divide_and_conquer;

import util.TreeNode;

// 2265. Count Nodes Equal to Average of Subtree
public class Solution2265 {
    private int res;
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return res;
    }

    // 0 is sum, 1 is number of elements
    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        int[] leftPair = helper(root.left);
        int[] rightPair = helper(root.right);

        int sum = root.val + leftPair[0] + rightPair[0];
        int num = 1 + leftPair[1] + rightPair[1];

        if (sum / num == root.val) {
            res++;
        }
        return new int[] {sum, num};
    }
}
