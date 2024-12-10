package binary_tree.one_time_traverse;

import util.TreeNode;

// 99. Recover Binary Search Tree

public class Solution99 {
    TreeNode first = null, second = null, previous = null;

    public void recoverTree(TreeNode root) {
        findBadNodes(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void findBadNodes(TreeNode root) {
        if (root == null) {
            return;
        }
        findBadNodes(root.left);
        if (previous == null) {
            previous = root;
        } else {
            if (previous.val > root.val) {
                if (second == null) {
                    first = previous;
                }
                second = root;
            }
            previous = root;
        }
        findBadNodes(root.right);
    }

}

class Solution99_attempt1 {
    private TreeNode first;
    private TreeNode second;
    private TreeNode pre;
    public void recoverTree(TreeNode root) {
        traverse(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void traverse(TreeNode root){
        if(root == null){
            return;
        }

        traverse(root.left);

        if(pre == null) {
            pre = root;
        } else {
            if(pre.val > root.val){
                if(first == null) {
                    first = pre;
                }
                second = root;
            }

            pre = root;
        }
        traverse(root.right);
    }
}