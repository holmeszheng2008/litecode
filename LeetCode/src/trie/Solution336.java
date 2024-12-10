package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 336. Palindrome Pairs
public class Solution336 {
    private static class TrieNode {
        public int index;
        public List<Integer> list;
        public TrieNode[] children = new TrieNode[26];

        public TrieNode() {
            this.index = -1;
            this.list = new ArrayList<>();
        }
    }
    private TrieNode root;
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> palindromePairs(String[] words) {
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            root = addWord(root, i, word, word.length() - 1);
        }


        for(int i = 0; i < words.length; i++){
            String word = words[i];
            search(root, i, word, 0);
        }

        return res;
    }

    private TrieNode addWord(TrieNode node, int wordIndex, String word, int i){
        if(node == null){
            node = new TrieNode();
        }

        if(i == -1){
            node.index = wordIndex;
            return node;
        }

        char c = word.charAt(i);
        if(isPalindrome(word, 0, i)) {
            node.list.add(wordIndex);
        }

        node.children[c-'a'] = addWord(node.children[c-'a'], wordIndex, word, i-1);

        return node;
    }

    private void search(TrieNode node, int wordIndex, String word, int i){
        if(node == null){
            return;
        }

        if(node.index != -1 && node.index != wordIndex && isPalindrome(word, i, word.length() - 1)) {
            res.add(Arrays.asList(wordIndex, node.index));
        }

        if(i == word.length()){
            for(int j : node.list){
                res.add(Arrays.asList(wordIndex, j));
            }
            return;
        }

        char c = word.charAt(i);
        search(node.children[c - 'a'], wordIndex, word, i+1);
    }

    private boolean isPalindrome(String word, int i, int j){
        while(i <= j){
            if(word.charAt(i++) != word.charAt(j--)){
                return false;
            }
        }

        return true;
    }
}