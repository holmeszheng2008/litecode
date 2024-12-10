package binary_tree.construct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 133. Clone Graph
public class Solution133 {
    private static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private Map<Node, Node> clonedNodes = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        if(clonedNodes.containsKey(node)){
            return clonedNodes.get(node);
        }

        Node root = new Node();
        root.val = node.val;

        clonedNodes.put(node, root);

        for(Node nextNode : node.neighbors){
            Node nextRoot = cloneGraph(nextNode);
            root.neighbors.add(nextRoot);
        }

        return root;
    }
}
