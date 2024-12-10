package binary_tree.one_time_traverse;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 1315. Sum of Nodes with Even-Valued Grandparent
public class Solution1315 {
    private int res;
    public int sumEvenGrandparent(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.val % 2 == 0) {
            res += sumOfGrandChildren(root);
        }
        traverse(root.left);
        traverse(root.right);
    }

    private int sumOfGrandChildren(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int loop = 0;
        while (!queue.isEmpty() && loop < 2) {
            loop++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        int sum = 0;
        for (TreeNode node : queue) {
            sum += node.val;
        }

        return sum;
    }
}
