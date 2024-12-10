package trie;

public class Solution677 {
    private static class MapSum {
        private static class TrieNode {
            public int val;
            public TrieNode[] chilren = new TrieNode[26];
        }

        private TrieNode root;
        public MapSum() {

        }

        public void insert(String key, int val) {
            root = insert(root, key, 0, val);
        }

        private TrieNode insert(TrieNode node, String key, int index, int val) {
            if(node == null){
                node = new TrieNode();
            }
            if(index == key.length()) {
                node.val = val;
            } else {
                char c = key.charAt(index);
                node.chilren[c-'a'] = insert(node.chilren[c-'a'], key, index+1, val);
            }

            return node;
        }

        public int sum(String prefix) {
            TrieNode p = root;
            if(p == null){
                return 0;
            }
            for(int i = 0; i < prefix.length(); i++){
                char c = prefix.charAt(i);
                p = p.chilren[c-'a'];
                if(p == null){
                    return 0;
                }
            }

            return sumDivide(p);
        }

        private int sumDivide(TrieNode node) {
            if(node == null){
                return 0;
            }

            int count = node.val;
            for(int i = 0; i < 26; i++){
                count += sumDivide(node.chilren[i]);
            }

            return count;
        }
    }
}
