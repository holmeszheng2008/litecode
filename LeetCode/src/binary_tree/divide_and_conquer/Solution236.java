package binary_tree.divide_and_conquer;

import util.TreeNode;

// 236. Lowest Common Ancestor of a Binary Tree
public class Solution236 {
    private TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        contains(root, p, q);
        return lca;
    }

    private boolean contains(TreeNode root, TreeNode p, TreeNode q) {
        // 这样处理第一个答案返回是不安全的
        if (lca != null) {
            return false;
        }
        if (root == null) {
            return false;
        }

        boolean leftContains = contains(root.left, p, q);
        boolean rightContains = contains(root.right, p, q);

        if (leftContains && rightContains) {
            lca = root;
        } else if (root == p || root == q) {
            if (leftContains || rightContains) {
                lca = root;
            }
        }


        return (leftContains || rightContains || root == p || root == q);
    }
}

class Solution236_attempt1 {
    private TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        contains(root, p, q);
        return lca;
    }

    private boolean contains(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }

        boolean left = contains(root.left, p, q);
        if(lca != null){
            return true;
        }
        boolean right = contains(root.right, p, q);
        if(lca != null){
            return true;
        }

        boolean self = (root.val == p.val) || (root.val == q.val);
        if((left && right) || (left && self) || (right && self)){
            lca = root;
            return true;
        } else {
            return left || right || self;
        }
    }
}