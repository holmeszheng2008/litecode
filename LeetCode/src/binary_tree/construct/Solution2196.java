package binary_tree.construct;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

// 2196. Create Binary Tree From Descriptions
public class Solution2196 {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        for (int[] description : descriptions) {
            int parentVal = description[0];
            int childVal = description[1];
            int isLeft = description[2];

            TreeNode parentNode = map.get(parentVal);
            TreeNode childNode = map.get(childVal);
            if (parentNode == null) {
                parentNode = new TreeNode(parentVal);
                map.put(parentVal, parentNode);
            }
            if (childNode == null) {
                childNode = new TreeNode(childVal);
                map.put(childVal, childNode);
            }
            if (isLeft == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
        }

        for (int[] description : descriptions) {
            int childVal = description[1];
            map.remove(childVal);
        }

        return map.values().iterator().next();
    }
}
