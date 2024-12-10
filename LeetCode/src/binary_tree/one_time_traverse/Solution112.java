package binary_tree.one_time_traverse;

import util.TreeNode;

// 112. Path Sum
// backtracking
// apply decision made on current level -> deep down to the next level -> revert decision made on current level
public class Solution112 {
    private boolean res = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        traverse(root, 0, targetSum);
        return res;
    }

    private void traverse(TreeNode root, int preSum, int targetSum) {
        if (root == null) {
            return;
        }
        if (res) {
            return;
        }
        preSum += root.val;
        if (root.left == null && root.right == null && preSum == targetSum) {
            res = true;
        }
        traverse(root.left, preSum, targetSum);
        traverse(root.right, preSum, targetSum);
        preSum -= root.val;
    }
}

class Solution112_attempt1 {
    private boolean res = false;
    private int path = 0;
    private int targetSum;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        if(root == null){
            return false;
        }
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        path += root.val;
        if(root.left == null && root.right == null && path == targetSum){
            res = true;
            return;
        }

        dfs(root.left);
        if(res){
            return;
        }
        dfs(root.right);
        if(res){
            return;
        }

        path -= root.val;
    }
}