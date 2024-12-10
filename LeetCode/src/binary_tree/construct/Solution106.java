package binary_tree.construct;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

// 106. Construct Binary Tree from Inorder and Postorder Traversal
public class Solution106 {
    private Map<Integer, Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int inleft, int inright, int postleft, int postright) {
        if (postleft > postright) {
            return null;
        }
        if (postleft == postright) {
            TreeNode node = new TreeNode(postorder[postright]);
            return node;
        }
        int value = postorder[postright];
        int inIndex = inorderIndexMap.get(value);
        int leftSize = inIndex - inleft;
        int rightSize = inright - inIndex;

        TreeNode node = new TreeNode();
        node.val = value;
        node.left = build(inorder, postorder, inleft, inIndex - 1, postleft, postleft + leftSize - 1);
        node.right = build(inorder, postorder, inIndex + 1, inright, postleft + leftSize, postright - 1);

        return node;
    }
}

class Solution106_attempt1 {
    private Map<Integer, Integer> inorderIndexMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return buildTree(postorder, 0, inorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int postorder[], int left1, int right1, int[] inorder, int left2, int right2){
        if(left1 > right1){
            return null;
        }
        if(left1 == right1){
            return new TreeNode(postorder[left1]);
        }

        int rootValue = postorder[right1];
        int rootIndexInorder = inorderIndexMap.get(rootValue);

        int leftSize = rootIndexInorder - left2;

        TreeNode rootNode = new TreeNode(rootValue);
        rootNode.left = buildTree(postorder, left1, left1 + leftSize - 1, inorder, left2, rootIndexInorder - 1);
        rootNode.right = buildTree(postorder, left1 + leftSize, right1 - 1, inorder, rootIndexInorder + 1, right2);

        return rootNode;
    }
}