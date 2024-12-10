package binary_tree.one_time_traverse;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 173. Binary Search Tree Iterator
public class Solution173 {
    class BSTIterator {
        private int i = -1;
        private List<Integer> list = new ArrayList<>();

        public BSTIterator(TreeNode root) {
            traverse(root);
        }

        private void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            traverse(root.left);
            list.add(root.val);
            traverse(root.right);
        }

        public int next() {
            i++;
            return list.get(i);
        }

        public boolean hasNext() {
            if (i < list.size() - 1) {
                return true;
            }
            return false;
        }
    }
}
