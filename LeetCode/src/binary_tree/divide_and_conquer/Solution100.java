package binary_tree.divide_and_conquer;

import util.TreeNode;

// 100. Same Tree
public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

// Divide
class Solution100_attempt1 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val == q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        return false;
    }
}

// Traverse
class Solution100_attempt2 {
    private boolean res = true;
    private boolean resGot;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        traverse(p, q);
        return res;
    }

    private void traverse(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return;
        }
        if(p == null || q == null){
            res = false;
            resGot = true;
            return;
        }

        if(p.val != q.val){
            res = false;
            resGot = true;
            return;
        }

        traverse(p.left, q.left);
        if(resGot){
            return;
        }

        traverse(p.right, q.right);
        if(resGot){
            return;
        }
    }
}