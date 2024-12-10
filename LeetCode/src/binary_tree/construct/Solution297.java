package binary_tree.construct;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


public class Solution297 {
    private String NULL = "#";
    private String SEP = ",";
    // Encodes a tree to a single string.

    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append(NULL).append(SEP);
            } else {
                sb.append(node.val).append(SEP);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty())
        {
            return null;
        }
        String[] nodes = data.split(SEP);
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        queue.offer(root);
        for (int i = 1; i < nodes.length;) {
            TreeNode node = queue.poll();
            String left = nodes[i++];
            String right = nodes[i++];
            if (left.equals(NULL)) {
                node.left = null;
            } else {
                node.left = new TreeNode(Integer.valueOf(left));
                queue.offer(node.left);
            }
            if (right.equals(NULL)) {
                node.right = null;
            } else {
                node.right = new TreeNode(Integer.valueOf(right));
                queue.offer(node.right);
            }
        }

        return root;
    }
}

