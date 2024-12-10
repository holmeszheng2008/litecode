package string;

import java.util.*;

// 127. Word Ladder
public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> newList = new ArrayList<>();
        newList.add(beginWord);
        newList.addAll(wordList);

        Set<Integer>[] graph = new Set[newList.size()];
        for(int i = 0; i < graph.length;i++){
            graph[i] = new HashSet<>();
        }

        int endWordIndex = -1;

        for(int i = 0; i < beginWord.length(); i++){
            Map<String, Set<Integer>> map = new HashMap<>();

            for(int j = 0; j < newList.size(); j++){
                String word = newList.get(j);
                if(endWordIndex == -1){
                    if(word.equals(endWord)){
                        endWordIndex = j;
                    }
                }
                String newStr = word.substring(0, i) + word.substring(i+1);
                Set<Integer> set = map.get(newStr);
                if(set == null){
                    set = new HashSet<>();
                    map.put(newStr, set);
                }
                set.add(j);
            }

            for(Set<Integer> value : map.values()){
                if(value.size() > 1){
                    for(int k : value){
                        Set<Integer> copySet = new HashSet(value);
                        copySet.remove(k);
                        Set<Integer> adjSet = graph[k];
                        adjSet.addAll(copySet);
                    }
                }
            }
        }

        if(endWordIndex == -1){
            return 0;
        }
        boolean[] visited = new boolean[newList.size()];
        int step = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int node = queue.poll();
                if(node == endWordIndex){
                    return step + 1;
                }
                Set<Integer> nextNodes = graph[node];
                for(int nextNode : nextNodes){
                    if(!visited[nextNode]) {
                        visited[nextNode] = true;
                        queue.add(nextNode);
                    }
                }
            }
            step++;
        }

        return 0;
    }
}
