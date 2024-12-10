package array_linked_list.two_pointers.sliding_window;

import java.util.HashMap;
import java.util.Map;

// 904. Fruit Into Baskets
public class Solution904 {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int max = 0;

        while(right < fruits.length){
            int in = fruits[right];
            right++;
            window.put(in, window.getOrDefault(in, 0) + 1);
            if(window.size() <= 2){
                max = Math.max(max, right - left);
            } else {
                while(window.size() != 2){
                    int out = fruits[left];
                    left++;
                    int count = window.get(out) - 1;
                    if(count == 0){
                        window.remove(out);
                    } else {
                        window.put(out, count);
                    }
                }

                max = Math.max(max, right - left);
            }
        }

        return max;
    }
}
