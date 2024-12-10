package binary_tree.divide_and_conquer;

import util.TreeNode;

import java.util.*;

// 652. Find Duplicate Subtrees
public class Solution652 {
    private String NULL = "#";
    private String SEP = ",";

    private List<TreeNode> res = new LinkedList<>();
    private Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        getSerialStr(root);
        return res;
    }

    private String getSerialStr(TreeNode root) {
        if (root == null) {
            return NULL;
        }
        String serialStr = root.val + SEP + getSerialStr(root.left) + SEP + getSerialStr(root.right);
        if (map.getOrDefault(serialStr, 0) == 1) {
            res.add(root);
        }
        map.put(serialStr, map.getOrDefault(serialStr, 0) + 1);

        return serialStr;
    }
}


class Solution652_attempt1 {
    private String NULL = "#";
    private String SEP = ",";

    private List<TreeNode> res;
    private Map<String, Boolean> memo;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        this.res = new ArrayList<>();
        this.memo = new HashMap<>();

        divide(root);
        return res;
    }

    private String divide(TreeNode node){
        if(node == null){
            return NULL;
        }
        String leftStr = divide(node.left);
        String rightStr = divide(node.right);

        String str = node.val + SEP +leftStr + SEP + rightStr;

        if(memo.containsKey(str)){
            if(memo.get(str) == false) {
                res.add(node);
                memo.put(str, true);
            }
        } else {
            memo.put(str, false);
        }

        return str;
    }
}