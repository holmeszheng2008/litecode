package leetcode;

import java.util.Stack;

/*
 * Binary Tree DFS recursive route:
 *      NLNRN
     selectively:
         preOrder:  NLR
         inOrder:   LNR
         postOrder: LRN
 */
public class PlayGround {
    public static void main(String[] args) {
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node3.left = node7;

        Solution1 solution1 = new Solution1();
        solution1.preOrderRecursive(node0);
        System.out.println();
        solution1.preOrderNonRecursive(node0);
        System.out.println();
        solution1.inOrderRecursive(node0);
        System.out.println();
        solution1.inOrderNonRecursive(node0);
        System.out.println();
        solution1.postOrderRecursive(node0);
        System.out.println();
        solution1.postOrderNonRecursive(node0);
        System.out.println();
        solution1.fullPathRecursive(node0);
        System.out.println();
        solution1.fullPathNonRecursive(node0);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
    }
}

class NodeWrapper {
    public Node nodeRef;
    public int visit;

    public NodeWrapper(Node node) {
        this.nodeRef = node;
        this.visit = 0;
    }
}

class Solution1 {
    public void preOrderRecursive(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + "\t");
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    public void preOrderNonRecursive(Node root) {
        if (root == null)
            return;
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            Node node = s.pop();
            System.out.print(node.val + "\t");
            if (node.right != null) {
                s.push(node.right);
            }
            if (node.left != null) {
                s.push(node.left);
            }
        }
    }
    public void inOrderRecursive(Node root) {
        if (root == null)
            return;
        inOrderRecursive(root.left);
        System.out.print(root.val + "\t");
        inOrderRecursive(root.right);
    }

    public void inOrderNonRecursive(Node root) {
        Stack<NodeWrapper> s = new Stack<>();
        if (root != null) {
            s.push(new NodeWrapper(root));
        }
        while (!s.isEmpty()) {
            NodeWrapper nodew = s.pop();
            if (nodew.visit == 0) {
                nodew.visit += 1;
                s.push(nodew);
                if (nodew.nodeRef.left != null) {
                    s.push(new NodeWrapper(nodew.nodeRef.left));
                }
            } else if (nodew.visit == 1) {
                System.out.print(nodew.nodeRef.val + "\t");
                if (nodew.nodeRef.right != null) {
                    s.push(new NodeWrapper(nodew.nodeRef.right));
                }
            }
        }
    }

    public void postOrderRecursive(Node root) {
        if (root == null) {
            return;
        }
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.print(root.val + "\t");
    }

    public void postOrderNonRecursive(Node root) {
        Stack<NodeWrapper> s = new Stack<>();
        if (root != null) {
            s.push(new NodeWrapper(root));
        }
        while (!s.isEmpty()) {
            NodeWrapper nodew = s.pop();
            if (nodew.visit == 0) {
                nodew.visit += 1;
                s.push(nodew);
                if (nodew.nodeRef.left != null) {
                    s.push(new NodeWrapper(nodew.nodeRef.left));
                }
            } else if (nodew.visit == 1) {
                nodew.visit += 1;
                s.push(nodew);
                if (nodew.nodeRef.right != null) {
                    s.push(new NodeWrapper(nodew.nodeRef.right));
                }
            } else {
                System.out.print(nodew.nodeRef.val + "\t");
            }
        }
    }

    public void fullPathRecursive(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + "\t");
        fullPathRecursive(root.left);
        System.out.print(root.val + "\t");
        fullPathRecursive(root.right);
        System.out.print(root.val + "\t");
    }

    public void fullPathNonRecursive(Node root) {
        if (root == null) {
            return;
        }
        Stack<NodeWrapper> s = new Stack<>();
        s.push(new NodeWrapper(root));
        while (!s.isEmpty()) {
            NodeWrapper nodew = s.pop();
            if (nodew.visit == 0) {
                System.out.print(nodew.nodeRef.val + "\t");
                nodew.visit += 1;
                s.push(nodew);
                if (nodew.nodeRef.left != null) {
                    s.push(new NodeWrapper(nodew.nodeRef.left));
                }
            } else if (nodew.visit == 1) {
                System.out.print(nodew.nodeRef.val + "\t");
                nodew.visit += 1;
                s.push(nodew);
                if (nodew.nodeRef.right != null) {
                    s.push(new NodeWrapper(nodew.nodeRef.right));
                }
            } else {
                System.out.print(nodew.nodeRef.val + "\t");
            }
        }
    }
}