package binary_tree.divide_and_conquer;

import util.TreeNode;

// 1339. Maximum Product of Splitted Binary Tree
public class Solution1339 {
    private long maxProduct = Long.MIN_VALUE;
    private int sum;

    public int maxProduct(TreeNode root) {
        sum = getSum(root);
        getSum2(root);
        return (int) (maxProduct % (1e9 + 7));
    }
    
    private int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getSum(root.left);
        int right = getSum(root.right);

        return root.val + left + right;
    }

    private int getSum2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getSum2(root.left);
        int right = getSum2(root.right);

        maxProduct = Math.max(maxProduct, (long) left * (sum - left));
        maxProduct = Math.max(maxProduct, (long) right * (sum - right));

        return root.val + left + right;
    }
}
