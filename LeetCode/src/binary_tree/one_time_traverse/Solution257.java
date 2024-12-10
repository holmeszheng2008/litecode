package binary_tree.one_time_traverse;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 257. Binary Tree Paths
public class Solution257 {
    private List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        traverse(root, "");

        return res;
    }

    private void traverse(TreeNode root, String prePath) {
        if (root == null) {
            return;
        }
        if (!prePath.isEmpty()) {
            prePath = prePath + "->";
        }
        prePath = prePath + root.val;
        if (root.left == null && root.right == null) {
            res.add(prePath);
        }
        traverse(root.left, prePath);
        traverse(root.right, prePath);
    }
}
