package binary_tree.construct;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

// 889. Construct Binary Tree from Preorder and Postorder Traversal
public class Solution889 {
    private Map<Integer, Integer> postIndexMap = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            postIndexMap.put(postorder[i], i);
        }

        return build(preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] postorder, int preleft, int preright, int postleft, int postright) {
        if (preleft > preright) {
            return null;
        }
        if (preleft == preright) {
            return new TreeNode(preorder[preleft]);
        }
        int rootValue = preorder[preleft];
        int nextValue = preorder[preleft + 1];
        int index = postIndexMap.get(nextValue);
        int rightsize = postright - 1 - index;
        
        TreeNode node = new TreeNode(rootValue);
        node.left = build(preorder, postorder, preleft + 1, preright - rightsize, postleft, index);
        node.right = build(preorder, postorder, preright + 1 - rightsize, preright, index + 1, postright - 1);

        return node;
    }
}
