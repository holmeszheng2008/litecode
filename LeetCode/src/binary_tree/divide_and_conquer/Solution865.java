package binary_tree.divide_and_conquer;

import util.TreeNode;

// 865. Smallest Subtree with all the Deepest Nodes
public class Solution865 {
    private class Pair {
        public TreeNode node;
        public int depth;

        public Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return getMaxDepth(root).node;
    }

    private Pair getMaxDepth(TreeNode root) {
        if (root == null) {
            return new Pair(null, 0);
        }
        Pair left = getMaxDepth(root.left);
        Pair right = getMaxDepth(root.right);

        if (left.depth == right.depth) {
            return new Pair(root, left.depth + 1);
        }
        Pair pair = (left.depth > right.depth) ? left : right;

        pair.depth++;

        return pair;
    }
}
