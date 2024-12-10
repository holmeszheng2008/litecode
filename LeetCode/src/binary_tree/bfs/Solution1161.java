package binary_tree.bfs;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 1161. Maximum Level Sum of a Binary Tree
public class Solution1161 {
    private int maxSum = Integer.MIN_VALUE;
    private int minLevel = Integer.MAX_VALUE;
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            int sum = 0;
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (maxSum < sum) {
                maxSum = sum;
                minLevel = level;
            }
        }

        return minLevel;
    }
}
