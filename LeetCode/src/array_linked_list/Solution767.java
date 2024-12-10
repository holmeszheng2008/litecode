package array_linked_list;

import java.util.PriorityQueue;

// 767. Reorganize String
public class Solution767 {
    public String reorganizeString(String s) {
        char[] sArray = s.toCharArray();
        int[] count = new int[26];
        for(char c : sArray){
            count[c-'a']++;
        }

        // 0 -> count
        // 1 -> index
        PriorityQueue<int[]> pq = new PriorityQueue<>((o2, o1) -> o1[0] - o2[0]);
        for(int i = 0; i < 26; i++){
            if(count[i] != 0){
                pq.add(new int[]{count[i], i});
            }
        }
        StringBuilder sb = new StringBuilder();
        char pre = '1';
        while(!pq.isEmpty()){
            int[] first = pq.poll();
            if(first[1] + 'a' != pre) {
                sb.append((char) (first[1] + 'a'));
                pre = (char)(first[1] + 'a');
                first[0]--;
                if (first[0] != 0) {
                    pq.add(first);
                }
            } else {
                if(pq.isEmpty()) {
                    return "";
                } else {
                    int[] second = pq.poll();
                    sb.append((char)(second[1] + 'a'));
                    pre = (char)(second[1] + 'a');
                    second[0]--;
                    if(second[0] != 0){
                        pq.add(second);
                    }
                    pq.add(first);
                }
            }
        }

        return sb.toString();
    }
}
