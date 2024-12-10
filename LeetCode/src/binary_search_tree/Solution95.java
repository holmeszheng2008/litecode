package binary_search_tree;

import util.Pair;
import util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 95. Unique Binary Search Trees II
public class Solution95 {
    private Object[][] memo;
    public List<TreeNode> generateTrees(int n) {
        memo = new Object[n + 1][n + 1];
        return construct(1, n);
    }

    private List<TreeNode> construct(int low, int high) {
        if (low > high) {
            return null;
        }
        if (memo[low][high] != null) {
            return (List<TreeNode>) memo[low][high];
        }
        List<TreeNode> resRoots = new ArrayList<>();
        for (int i = low; i <= high; i++) {
            List<TreeNode> leftRoots = construct(low, i - 1);
            List<TreeNode> rightRoots = construct(i + 1, high);
            if (leftRoots == null) {
                if (rightRoots == null) {
                    resRoots.add(new TreeNode(i));
                } else {
                    for (TreeNode rightRoot : rightRoots) {
                        TreeNode root = new TreeNode(i);
                        root.right = rightRoot;
                        resRoots.add(root);
                    }
                }
            } else {
                if (rightRoots == null) {
                    for (TreeNode leftRoot : leftRoots) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftRoot;
                        resRoots.add(root);
                    }
                } else {
                    for (TreeNode leftRoot : leftRoots) {
                        for (TreeNode rightRoot : rightRoots) {
                            TreeNode root = new TreeNode(i);
                            root.left = leftRoot;
                            root.right = rightRoot;
                            resRoots.add(root);
                        }
                    }
                }
            }
        }

        memo[low][high] = resRoots;

        return resRoots;
    }
}

class Solution95_attempt1 {
    private Map<Pair<Integer, Integer>, List<TreeNode>> memo = new HashMap<>();
    public List<TreeNode> generateTrees(int n) {
        return dp(1, n);
    }

    private List<TreeNode> dp(int low, int high) {
        List<TreeNode> res = new ArrayList<>();
        if(low > high) {
            res.add(null);
            return res;
        }
        if(low == high){
            res.add(new TreeNode(low));
            return res;
        }

        Pair<Integer, Integer> key = new Pair<>(low, high);
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        for(int i = low; i <= high; i++){
            List<TreeNode> leftRoots = dp(low, i - 1);
            List<TreeNode> rightRoots = dp(i+1, high);

            for(TreeNode leftRoot : leftRoots){
                for(TreeNode rightRoot : rightRoots){
                    TreeNode node = new TreeNode(i);
                    node.left = leftRoot;
                    node.right = rightRoot;
                    res.add(node);
                }
            }
        }

        memo.put(key, res);
        return res;
    }
}
