package binary_tree.divide_and_conquer;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 145. Binary Tree Postorder Traversal

// divide
public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        res.addAll(postorderTraversal(root.left));
        res.addAll(postorderTraversal(root.right));

        res.add(root.val);

        return res;
    }
}

// divide
class Solution145_attempt1 {
    private List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return list;
    }

    private void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.left);
        dfs(node.right);

        list.add(node.val);
    }
}