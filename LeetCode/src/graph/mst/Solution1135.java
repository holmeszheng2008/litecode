package graph.mst;

import java.util.Arrays;

// 1135 「最低成本联通所有城市」
public class Solution1135 {
    int minimumCost(int n, int[][] connections) {
        int res = 0;
        UF uf = new UF(n + 1);
        Arrays.sort(connections, (o1, o2) -> (o1[2] - o2[2]));
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            int weight = connection[2];

            if (uf.connected(from, to)) {
                continue;
            }

            uf.union(from, to);
            res += weight;
        }

        return uf.getCount() == 2 ? res : -1;
    }

    private class UF {
        private int count;
        private int[] parent;

        public UF(int n) {
            this.count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            
            parent[rootP] = rootQ;
            count--;
        }

        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return true;
            }

            return false;
        }
        private int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }

            return parent[i];
        }

        public int getCount() {
            return count;
        }
    }
}
