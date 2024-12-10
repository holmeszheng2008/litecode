package binary_search_tree;

import java.util.ArrayList;
import java.util.List;
import util.TreeNode;

// 1305. All Elements in Two Binary Search Trees
public class Solution1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        traverse(root1, list1);
        traverse(root2, list2);

        return mergeTwoSortedArray(list1, list2);
    }

    private List<Integer> mergeTwoSortedArray(List<Integer> list1, List<Integer> list2) {
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() || j < list2.size()) {
            if (i == list1.size()) {
                while (j < list2.size()) {
                    list.add(list2.get(j));
                    j++;
                }
            } else if (j == list2.size()) {
                while (i < list1.size()) {
                    list.add(list1.get(i));
                    i++;
                }
            } else {
                if (list1.get(i) < list2.get(j)) {
                    list.add(list1.get(i));
                    i++;
                } else {
                    list.add(list2.get(j));
                    j++;
                }
            }
        }

        return list;
    }

    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }
}
