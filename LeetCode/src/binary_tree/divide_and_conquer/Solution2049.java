package binary_tree.divide_and_conquer;

// 2049. Count Nodes With the Highest Score
public class Solution2049 {
    private int[][] tree;
    private int size;
    private long maxProduct = Long.MIN_VALUE;
    private int res;

    public int countHighestScoreNodes(int[] parents) {
        size = parents.length;
        buildTree(parents);

        getCount(0);
        return res;
    }

    public int getCount(int root) {
        if (root == -1) {
            return 0;
        }
        int left = getCount(tree[root][0]);
        int right = getCount(tree[root][1]);

        int parent = size - left - right - 1;
        long product = (long) Math.max(left, 1) * Math.max(right, 1) * Math.max(parent, 1);
        if (maxProduct == product) {
            res++;
        } else if (maxProduct < product) {
            maxProduct = product;
            res = 1;
        }

        return 1 + left + right;
    }

    private void buildTree(int[] parents) {
        int n = parents.length;
        tree = new int[n][2];
        for(int[] pair : tree) {
            pair[0] = -1;
            pair[1] = -1;
        }
        for (int i = 0; i < n; i++) {
            int val = parents[i];
            if (val != -1) {
                if (tree[val][0] == -1) {
                    tree[val][0] = i;
                } else {
                    tree[val][1] = i;
                }
            }
            
        }
    }
}
