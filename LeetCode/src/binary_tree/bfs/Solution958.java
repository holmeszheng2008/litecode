package binary_tree.bfs;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 958. Check Completeness of a Binary Tree
public class Solution958 {
    public boolean isCompleteTree(TreeNode root) {
        boolean nullGot = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null) {
                    nullGot = true;
                } else {
                    if (nullGot) {
                        return false;
                    } else {
                        queue.add(node.left);
                    }
                }
                if (node.right == null) {
                    nullGot = true;
                } else {
                    if (nullGot) {
                        return false;
                    } else {
                        queue.add(node.right);
                    }
                }
            }
        }

        return true;
    }
}
