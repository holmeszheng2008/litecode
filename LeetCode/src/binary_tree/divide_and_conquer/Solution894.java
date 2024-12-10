package binary_tree.divide_and_conquer;

import util.TreeNode;

import java.util.*;

public class Solution894 {
    private Map<Integer, List<TreeNode>> memo = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        List<TreeNode> res = new ArrayList<>();
        if (n < 0 || n % 2 == 0) {
            return res;
        }

        if (n == 1) {
            res.add(new TreeNode(0));
            memo.put(1, res);
            return res;
        }

        for (int i = 1; i < n;) {
            List<TreeNode> leftRes = allPossibleFBT(i);
            List<TreeNode> rightRes = allPossibleFBT(n - i - 1);
            for (TreeNode left : leftRes) {
                for (TreeNode right : rightRes) {
                    TreeNode node = new TreeNode(0);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
            i += 2;
        }
        memo.put(n, res);
        return res;
    }
}


class Solution_attempt1 {
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res = new ArrayList<>();
        if(n % 2 == 0){
            return res;
        }

        Map<Integer, List<TreeNode>> memo = new HashMap<>();
        memo.put(1, Arrays.asList(new TreeNode(0)));
        for(int i = 3; i <= n; i+=2){
            List<TreeNode> list = new ArrayList<>();
            for(int j = 1; j < i - 1; j += 2){
                int leftNum = j, rightNum = i -1 - j;
                List<TreeNode> leftCom = memo.get(leftNum);
                List<TreeNode> rightCom = memo.get(rightNum);

                for(TreeNode leftNode : leftCom){
                    for(TreeNode rightNode : rightCom){
                        TreeNode root = new TreeNode(0);
                        root.left = leftNode;
                        root.right = rightNode;
                        list.add(root);
                    }
                }
            }
            memo.put(i, list);
        }

        return memo.get(n);
    }
}