package binary_search_tree;

import util.TreeNode;

// 98. Validate Binary Search Tree
public class Solution98 {
    private static class Pair {
        public boolean isBST;
        public long min;
        public long max;

        public Pair(boolean isBST, long min, long max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }
    public boolean isValidBST(TreeNode root) {
        return divide(root).isBST;
    }
    
    private Pair divide(TreeNode root) {
        if (root == null) {
            return new Pair(true, Long.MAX_VALUE, Long.MIN_VALUE);
        }
        Pair leftRes = divide(root.left);
        Pair rightRes = divide(root.right);
        
        if (leftRes.isBST && rightRes.isBST && leftRes.max < root.val && rightRes.min > root.val) {
            long min = Math.min(leftRes.min, root.val);
            long max = Math.max(rightRes.max, root.val);
            
            return new Pair(true, min, max);
        } else {
            return new Pair(false, 0, 0);
        }
    }
}

// Traverse
class Solution98_attempt1 {
    private boolean res = true;
    private boolean resGot = false;
    public boolean isValidBST(TreeNode root) {
        dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);

        return res;
    }

    private void dfs(TreeNode root, long min, long max){
        if(root == null){
            return;
        }
        if(resGot){
            return;
        }

        if(root.val <= min || root.val >= max){
            res = false;
            resGot = true;
            return;
        }

        dfs(root.left, min, root.val);
        dfs(root.right, root.val, max);
    }
}

// Divide + postorder traversal
class Solution98_attempt2 {
    private boolean res = true;
    private boolean resGot = false;
    public boolean isValidBST(TreeNode root) {
        divide(root);

        return res;
    }

    // 0 -> min
    // 1 -> max
    private long[] divide(TreeNode root) {
        if(root == null){
            return new long[]{Long.MAX_VALUE, Long.MIN_VALUE};
        }

        long[] left = divide(root.left);
        if(resGot){
            return null;
        }
        long[] right = divide(root.right);
        if(resGot){
            return null;
        }

        if(root.val > left[1] && root.val < right[0]){
            return new long[]{
                    Math.min(root.val, left[0]),
                    Math.max(root.val, right[1])
            };
        } else {
            resGot = true;
            res = false;
            return null;
        }
    }
}

// traverse
class Solution98_attempt3 {
    private boolean res = true;
    public boolean isValidBST(TreeNode root) {
        dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);

        return res;
    }

    private void dfs(TreeNode root, long min, long max){
        if(!res){
            return;
        }
        if(root == null){
            return;
        }

        if(root.val >= max || root.val <= min){
            res = false;
            return;
        }

        dfs(root.left, min, root.val);
        dfs(root.right, root.val, max);
    }
}