package binary_tree.divide_and_conquer;

import util.TreeNode;

// 968. Binary Tree Cameras
public class Solution968 {
    private int res = 0;
    public int minCameraCover(TreeNode root) {
        setCamera(root, false);
        return res;
    }

    int setCamera(TreeNode root, boolean hasParent) {
        if (root == null) {
            return -1;
        }
        int left = setCamera(root.left, true);
        int right = setCamera(root.right, true);

        if (left == -1 && right == -1) {
            if (hasParent) {
                return 0;
            }
            res++;
            return 2;
        }

        if (left == 0 || right == 0) {
            res += 1;
            return 2;
        }

        if (left == 2 || right == 2) {
            return 1;
        }

        if (hasParent) {
            return 0;
        } else {
            res++;
            return 2;
        }
    }
}
