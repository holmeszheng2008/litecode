package string;

import java.util.*;

//
public class Solution126 {
    private List<List<String>> res = new ArrayList<>();
    private Set<Integer>[] graph;
    private int endWordIndex = -1;
    private List<String> newList;
    private LinkedList<String> path = new LinkedList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        newList = new ArrayList<>();
        newList.add(beginWord);
        newList.addAll(wordList);

        this.graph = new Set[newList.size()];
        for(int i = 0; i < graph.length;i++){
            graph[i] = new HashSet<>();
        }

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
            return res;
        }

        int step = getSteps();
        if(step == 0){
            return res;
        }

        dfs(0, step);
        return res;
    }

    private int getSteps(){
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
                    return step;
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
    private void dfs(int node, int stepLeft){
        if(stepLeft == 0 && node != endWordIndex){
            return;
        }
        path.add(newList.get(node));
        if(node == endWordIndex) {
            res.add(new ArrayList<>(path));
        } else {
            Set<Integer> nextNodes = graph[node];
            for(int nextNode : nextNodes){
                dfs(nextNode, stepLeft - 1);
            }
        }

        path.removeLast();
    }
}

