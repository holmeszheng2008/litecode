package binary_tree.divide_and_conquer;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 1530. Number of Good Leaf Nodes Pairs
public class Solution1530 {
    private int res;
    private int distance;

    public int countPairs(TreeNode root, int distance) {
        this.distance = distance;
        helper(root);
        return res;
    }

    private List<Integer> helper(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        if (root.left == null && root.right == null) {
            list.add(0);
            return list;
        }
        List<Integer> left = helper(root.left);
        List<Integer> right = helper(root.right);
        res += getGoodNum(left, right);
        for (int leftEle : left) {
            list.add(leftEle + 1);
        }
        for (int rightEle : right) {
            list.add(rightEle + 1);
        }

        return list;
    }

    private int getGoodNum(List<Integer> left, List<Integer> right) {
        int num = 0;
        for (int leftEle : left) {
            for (int rightEle : right) {
                if (leftEle + rightEle + 2 <= distance) {
                    num++;
                }
            }
        }

        return num;
    }
}
