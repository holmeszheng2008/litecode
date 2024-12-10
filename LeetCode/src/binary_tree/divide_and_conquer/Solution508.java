package binary_tree.divide_and_conquer;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 508. Most Frequent Subtree Sum
public class Solution508 {
    private int maxCount = Integer.MIN_VALUE;
    private Map<Integer, Integer> keyToCount = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        getSum(root);
        List<Integer> list = new ArrayList<>();
        for (int key : keyToCount.keySet()) {
            if (keyToCount.get(key) == maxCount) {
                list.add(key);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sumLeft = getSum(root.left);
        int sumRight = getSum(root.right);

        int sum = root.val + sumLeft + sumRight;
        int count = keyToCount.getOrDefault(sum, 0) + 1;
        maxCount = (maxCount > count) ? maxCount : count;
        keyToCount.put(sum, count);

        return sum;
    }
}
