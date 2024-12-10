package binary_tree.one_time_traverse;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

// 1457. Pseudo-Palindromic Paths in a Binary Tree
public class Solution1457 {
    private int num;
    private Map<Integer, Integer> map = new HashMap<>();
    public int pseudoPalindromicPaths(TreeNode root) {
        for (int i = 1; i < 10; i++) {
            map.put(i, 0);
        }
        traverse(root);
        return num;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        if (root.left == null && root.right == null && isPalindromic()) {
            num++;
        }
        traverse(root.left);
        traverse(root.right);
        map.put(root.val, map.getOrDefault(root.val, 0) - 1);
    }
    private boolean isPalindromic() {
        int oddNum = 0;
        for (int i = 1; i < 10; i++) {
            if (map.get(i) % 2 == 1) {
                oddNum++;
            }
            if (oddNum > 1) {
                return false;
            }
        }

        return true;
    }
}
