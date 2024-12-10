package binary_tree.divide_and_conquer;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 1110. Delete Nodes And Return Forest
public class Solution1110 {
    private List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        doDel(root, set);
        if (!set.contains(root.val)) {
            res.add(root);
        }

        return res;
    }

    private TreeNode doDel(TreeNode root, Set<Integer> set) {
        if (root == null) {
            return null;
        }
        TreeNode left = doDel(root.left, set);
        TreeNode right = doDel(root.right, set);
        if (set.contains(root.val)) {
            if (left != null) {
                res.add(left);
            }
            if (right != null) {
                res.add(right);
            }
            return null;
        }

        root.left = left;
        root.right = right;
        return root;
    }
}
