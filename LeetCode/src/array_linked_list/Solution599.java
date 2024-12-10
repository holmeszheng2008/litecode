package array_linked_list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 599. Minimum Index Sum of Two Lists
public class Solution599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<Integer> indexList = null;
        int minSum = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            String str = list2[i];
            if (map.containsKey(str)) {
                int sum = map.get(str) + i;
                if (sum < minSum) {
                    minSum = sum;
                    indexList = new ArrayList<>();
                    indexList.add(i);
                } else if (sum == minSum) {
                    indexList.add(i);
                }
            }
        }
        return indexList.stream().map(i -> list2[i]).collect(Collectors.toList()).toArray(new String[0]);
    }
}
