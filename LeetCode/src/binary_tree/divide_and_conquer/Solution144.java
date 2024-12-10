package binary_tree.divide_and_conquer;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 144. Binary Tree Preorder Traversal
// Divide
public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));

        return res;
    }
}

// Traverse
class Solution144_attempt1 {
    private List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return list;
    }

    private void dfs(TreeNode node){
        if(node == null){
            return;
        }
        list.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }


}