package binary_tree.bfs;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 1609. Even Odd Tree
public class Solution1609 {
    public boolean isEvenOddTree(TreeNode root) {
        boolean isLevelEven = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int pre = isLevelEven ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (isLevelEven) {
                    if (pre < node.val && node.val % 2 == 1) {
                        pre = node.val;
                    } else {
                        return false;
                    }
                } else {
                    if (pre > node.val && node.val % 2 == 0) {
                        pre = node.val;
                    } else {
                        return false;
                    }
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            isLevelEven = !isLevelEven;
        }

        return true;
    }
}
