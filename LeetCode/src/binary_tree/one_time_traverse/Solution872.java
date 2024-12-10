package binary_tree.one_time_traverse;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 872. Leaf-Similar Trees
public class Solution872 {
    private List<Integer> leaves1 = new ArrayList<>();
    private List<Integer> leaves2 = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        traverse(root1, leaves1);
        traverse(root2, leaves2);

        if (leaves1.size() != leaves2.size()) {
            return false;
        }
        for (int i = 0; i < leaves1.size(); i++) {
            if (leaves1.get(i) != leaves2.get(i)) {
                return false;
            }
        }

        return true;
    }

    private void traverse(TreeNode root, List<Integer> leaves) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }
        traverse(root.left, leaves);
        traverse(root.right, leaves);
    }
}
