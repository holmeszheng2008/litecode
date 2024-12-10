package misc;

import java.util.HashSet;
import java.util.Set;

public class Solution522 {
    private class Pair<K, V> {
        public K first;
        public V second;
        public Pair(K first, V second){
            this.first = first;
            this.second = second;
        }
    }
    public int findLUSlength(String[] strs) {
        Pair<Integer, Set>[] pairs = new Pair[11];
        for(String str : strs){
            Pair<Integer, Set> pair = pairs[str.length()];
            if(pair == null){
                Set<String> set = new HashSet<>();
                pair = new Pair<>(0, set);
                pairs[str.length()] = pair;
            }
            pair.second.add(str);
            pair.first++;
        }
        for(int i = 10; i >= 1; i--){
            if(pairs[i] == null) {
                continue;
            }
            if(pairs[i].second.size() == 1){
                if(pairs[i].first == 1) {
                    return i;
                } else {
                    continue;
                }
            }
            return i;
        }

        return -1;
    }
}