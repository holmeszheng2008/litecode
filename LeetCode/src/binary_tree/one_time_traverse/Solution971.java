package binary_tree.one_time_traverse;

import util.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 971. Flip Binary Tree To Match Preorder Traversal
public class Solution971 {
    /*// my solution is more complicated
     * private List<Integer> res = new ArrayList<>(); private boolean canFlip = true; public
     * List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) { LinkedList<Integer> list = new
     * LinkedList<>(); for(int i : voyage) { list.add(i); } traverse(root, null, list, null); if
     * (!list.isEmpty() || !canFlip) { res.clear(); res.add(-1); }
     * 
     * return res; }
     * 
     * private void traverse(TreeNode side1, TreeNode side2, LinkedList<Integer> voyage, TreeNode
     * parent) { if (!canFlip) { return; } if (side1 == null) { return; } if (voyage.isEmpty()) {
     * canFlip = false; return; } int first = voyage.removeFirst(); if (side1.val != first) { if (side2
     * == null) { canFlip = false; return; } else { if (side2.val == first) { res.add(parent.val);
     * switchChildren(parent); traverse(side2.left, side2.right, voyage, side2); traverse(side2.right,
     * side2.left, voyage, side2); } else { canFlip = false; return; } } } else { traverse(side1.left,
     * side1.right, voyage, side1); traverse(side1.right, side1.left, voyage, side1); } }
     * 
     * private void switchChildren(TreeNode root) { TreeNode temp = root.left; root.left = root.right;
     * root.right = temp; }
     */
    private List<Integer> res = new LinkedList<>();
    private int i = 0;
    private int[] voyage;
    private boolean canFlip = true;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.voyage = voyage;
        traverse(root);

        if (canFlip) {
            return res;
        }
        return Arrays.asList(-1);
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (!canFlip) {
            return;
        }
        if (root.val != voyage[i++]) {
            canFlip = false;
            return;
        }
        if (root.left != null && root.left.val != voyage[i]) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            res.add(root.val);
        }

        traverse(root.left);
        traverse(root.right);
    }
}
