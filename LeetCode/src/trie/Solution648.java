package trie;

import java.util.List;

// 648. Replace Words
public class Solution648 {
    private static class Trie{
        private static class TrieNode {
            public Object val;
            public TrieNode[] children = new TrieNode[26];
        }

        private TrieNode root;
        public void add(String str){
            this.root = add(root, str, 0);
        }

        private TrieNode add(TrieNode node, String str, int index){
            if(node == null){
                node = new TrieNode();
            }
            if(index == str.length()){
                node.val = new Object();
            } else {
                char c = str.charAt(index);
                node.children[c-'a'] = add(node.children[c-'a'], str, index+1);
            }

            return node;
        }

        public String getShortestPrefixKey(String str){
            if(root == null){
                return "";
            }
            TrieNode p = root;
            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                p = p.children[c-'a'];

                if (p == null){
                    return "";
                }
                if(p.val != null){
                    return str.substring(0, i+1);
                }
            }

            return "";
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for(String str : dictionary){
            trie.add(str);
        }
        StringBuilder sb = new StringBuilder();
        String[] strings = sentence.split(" ");
        for(int i = 0; i < strings.length; i++){
            String str = strings[i];
            String shortestPrefix = trie.getShortestPrefixKey(str);
            if(shortestPrefix.length() == 0){
                sb.append(str);
            } else {
                sb.append(shortestPrefix);
            }
            if(i != strings.length - 1){
                sb.append(' ');
            }
        }

        return sb.toString();
    }
}
