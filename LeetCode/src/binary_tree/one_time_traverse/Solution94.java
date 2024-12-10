package binary_tree.one_time_traverse;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution94 {
    private List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);

        return res;
    }
    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }
}
