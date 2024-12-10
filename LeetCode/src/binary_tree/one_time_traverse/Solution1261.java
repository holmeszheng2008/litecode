package binary_tree.one_time_traverse;

import util.TreeNode;

import java.util.LinkedList;

// 1261. Find Elements in a Contaminated Binary Tree
public class Solution1261 {
    class FindElements {

        private TreeNode root;
        public FindElements(TreeNode root) {
            root.val = 0;
            this.root = root;
            traverse(root);
        }

        private void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left != null) {
                root.left.val = 2 * root.val + 1;
            }
            if (root.right != null) {
                root.right.val = 2 * root.val + 2;
            }
            traverse(root.left);
            traverse(root.right);
        }

        public boolean find(int target) {
            LinkedList<Integer> list = new LinkedList<>();
            while (target > 0) {
                list.addFirst(target);
                target = (target - 1) / 2;
            }

            TreeNode node = root;
            while (true) {
                if (list.isEmpty()) {
                    return true;
                }
                int nextVal = list.removeFirst();
                TreeNode nextNode = null;
                if (node.left != null && node.left.val == nextVal) {
                    nextNode = node.left;
                }
                if (node.right != null && node.right.val == nextVal) {
                    nextNode = node.right;
                }
                if (nextNode == null) {
                    return false;
                }
                node = nextNode;
            }
        }
    }
}
