package array_linked_list;

import java.util.TreeSet;

// 414. Third Maximum Number
public class Solution414 {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>((o1, o2) -> {
            if (o1.equals(o2)) {
                return 0;
            } else if (o1 < o2) {
                return -1;
            } else {
                return 1;
            }
        });
        for (int num : nums) {
            set.add(num);
            if(set.size() == 4){
                set.pollFirst();
            }
        }

        if(set.size() == 3){
            return set.first();
        }

        return set.last();
    }

}
