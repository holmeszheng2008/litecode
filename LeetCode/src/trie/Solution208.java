package trie;

// 208. Implement Trie (Prefix Tree)
public class Solution208 {
    private class Trie {
        private TrieNode root;
        private static class TrieNode {
            public Object val;
            public TrieNode[] children = new TrieNode[26];
        }
        public Trie() {

        }

        public void insert(String word) {
            root = insert(root, word, 0);
        }

        private TrieNode insert(TrieNode node, String word, int i){
            if(node == null){
                node = new TrieNode();
            }
            if(i == word.length()){
                node.val = new Object();
            } else {
                char c = word.charAt(i);
                node.children[c-'a'] = insert(node.children[c-'a'], word, i+1);
            }

            return node;
        }

        public boolean search(String word) {
            TrieNode p = root;
            if(root == null){
                return false;
            }
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                p = p.children[c-'a'];
                if(p == null){
                    return false;
                }
            }

            return (p.val == null) ? false : true;
        }



        public boolean startsWith(String prefix) {
            TrieNode p = root;
            if(root == null){
                return false;
            }
            for(int i = 0; i < prefix.length(); i++){
                char c = prefix.charAt(i);
                p = p.children[c-'a'];
                if(p == null){
                    return false;
                }
            }

            if(p.val != null){
                return true;
            }
            for(int i = 0; i < 26; i++){
                if(p.children[i] != null) {
                    return true;
                }
            }

            return false;
        }
    }
}


class Solution208_attempt1 {
    class Trie {
        private class TrieNode {
            public Object value;
            public TrieNode[] children = new TrieNode[26];
        }

        private TrieNode root;
        public Trie() {

        }

        public void insert(String word) {
            root = doInsert(root, word, 0);
        }

        private TrieNode doInsert(TrieNode node, String word, int index) {
            if(node == null){
                node = new TrieNode();
            }
            if(index == word.length()){
                node.value = new Object();
                return node;
            }

            char c = word.charAt(index);
            node.children[c - 'a'] = doInsert(node.children[c - 'a'], word, index+1);

            return node;
        }

        public boolean search(String word) {
            return doSearch(root, word, 0);
        }

        private boolean doSearch(TrieNode node, String word, int index){
            if(node == null){
                return false;
            }

            if(index == word.length()){
                if(node.value == null){
                    return false;
                } else {
                    return true;
                }
            }

            char c = word.charAt(index);

            return doSearch(node.children[c-'a'], word, index+1);
        }

        public boolean startsWith(String prefix) {
            return doStartsWith(root, prefix, 0);
        }

        private boolean doStartsWith(TrieNode node, String prefix, int index){
            if(node == null){
                return false;
            }
            if(index == prefix.length()){
                if(node.value != null){
                    return true;
                }

                for(int i = 0; i < 26; i++){
                    if(node.children[i] != null){
                        return true;
                    }
                }

                return false;
            }

            char c = prefix.charAt(index);
            return doStartsWith(node.children[c-'a'], prefix, index+1);
        }
    }
}


class Solution208_attempt2 {
    class Trie {
        private TrieNode root;

        private static class TrieNode {
            public Object value;
            public TrieNode[] children;

            public TrieNode() {
                this.children = new TrieNode[26];
            }
        }
        public Trie() {

        }

        public void insert(String word) {
            root = doInsert(root, 0, word);
        }

        private TrieNode doInsert(TrieNode node, int i, String word){
            if(node == null){
                node = new TrieNode();
            }

            if(i == word.length()){
                node.value = new Object();
                return node;
            }

            char c = word.charAt(i);
            node.children[c-'a'] = doInsert(node.children[c-'a'], i+1, word);


            return node;
        }

        public boolean search(String word) {
            TrieNode node = root;
            if(root == null){
                return false;
            }
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                TrieNode nextNode = node.children[c-'a'];
                if(nextNode == null){
                    return false;
                }

                node = nextNode;
            }

            return node.value != null;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            if(root == null){
                return false;
            }
            for(int i = 0; i < prefix.length(); i++){
                char c = prefix.charAt(i);
                TrieNode nextNode = node.children[c-'a'];
                if(nextNode == null){
                    return false;
                }

                node = nextNode;
            }

            if(node.value != null){
                return true;
            }
            for(int i = 0; i < 26; i++){
                if(node.children[i] != null){
                    return true;
                }
            }

            return false;
        }
    }
}