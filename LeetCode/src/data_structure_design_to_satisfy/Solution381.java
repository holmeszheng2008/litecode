package data_structure_design_to_satisfy;

import java.util.*;

// 381. Insert Delete GetRandom O(1) - Duplicates allowed
public class Solution381 {
    class RandomizedCollection {
        private int count = 0;
        private Map<Integer, Integer> indexToValueMap = new HashMap<>();
        private Map<Integer, Set<Integer>> valueToIndexListMap = new HashMap<>();
        private Random randomer = new Random();

        public RandomizedCollection() {

        }

        public boolean insert(int val) {
            Set<Integer> indexList = valueToIndexListMap.get(val);
            count++;
            if(indexList == null){
                indexList = new HashSet<>();
                valueToIndexListMap.put(val, indexList);
                indexList.add(count);
                indexToValueMap.put(count, val);

                return true;
            } else {
                indexList.add(count);
                indexToValueMap.put(count, val);

                return false;
            }
        }

        public boolean remove(int val) {
            Set<Integer> indexList = valueToIndexListMap.get(val);
            if(indexList == null){
                return false;
            }

            int indexToRemove = indexList.iterator().next();
            indexList.remove(indexToRemove);
            indexToValueMap.remove(indexToRemove);
            if(indexList.isEmpty()){
                valueToIndexListMap.remove(val);
            }
            if(indexToRemove != count){
                int valAtCount = indexToValueMap.get(count);
                indexToValueMap.remove(count);
                indexToValueMap.put(indexToRemove, valAtCount);

                Set<Integer> indexListAtCount = valueToIndexListMap.get(valAtCount);
                indexListAtCount.remove(count);
                indexListAtCount.add(indexToRemove);

            }

            count--;

            return true;
        }

        public int getRandom() {
            int randomIndex = randomer.nextInt(1, count+1);
            return indexToValueMap.get(randomIndex);
        }
    }

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
