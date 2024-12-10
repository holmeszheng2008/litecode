package binary_tree.bfs;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 623. Add One Row to Tree
public class Solution623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        int currentDepth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (currentDepth == depth - 1) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    TreeNode originalLeft = node.left;
                    TreeNode originalRight = node.right;
                    TreeNode left = new TreeNode(val);
                    TreeNode right = new TreeNode(val);
                    left.left = originalLeft;
                    right.right = originalRight;
                    node.left = left;
                    node.right = right;
                }
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                currentDepth++;
            }
        }

        return root;
    }
}
