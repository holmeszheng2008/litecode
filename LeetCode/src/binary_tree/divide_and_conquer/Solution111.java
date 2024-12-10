package binary_tree.divide_and_conquer;

import util.TreeNode;

// 111. Minimum Depth of Binary Tree
public class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMin = minDepth(root.left);
        int rightMin = minDepth(root.right);
        if (leftMin == 0) {
            return 1 + rightMin;
        }
        if (rightMin == 0) {
            return 1 + leftMin;
        }
        return 1 + Math.min(leftMin, rightMin);
    }
}
