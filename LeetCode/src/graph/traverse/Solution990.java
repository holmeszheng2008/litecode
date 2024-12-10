package graph.traverse;

public class Solution990 {
    public boolean equationsPossible(String[] equations) {
        UF uf = new UF();
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                uf.union(equation.charAt(0), equation.charAt(3));
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                if (uf.connected(equation.charAt(0), equation.charAt(3))) {
                    return false;
                }
            }
        }

        return true;
    }
    class UF {
        private int[] parent;

        public UF() {
            parent = new int[26];
            for (int i = 0; i < 26; i++) {
                parent[i] = i;
            }
        }

        public void union(char i, char j) {
            int iRoot = find(i - 'a');
            int jRoot = find(j - 'a');

            if (iRoot == jRoot) {
                return;
            }
            parent[iRoot] = jRoot;
        }

        public boolean connected(char i, char j) {
            int iRoot = find(i - 'a');
            int jRoot = find(j - 'a');

            if (iRoot == jRoot) {
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
    }

}

