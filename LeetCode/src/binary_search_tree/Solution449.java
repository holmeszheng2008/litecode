package binary_search_tree;

import java.util.LinkedList;
import util.TreeNode;

// 449. Serialize and Deserialize BST
public class Solution449 {
    private String SEP = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        return sb.toString();
    }

    private void traverse(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val).append(SEP);
        traverse(root.left, sb);
        traverse(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] dataArray = data.split(SEP);
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : dataArray) {
            nodes.add(s);
        }

        return dHelper(nodes, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode dHelper(LinkedList<String> nodes, int min, int max) {
        if (nodes.isEmpty()) {
            return null;
        }
        int first = Integer.valueOf(nodes.peekFirst());
        if (first <= min || first >= max) {
            return null;
        }

        TreeNode node = new TreeNode(first);
        nodes.removeFirst();
        node.left = dHelper(nodes, min, first);
        node.right = dHelper(nodes, first, max);

        return node;
    }
}
