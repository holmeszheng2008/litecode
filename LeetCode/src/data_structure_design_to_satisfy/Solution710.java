package data_structure_design_to_satisfy;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// 710. Random Pick with Blacklist
public class Solution710 {
    public static class Solution {
        private Random random = new Random();
        private Map<Integer, Integer> redirectMap = new HashMap<>();
        private int size;
        public Solution(int n, int[] blacklist) {
            int last = n - 1;
            size = n - blacklist.length;
            for (int hole : blacklist) {
                redirectMap.put(hole, 0);
            }
            for (int hole : blacklist) {
                if (hole >= size) {
                    continue;
                }
                while (redirectMap.containsKey(last)) {
                    last--;
                }
                redirectMap.put(hole, last);
                last--;
            }
        }

        public int pick() {
            int index = random.nextInt(size);
            return redirectMap.containsKey(index) ? redirectMap.get(index) : index;
        }
    }
}
