package binary_tree.construct;

import util.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// 919. Complete Binary Tree Inserter
public class Solution919 {
    class CBTInserter {
        private Map<Integer, TreeNode> tagToNodeMap = new HashMap<>();
        private int size = 1;
        private TreeNode root;
        public CBTInserter(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            tagToNodeMap.put(1, root);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                        size++;
                        tagToNodeMap.put(size, node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                        size++;
                        tagToNodeMap.put(size, node.right);
                    }
                }
            }
            this.root = root;
        }

        public int insert(int val) {
            size++;
            int parentTag = size / 2;
            TreeNode parentNode = tagToNodeMap.get(parentTag);
            TreeNode node = new TreeNode(val);
            if (size == parentTag * 2) {
                parentNode.left = node;
            } else {
                parentNode.right = node;
            }
            tagToNodeMap.put(size, node);
            return parentNode.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }
}
