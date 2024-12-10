package binary_search_tree;

import util.TreeNode;

// 108. Convert Sorted Array to Binary Search Tree
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = build(nums, low, mid - 1);
        node.right = build(nums, mid + 1, high);

        return node;
    }
}

class Solution108_attempt1 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        if(left == right){
            return new TreeNode(nums[left]);
        }

        int middle = left + (right - left) / 2;
        TreeNode rootNode = new TreeNode(nums[middle]);
        rootNode.left = buildTree(nums, left, middle - 1);
        rootNode.right = buildTree(nums, middle + 1, right);

        return rootNode;
    }
}