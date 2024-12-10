package binary_tree.bfs;

import util.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

// 863. All Nodes Distance K in Binary Tree
public class Solution863 {
    private Map<Integer, TreeNode> parentMap = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        traverse(root, null);
        int dist = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        visited.add(target.val);
        while (!queue.isEmpty()) {
            if (dist == k) {
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && !visited.contains(node.left.val)) {
                    queue.add(node.left);
                    visited.add(node.left.val);
                }
                if (node.right != null && !visited.contains(node.right.val)) {
                    queue.add(node.right);
                    visited.add(node.right.val);
                }
                TreeNode parent = parentMap.get(node.val);
                if (parent != null && !visited.contains(parent.val)) {
                    queue.add(parent);
                    visited.add(parent.val);
                }
            }

            dist++;
        }
        return queue.stream().map(node -> node.val).collect(Collectors.toList());
    }
    
    private void traverse(TreeNode root, TreeNode parentNode) {
        if (root == null) {
            return;
        }
        parentMap.put(root.val, parentNode);
        traverse(root.left, root);
        traverse(root.right, root);
    }
}

// DFS to graph + BFS
class Solution_attempt1 {
    private List<Integer>[] graph = new List[501];
    private Set<Integer> visited = new HashSet<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root, null);

        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(target.val);
        visited.add(target.val);
        int step = 0;

        while(!queue.isEmpty()){
            if(step == k){
                res.addAll(queue);
                break;
            }
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int node = queue.poll();
                List<Integer> nextNodes = graph[node];
                if(nextNodes == null){
                    continue;
                }
                for(int nextNode : nextNodes){
                    if(!visited.contains(nextNode)){
                        visited.add(nextNode);
                        queue.add(nextNode);
                    }
                }
            }

            step++;
        }

        return res;
    }

    private void dfs(TreeNode root, TreeNode parent){
        if(root == null){
            return;
        }
        if(parent != null){
            List<Integer> list = graph[parent.val];
            if(list == null){
                list = new ArrayList<>();
                graph[parent.val] = list;
            }
            list.add(root.val);

            List<Integer> list2 = graph[root.val];
            if(list2 == null){
                list2 = new ArrayList<>();
                graph[root.val] = list2;
            }
            list2.add(parent.val);
        }

        dfs(root.left, root);
        dfs(root.right, root);
    }
}