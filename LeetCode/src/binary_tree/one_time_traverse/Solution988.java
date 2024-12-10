package binary_tree.one_time_traverse;

import util.TreeNode;

// 988. Smallest String Starting From Leaf
public class Solution988 {
    private String res;

    public String smallestFromLeaf(TreeNode root) {
        traverse(root, "");
        return res;
    }

    private void traverse(TreeNode root, String path) {
        if (root == null) {
            return;
        }
        path = (char) ('a' + root.val) + path;
        if (root.left == null && root.right == null) {
            if (res == null) {
                res = path;
            } else {
                res = (res.compareTo(path) < 0) ? res : path;
            }
        }
        traverse(root.left, path);
        traverse(root.right, path);
    }
}
