package binary_tree.divide_and_conquer;

import util.TreeNode;

// 1008. Construct Binary Search Tree from Preorder Traversal
public class Solution1008 {
    private int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode helper(int[] preorder, int min, int max) {
        if (i == preorder.length) {
            return null;
        }
        if (preorder[i] < min || preorder[i] > max) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[i++]);
        node.left = helper(preorder, min, node.val);
        node.right = helper(preorder, node.val, max);
        return node;
    }
}
