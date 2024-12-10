package binary_search_tree;

import java.util.ArrayList;
import java.util.List;
import util.TreeNode;

// 1382. Balance a Binary Search Tree
public class Solution1382 {
    private List<Integer> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        traverse(root);
        return build(0, list.size() - 1);
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        list.add(root.val);
        traverse(root.right);
    }

    private TreeNode build(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = build(left, mid - 1);
        node.right = build(mid + 1, right);

        return node;
    }
}
