package array_linked_list;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// 397. Integer Replacement
public class Solution397 {
    public int integerReplacement(int n) {
        Set<Long> set = new HashSet<>();
        Queue<Long> queue = new LinkedList<>();
        queue.add(((long)n));
        set.add((long)n);
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                long ele = queue.poll();
                if(ele == 1){
                    return step;
                }
                if(ele % 2 == 0) {
                    long next = ele / 2;
                    if (!set.contains(next)) {
                        queue.add(next);
                        set.add(next);
                    }
                } else {
                    for(int diff : new int[]{-1, 1}) {
                        long next = ele + diff;
                        if (!set.contains(next)) {
                            queue.add(next);
                            set.add(next);
                        }
                    }
                }
            }

            step++;
        }

        return -1;
    }
}
