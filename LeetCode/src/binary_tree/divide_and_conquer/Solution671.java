package binary_tree.divide_and_conquer;

import util.TreeNode;

// 671. Second Minimum Node In a Binary Tree
public class Solution671 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root.left == null) {
            return -1;
        }
        if (root.left.val == root.val && root.right.val == root.val) {
            int leftSecond = findSecondMinimumValue(root.left);
            int rightSecond = findSecondMinimumValue(root.right);
            if (leftSecond == -1) {
                return rightSecond;
            }
            if (rightSecond == -1) {
                return leftSecond;
            }
            return Math.min(leftSecond, rightSecond);
        }
        if (root.left.val == root.val) {
            int leftSecond = findSecondMinimumValue(root.left);
            if (leftSecond == -1) {
                return root.right.val;
            }
            return Math.min(leftSecond, root.right.val);
        }
        if (root.right.val == root.val) {
            int rightSecond = findSecondMinimumValue(root.right);
            if (rightSecond == -1) {
                return root.left.val;
            }
            return Math.min(rightSecond, root.left.val);
        }
        
        return -1;
    }
}
