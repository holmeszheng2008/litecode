package binary_tree.construct;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

// 105. Construct Binary Tree from Preorder and Inorder Traversal
public class Solution105 {
    private Map<Integer, Integer> inorderIndexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preleft, int preright, int inleft, int inright) {
        if (preleft > preright) {
            return null;
        }
        if (preleft == preright) {
            return new TreeNode(preorder[preleft]);
        }

        int value = preorder[preleft];
        int inIndex = inorderIndexMap.get(value);
        int leftSize = inIndex - inleft;
        int rightSize = inright - inIndex;

        TreeNode node = new TreeNode(value);
        node.left = build(preorder, inorder, preleft + 1, preleft + leftSize, inleft, inIndex - 1);
        node.right = build(preorder, inorder, preleft + leftSize + 1, preright, inIndex + 1, inright);

        return node;
    }
}


class Solution105_attempt1 {
    private int[] preorder;
    private int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return doBuild(0, preorder.length-1, 0, inorder.length-1);
    }

    private TreeNode doBuild(int preLeft, int preRight, int inLeft, int inRight){
        if(preLeft > preRight){
            return null;
        }
        TreeNode node = new TreeNode();
        node.val = preorder[preLeft];
        if (preLeft == preRight) {
            return node;
        }

        int inRoot = inLeft;
        for(;inRoot <= inRight; inRoot++){
            if (inorder[inRoot] == node.val){
                break;
            }
        }

        int leftSize = inRoot - inLeft;
        int rightSize = inRight - inRoot;

        node.left = doBuild(preLeft + 1, preLeft + leftSize, inLeft, inRoot -1);
        node.right = doBuild(preLeft + leftSize + 1, preRight, inRoot + 1, inRight);

        return node;
    }
}

class Solution105_attempt2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int left1, int right1, int[] inorder, int left2, int right2){
        if(left1 > right1){
            return null;
        }
        if(left1 == right1){
            return new TreeNode(preorder[left1]);
        }

        int rootVal = preorder[left1];
        int rootIndexInInorder = left2;
        for(; rootIndexInInorder <= right2; rootIndexInInorder++){
            if(inorder[rootIndexInInorder] == rootVal){
                break;
            }
        }

        int leftSize = rootIndexInInorder - left2;
        TreeNode rootNode = new TreeNode(rootVal);
        rootNode.left = buildTree(preorder, left1 + 1, left1 + leftSize, inorder, left2, rootIndexInInorder - 1);
        rootNode.right = buildTree(preorder, left1 + 1 + leftSize, right1, inorder, rootIndexInInorder + 1, right2);

        return rootNode;
    }
}