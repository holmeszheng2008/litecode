package trie;

// 1804. Implement Trie II (Prefix Tree)
public class Solution1804 {
    private class Trie {
        private static class TrieNode {
            public int val;
            public TrieNode[] children = new TrieNode[26];
        }

        private TrieNode root;

        public Trie(){}

        public void insert(String word){
            root = insert(root, word, 0);
        }

        private TrieNode insert(TrieNode node, String word, int index){
            if(node == null){
                node = new TrieNode();
            }
            if(index == word.length()) {
                node.val++;
            } else {
                int c = word.charAt(index);
                node.children[c-'a'] = insert(node.children[c-'a'], word, index+1);
            }

            return node;
        }

        public int countWordsEqualTo(String word){
            TrieNode p = root;
            if(p == null){
                return 0;
            }
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                p = p.children[c-'a'];
                if(p == null){
                    return 0;
                }
            }

            return p.val;
        }
        public int countWordsStartingWith(String prefix){
            TrieNode p = root;
            if(p == null){
                return 0;
            }
            for(int i = 0; i < prefix.length(); i++){
                char c = prefix.charAt(i);
                p = p.children[c-'a'];
                if(p == null){
                    return 0;
                }
            }

            return countWordsStartingWithDivide(p);
        }

        private int countWordsStartingWithDivide(TrieNode node){
            if(node == null){
                return 0;
            }
            int count = 0;
            for(int i = 0; i < 26; i++){
                count += countWordsStartingWithDivide(node.children[i]);
            }

            count += node.val;

            return count;
        }

        public void erase(String word){
            root = erase(root, word, 0);
        }

        private TrieNode erase(TrieNode node, String word, int index){
            if(node == null){
                return null;
            }
            if(index == word.length()) {
                node.val--;
            } else {
                int c = word.charAt(index);
                node.children[c - 'a'] = erase(node.children[c - 'a'], word, index + 1);
            }

            if(node.val > 0){
                return node;
            }

            for(int i = 0; i < 26; i++){
                if(node.children[i] != null){
                    return node;
                }
            }

            return null;
        }
    }
}
