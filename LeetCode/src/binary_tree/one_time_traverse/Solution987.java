package binary_tree.one_time_traverse;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 987. Vertical Order Traversal of a Binary Tree
public class Solution987 {
    private class Triple {
        public int val;
        public int row;
        public int col;

        public Triple(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

    private List<Triple> nodes = new ArrayList<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        traverse(root, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        res.sort(null);
        nodes.sort((triple1, triple2) -> {
            if (triple1.row == triple2.row && triple1.col == triple2.col) {
                return triple1.val - triple2.val;
            }
            if (triple1.col == triple2.col) {
                return triple1.row - triple2.row;
            }
            return triple1.col - triple2.col;
        });
        int preCol = Integer.MAX_VALUE;
        for (Triple triple : nodes) {
            int col = triple.col;
            if (preCol != col) {
                res.add(new ArrayList<>());
            }
            preCol = col;
            res.get(res.size() - 1).add(triple.val);
        }

        return res;
    }

    private void traverse(TreeNode root, int row, int col) {
        if (root == null) {
            return;
        }
        nodes.add(new Triple(root.val, row, col));
        traverse(root.left, row + 1, col - 1);
        traverse(root.right, row + 1, col + 1);
    }
}
