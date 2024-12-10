package data_structure_design_to_satisfy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// 380. Insert Delete GetRandom O(1)
public class Solution380 {
    public class RandomizedSet {
        // key -> index
        private Random random = new Random();
        private Map<Integer, Integer> keyToIndex = new HashMap<>();
        private List<Integer> array = new ArrayList<>();

        public RandomizedSet() {
        }
        public boolean insert(int val) {
            if (keyToIndex.containsKey(val)) {
                return false;
            }
            int index = array.size();
            array.add(val);
            keyToIndex.put(val, index);

            return true;
        }
        public boolean remove(int val) {
            if (keyToIndex.containsKey(val)) {
                int index = keyToIndex.get(val);
                if (index == keyToIndex.size() - 1) {
                    array.remove(index);
                    keyToIndex.remove(val);
                } else {
                    int lastIndex = keyToIndex.size() - 1;
                    array.set(index, array.get(lastIndex));
                    array.remove(lastIndex);
                    keyToIndex.remove(val);
                    keyToIndex.put(array.get(index), index);
                }
                return true;
            } else {
                return false;
            }
        }
        public int getRandom() {
            int index = random.ints(0, array.size()).findFirst().getAsInt();
            return array.get(index);
        }
    }
}
