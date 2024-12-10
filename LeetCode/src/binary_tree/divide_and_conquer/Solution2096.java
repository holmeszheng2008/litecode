package binary_tree.divide_and_conquer;

import util.TreeNode;

// 2096. Step-By-Step Directions From a Binary Tree Node to Another
public class Solution2096 {
    private int startValue;
    private int destValue;
    private String res = "";
    private boolean found = false;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        this.startValue = startValue;
        this.destValue = destValue;

        contains(root, "");
        return res;
    }

    // 0 is int, 0 is not found, 1 is start, 2 is dest
    // 1 is string
    private Object[] contains(TreeNode root, String pass) {
        if (found) {
            return new Object[] {0, ""};
        }
        if (root == null) {
            return new Object[] {0, ""};
        }
        Object[] leftPair = contains(root.left, "L");
        Object[] rightPair = contains(root.right, "R");
        
        int leftFound = (int) leftPair[0];
        int rightFound = (int) rightPair[0];
        String leftPath = (String)leftPair[1];
        String rightPath = (String)rightPair[1];

        if (leftFound != 0 && rightFound != 0) {
            found = true;
            if (leftFound == 1) {
                for (int i = 0; i < leftPath.length(); i++) {
                    res = res + "U";
                }
                res = res + rightPath;
            } else {
                for (int i = 0; i < rightPath.length(); i++) {
                    res = res + "U";
                }
                res = res + leftPath;
            }
        } else if (leftFound == 1 && root.val == destValue) {
            found = true;
            for (int i = 0; i < leftPath.length(); i++) {
                res = res + "U";
            }
        } else if (leftFound == 2 && root.val == startValue) {
            found = true;
            res = leftPath;
        } else if (rightFound == 1 && root.val == destValue) {
            found = true;
            for (int i = 0; i < rightPath.length(); i++) {
                res = res + "U";
            }
        } else if (rightFound == 2 && root.val == startValue) {
            found = true;
            res = rightPath;
        } else if (root.val == startValue) {
            return new Object[] {1, pass};
        } else if (root.val == destValue) {
            return new Object[] {2, pass};
        } else if (leftFound == 1) {
            return new Object[] {1, pass + leftPath};
        } else if (leftFound == 2) {
            return new Object[] {2, pass + leftPath};
        } else if (rightFound == 1) {
            return new Object[] {1, pass + rightPath};
        } else if (rightFound == 2) {
            return new Object[] {2, pass + rightPath};
        }

        return new Object[] {0, ""};
    }
}
