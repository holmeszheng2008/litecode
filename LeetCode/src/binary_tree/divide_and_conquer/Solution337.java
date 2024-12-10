package binary_tree.divide_and_conquer;

import util.TreeNode;

// 337. House Robber III
public class Solution337 {
    public int rob(TreeNode root) {
        int[] res = takeOrNot(root);
        return Math.max(res[0], res[1]);
    }

    private int[] takeOrNot(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        int[] left = takeOrNot(root.left);
        int[] right = takeOrNot(root.right);

        int take = 0;
        take = left[1] + right[1] + root.val;
        int notTake = 0;
        notTake = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return new int[] {take, notTake};
    }
}


class Solution337_attempt1 {
    public int rob(TreeNode root) {
        int[] res = divide(root);
        return Math.max(res[0], res[1]);
    }

    // 0 -> take root
    // 1 -> not take root
    private int[] divide(TreeNode root){
        if(root == null){
            return new int[]{0, 0};
        }

        int[] leftLoot = divide(root.left);
        int[] rightLoot = divide(root.right);

        int take = root.val + leftLoot[1] + rightLoot[1];
        int notTake = Math.max(leftLoot[0], leftLoot[1]) + Math.max(rightLoot[0], rightLoot[1]);

        return new int[]{take, notTake};
    }
}