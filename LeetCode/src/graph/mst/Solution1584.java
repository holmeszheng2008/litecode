package graph.mst;

import java.util.ArrayList;
import java.util.List;

// 1584. Min Cost to Connect All Points
public class Solution1584 {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int weight = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[] {i, j, weight});
            }
        }

        edges.sort((o1, o2) -> (o1[2] - o2[2]));

        UF uf = new UF(n);
        int res = 0;
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];

            if (uf.connected(from, to)) {
                continue;
            }

            uf.union(from, to);
            res += weight;
        }

        return uf.getCount() == 1 ? res : -1;
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
