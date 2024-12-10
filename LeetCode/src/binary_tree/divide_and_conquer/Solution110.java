package binary_tree.divide_and_conquer;

import util.TreeNode;

// 110. Balanced Binary Tree
// divide and conquer + global variable
public class Solution110 {
    private boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        getMaxDepth(root);

        return isBalanced;
    }
    private int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 这种写法不好，风险很高，不适用于所有问题
        // 本题只是因为postorder位置使用时，什么返回值都不会有logical error或者runtime error
        if (!isBalanced) {
            return 666;
        }

        int left = getMaxDepth(root.left);
        int right = getMaxDepth(root.right);

        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }

        return 1 + Math.max(left, right);
    }
}

// divide + postorder traversal
class Solution110_attempt1 {
    private boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        getDepth(root);

        return isBalanced;
    }

    private int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftDepth = getDepth(root.left);
        if(!isBalanced){
            return 0;
        }
        int rightDepth = getDepth(root.right);
        if(!isBalanced){
            return 0;
        }

        if(Math.abs(leftDepth - rightDepth) > 1){
            isBalanced = false;
            return 0;
        }

        return 1 + Math.max(leftDepth, rightDepth);
    }
}

class Solution110_attempt2 {
    private boolean res = true;
    public boolean isBalanced(TreeNode root) {
        getMaxDepth(root);
        return res;
    }

    public int getMaxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getMaxDepth(root.left);
        if(!res){
            return 0;
        }
        int right = getMaxDepth(root.right);
        if(!res){
            return 0;
        }

        if(Math.abs(left - right) > 1) {
            res = false;
            return 0;
        } else {
            return 1 + Math.max(left, right);
        }
    }
}