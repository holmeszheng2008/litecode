package binary_tree.one_time_traverse;

import util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution104 {
    List<Integer> res = new LinkedList<>();

    List<Integer> preorderTraverse(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}

// Traverse
class Solution104_attempt1 {
    private int maxDepth;
    private int depth;
    public int maxDepth(TreeNode root) {
        dfs(root);

        return maxDepth;
    }

    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        depth++;
        maxDepth = Math.max(maxDepth, depth);

        dfs(root.left);
        dfs(root.right);

        depth--;
    }
}

// divide
class Solution104_attempt2 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }
}

class Solution104_bfs {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int height = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            height++;
        }

        return height - 1;
    }
}