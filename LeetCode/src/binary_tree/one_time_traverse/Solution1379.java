package binary_tree.one_time_traverse;

import util.TreeNode;

// 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
// A good example to traverse two identical tree simutaneously
public class Solution1379 {
    private TreeNode res;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        traverse(original, cloned, target);

        return res;
    }

    private void traverse(TreeNode original, TreeNode cloned, TreeNode target) {
        if (original == null) {
            return;
        }
        if (res != null) {
            return;
        }
        if (original == target) {
            res = cloned;
            return;
        }

        traverse(original.left, cloned.left, target);
        traverse(original.right, cloned.right, target);
    }
}

class Solution1379_attempt1 {
    private TreeNode res;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        dfs(original, cloned, target);

        return res;
    }
    private void dfs(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null){
            return;
        }
        if(original == target){
            res = cloned;
            return;
        }

        dfs(original.left, cloned.left, target);
        if(res != null){
            return;
        }
        dfs(original.right, cloned.right, target);
    }
}