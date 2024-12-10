package binary_tree.one_time_traverse;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

// 437. Path Sum III
public class Solution437 {
    private int res;
    private int pathSum;
    private Map<Integer, Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        map.put(0, 1);
        traverse(root, targetSum);

        return res;
    }

    private void traverse(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        pathSum += root.val;
        int count = map.getOrDefault(pathSum - targetSum, 0);
        res+= count;
        map.put(pathSum, map.getOrDefault(map.get(root.val), 0) + 1);
        traverse(root.left, targetSum);
        traverse(root.right, targetSum);
        map.put(pathSum, map.get(pathSum) - 1);
        pathSum -= root.val;
    }
}
