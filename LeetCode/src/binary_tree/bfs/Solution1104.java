package binary_tree.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 1104. Path In Zigzag Labelled Binary Tree
public class Solution1104 {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new ArrayList<>();
        while (label != 1) {
            list.add(label);
            label /= 2;
        }
        list.add(1);
        Collections.reverse(list);

        for (int i = list.size() - 2; i > 0; i -= 2) {
            int min = (int) Math.round(Math.pow(2, i));
            int max = (int) Math.round(Math.pow(2, i + 1)) - 1;
            int val = list.get(i);
            list.set(i, min + max - val);
        }

        return list;
    }
}
