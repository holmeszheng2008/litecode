package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 212. Word Search II
public class Solution212 {
    private char[][] board;
    private boolean[][] onPath;
    private int m;
    private int n;
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        this.onPath = new boolean[m][n];

        List<String> res = new ArrayList<>();
        Map<Character, List<int[]>> charToCordMap = new HashMap<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                char c = board[i][j];
                List<int[]> list = charToCordMap.get(c);
                if(list == null){
                    list = new ArrayList<>();
                    charToCordMap.put(c, list);
                }
                list.add(new int[]{i, j});
            }
        }

        for(String word: words){
            char firstLetter = word.charAt(0);
            List<int[]> cords = charToCordMap.get(firstLetter);
            if(cords == null){
                continue;
            }
            for(int[] cord : cords){
                if(divide(cord[0], cord[1], 0, word)) {
                    res.add(word);
                    break;
                }
            }
        }

        return res;
    }

    private boolean divide(int i, int j, int index, String word){
        if(onPath[i][j]){
            return false;
        }

        onPath[i][j] = true;


        char c = word.charAt(index);
        if(c != board[i][j]){
            onPath[i][j] = false;
            return false;
        }

        if(index == word.length() - 1 && c == board[i][j]){
            onPath[i][j] = false;
            return true;
        }

        List<int[]> nextNodes = getNextNodes(i, j);
        for(int[] nextNode : nextNodes){
            boolean tempRes = divide(nextNode[0], nextNode[1], index + 1, word);
            if(tempRes){
                onPath[i][j] = false;
                return true;
            }
        }

        onPath[i][j] = false;
        return false;
    }

    private List<int[]> getNextNodes(int i, int j){
        List<int[]> res = new ArrayList<>();
        if (i != 0) {
            res.add(new int[]{i-1, j});
        }
        if(i != m-1){
            res.add(new int[]{i+1, j});
        }
        if(j != 0){
            res.add(new int[]{i, j-1});
        }
        if(j != n-1){
            res.add(new int[]{i, j+1});
        }

        return res;
    }
}


class Solution212_trie {
    private static class Trie {
        public static class TrieNode {
            public Object value;
            public TrieNode[] children = new TrieNode[26];
        }

        public TrieNode root;

        public Trie() {
        }

        public void addWord(String word){
            root = doAddWord(root, 0, word);
        }

        private TrieNode doAddWord(TrieNode node, int index, String word){
            if(node == null){
                node = new TrieNode();
            }

            if(index == word.length()){
                node.value = new Object();
                return node;
            }
            char c = word.charAt(index);
            node.children[c - 'a'] = doAddWord(node.children[c - 'a'], index + 1, word);

            return node;
        }
    }


    private Trie trie;
    private int m;
    private int n;
    private char[][] board;
    private List<String> res;
    private boolean[][] onPath;
    private StringBuilder path;
    public List<String> findWords(char[][] board, String[] words) {
        this.trie = new Trie();
        for(String word : words){
            trie.addWord(word);
        }

        this.board = board;
        this.m = board.length;
        this.n = board[0].length;

        this.onPath = new boolean[m][n];
        this.res = new ArrayList<>();
        this.path = new StringBuilder();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dfs(i, j, trie.root);
            }
        }

        return res;
    }

    private void dfs(int i, int j, Trie.TrieNode trieNode){
        if(i < 0 || i >= m || j < 0 || j >= n){
            return;
        }
        if(onPath[i][j]){
            return;
        }

        char c = board[i][j];

        Trie.TrieNode nextTrieNode = trieNode.children[c - 'a'];
        if(nextTrieNode == null){
            return;
        }

        onPath[i][j] = true;
        path.append(c);

        if(nextTrieNode.value != null){
            res.add(path.toString());
            nextTrieNode.value = null;
        }

        dfs(i-1, j, nextTrieNode);
        dfs(i+1, j, nextTrieNode);
        dfs(i, j -1, nextTrieNode);
        dfs(i, j+1, nextTrieNode);


        onPath[i][j] = false;
        path.deleteCharAt(path.length() - 1);
    }
}