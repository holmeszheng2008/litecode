package binary_tree.bfs;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 662. Maximum Width of Binary Tree
public class Solution662 {
    private int maxWidth;

    private class TaggedTreeNode {
        public int tag;
        public TreeNode node;

        public TaggedTreeNode(int tag, TreeNode node) {
            this.tag = tag;
            this.node = node;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<TaggedTreeNode> queue = new LinkedList<>();
        queue.add(new TaggedTreeNode(1, root));
        while (!queue.isEmpty()) {
            int size = queue.size();
            int begin = 0, end = 0;
            for (int i = 0; i < size; i++) {
                TaggedTreeNode tnode = queue.poll();
                TreeNode node = tnode.node;
                int tag = tnode.tag;
                if (node.left != null) {
                    queue.add(new TaggedTreeNode(2 * tag, node.left));
                }
                if (node.right != null) {
                    queue.add(new TaggedTreeNode(2 * tag + 1, node.right));
                }
                if (i == 0) {
                    begin = tag;
                }
                if (i == size - 1) {
                    end = tag;
                }
            }

            maxWidth = Math.max(maxWidth, end + 1 - begin);
        }

        return maxWidth;
    }
}
