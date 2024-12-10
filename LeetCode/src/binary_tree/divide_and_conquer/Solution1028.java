package binary_tree.divide_and_conquer;

import util.TreeNode;

// 1028. Recover a Tree From Preorder Traversal
public class Solution1028 {
    private int i = 0;
    public TreeNode recoverFromPreorder(String traversal) {
        TreeNode node = new TreeNode(extractNum(traversal));
        node.left = helper(traversal, 1);
        node.right = helper(traversal, 1);

        return node;
    }

    private TreeNode helper(String traversal, int depth) {
        if (i == traversal.length()) {
            return null;
        }
        int dashNum = scanDashes(traversal);
        if (dashNum != depth) {
            return null;
        }
        i += dashNum;
        int val = extractNum(traversal);
        TreeNode node = new TreeNode(val);
        node.left = helper(traversal, depth + 1);
        node.right = helper(traversal, depth + 1);

        return node;
    }

    private int scanDashes(String traversal) {
        int num = 0;
        int localI = i;
        while (traversal.charAt(localI) == '-') {
            num++;
            localI++;
        }

        return num;
    }

    private int extractNum(String traversal) {
        int num = 0;
        while (i != traversal.length() && Character.isDigit(traversal.charAt(i))) {
            num = num * 10 + (traversal.charAt(i) - '0');
            i++;
        }

        return num;
    }
}
