package binary_search_tree;

import java.util.HashSet;
import java.util.Set;
import util.TreeNode;

// 501. Find Mode in Binary Search Tree
public class Solution501 {
    private int maxOccur = 0;
    private int currentOccur = 0;
    private int preVal = Integer.MIN_VALUE;
    private Set<Integer> res = new HashSet<>();
    public int[] findMode(TreeNode root) {
        traverse(root);
        return res.stream().mapToInt(i -> i).toArray();
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.val == preVal) {
            currentOccur++;
        } else {
            currentOccur = 1;
            preVal = root.val;
        }
        if (currentOccur > maxOccur) {
            maxOccur = currentOccur;
            res.clear();
            res.add(root.val);
        } else if (currentOccur == maxOccur) {
            res.add(root.val);
        }
        traverse(root.left);
        traverse(root.right);
    }
}
