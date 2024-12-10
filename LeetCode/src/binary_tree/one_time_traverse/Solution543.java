package binary_tree.one_time_traverse;

import util.TreeNode;

// 543. Diameter of Binary Tree
public class Solution543 {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int diameter = leftDepth + rightDepth;
        this.maxDiameter = Math.max(this.maxDiameter, diameter);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}


class Solution543_attempt1 {
    private int maxDiameter = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        getMaxDepth(root);

        return maxDiameter;
    }

    private int getMaxDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = getMaxDepth(root.left);
        int right= getMaxDepth(root.right);

        maxDiameter = Math.max(maxDiameter, left + right);

        return 1 + Math.max(left, right);
    }
}