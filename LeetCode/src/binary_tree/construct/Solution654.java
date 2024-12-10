package binary_tree.construct;

import util.TreeNode;

// 654. Maximum Binary Tree
public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int left = 0, right = nums.length - 1;
        return construct(nums, left, right);
    }

    private TreeNode construct(int[] nums, int left, int right) {
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        if (left > right) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = left; i <= right; i++) {
            int value = nums[i];
            if (max <= value) {
                max = value;
                index = i;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = construct(nums, left, index - 1);
        root.right = construct(nums, index + 1, right);

        return root;
    }
}
