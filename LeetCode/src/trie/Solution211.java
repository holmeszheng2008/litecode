package trie;

public class Solution211 {
    private class WordDictionary {
        private static class TrieNode {
            public Object val;
            public TrieNode[] children = new TrieNode[26];
        }

        private static class PrimitiveWrapper<T> {
            public T val;

            public PrimitiveWrapper(T val) {
                this.val = val;
            }
        }

        private TrieNode root;

        public WordDictionary() {

        }

        public void addWord(String word) {
            root = addWord(root, word, 0);
        }

        private TrieNode addWord(TrieNode node, String word, int index) {
            if (node == null) {
                node = new TrieNode();
            }
            if (index == word.length()) {
                node.val = new Object();
            } else {
                char c = word.charAt(index);
                node.children[c - 'a'] = addWord(node.children[c - 'a'], word, index + 1);
            }

            return node;
        }

        public boolean search(String word) {
            if (root == null) {
                return false;
            }
            PrimitiveWrapper<Boolean> resGot = new PrimitiveWrapper<>(false);
            backtracking(root, word, 0, resGot);

            return resGot.val;
        }

        private void backtracking(TrieNode node, String word, int index, PrimitiveWrapper<Boolean> resGot) {
            char c = word.charAt(index);
            if (c == '.') {
                for (int i = 0; i < 26; i++) {
                    TrieNode nextNode = node.children[i];
                    if (nextNode == null) {
                        continue;
                    }
                    if (index + 1 == word.length()) {
                        if (nextNode.val != null) {
                            resGot.val = true;
                            return;
                        }
                    } else {
                        backtracking(nextNode, word, index + 1, resGot);
                        if (resGot.val) {
                            return;
                        }
                    }
                }
            } else {
                TrieNode nextNode = node.children[c - 'a'];
                if (nextNode == null) {
                    return;
                }
                if (index + 1 == word.length()) {
                    if (nextNode.val != null) {
                        resGot.val = true;
                    }
                    return;
                } else {
                    backtracking(nextNode, word, index + 1, resGot);
                    if (resGot.val) {
                        return;
                    }
                }
            }
        }
    }
}


class Solution211_attempt2 {
    private class WordDictionary {
        private static class TrieNode {
            public Object val;
            public TrieNode[] children = new TrieNode[26];
        }

        private TrieNode root;

        public WordDictionary() {

        }

        public void addWord(String word) {
            root = addWord(root, word, 0);
        }

        private TrieNode addWord(TrieNode node, String word, int index) {
            if (node == null) {
                node = new TrieNode();
            }
            if (index == word.length()) {
                node.val = new Object();
            } else {
                char c = word.charAt(index);
                node.children[c - 'a'] = addWord(node.children[c - 'a'], word, index + 1);
            }

            return node;
        }

        public boolean search(String word) {
            return searchDivide(root, word, 0);
        }

        private boolean searchDivide(TrieNode node, String word, int index) {
            if (node == null) {
                return false;
            }
            if (index == word.length()) {
                if (node.val != null) {
                    return true;
                } else {
                    return false;
                }
            }

            char c = word.charAt(index);
            if (c == '.') {
                for (int i = 0; i < 26; i++) {
                    if (searchDivide(node.children[i], word, index + 1)) {
                        return true;
                    }
                }

                return false;
            } else {
                return searchDivide(node.children[c - 'a'], word, index + 1);
            }
        }
    }
}

class Solution211_attempt1 {
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

            private TrieNode insert(TrieNode node, String word, int i) {
                if (node == null) {
                    node = new TrieNode();
                }
                if (i == word.length()) {
                    node.val = new Object();
                } else {
                    char c = word.charAt(i);
                    node.children[c - 'a'] = insert(node.children[c - 'a'], word, i + 1);
                }

                return node;
            }

            public boolean search(String word) {
                TrieNode p = root;
                if (root == null) {
                    return false;
                }
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    p = p.children[c - 'a'];
                    if (p == null) {
                        return false;
                    }
                }

                return (p.val == null) ? false : true;
            }


            public boolean startsWith(String prefix) {
                TrieNode p = root;
                if (root == null) {
                    return false;
                }
                for (int i = 0; i < prefix.length(); i++) {
                    char c = prefix.charAt(i);
                    p = p.children[c - 'a'];
                    if (p == null) {
                        return false;
                    }
                }

                if (p.val != null) {
                    return true;
                }
                for (int i = 0; i < 26; i++) {
                    if (p.children[i] != null) {
                        return true;
                    }
                }

                return false;
            }
        }
    }


    class Solution208_attempt2 {
        class Trie {
            private class TrieNode {
                public Object value;
                public TrieNode[] children = new TrieNode[26];
            }

            private TrieNode root;

            public Trie() {

            }

            public void addWord(String word) {
                root = doAddWord(root, word, 0);
            }

            private TrieNode doAddWord(TrieNode node, String word, int index) {
                if (node == null) {
                    node = new TrieNode();
                }
                if (index == word.length()) {
                    node.value = new Object();
                    return node;
                }

                char c = word.charAt(index);
                node.children[c - 'a'] = doAddWord(node.children[c - 'a'], word, index + 1);

                return node;
            }

            public boolean search(String word) {
                return doSearch(root, word, 0);
            }

            private boolean doSearch(TrieNode node, String word, int index) {
                if (node == null) {
                    return false;
                }
                if (index == word.length()) {
                    if (node.value == null) {
                        return false;
                    } else {
                        return true;
                    }
                }

                char c = word.charAt(index);
                if (c != '.') {
                    return doSearch(node.children[c - 'a'], word, index + 1);
                }

                for (int i = 0; i < 26; i++) {
                    if (doSearch(node.children[i], word, index + 1)) {
                        return true;
                    }
                }

                return false;
            }
        }
    }

}
class Solution211_attempt3 {

    class WordDictionary {
        private static class TrieNode {
            public Object value;
            public TrieNode[] children = new TrieNode[26];
        }

        private TrieNode root;
        public WordDictionary() {

        }

        public void addWord(String word) {
            root = doAdd(root, 0, word);
        }

        private TrieNode doAdd(TrieNode node, int index, String word){
            if(node == null){
                node = new TrieNode();
            }
            if(index == word.length()){
                node.value = new Object();
                return node;
            }

            char c = word.charAt(index);
            node.children[c - 'a'] = doAdd(node.children[c-'a'], index + 1, word);

            return node;
        }

        public boolean search(String word) {
            return doSearch(root, 0, word);
        }

        private boolean doSearch(TrieNode node, int index, String word){
            if(node == null){
                return false;
            }
            if(index == word.length()){
                if(node.value == null){
                    return false;
                }
                return true;
            }
            char c = word.charAt(index);
            if(c == '.'){
                for(int i = 0; i < 26; i++){
                    boolean tempRes = doSearch(node.children[i], index + 1, word);
                    if(tempRes){
                        return true;
                    }
                }
                return false;
            } else {
                return doSearch(node.children[c - 'a'], index + 1, word);
            }
        }
    }
}