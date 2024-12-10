package data_structure_design_to_satisfy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 895. Maximum Frequency Stack
public class Solution895 {
    class FreqStack {
        private int maxFreq;
        private Map<Integer, Stack<Integer>> map;
        private Map<Integer, Integer> numToItsMaxFreqMap;
        public FreqStack() {
            this.maxFreq = 0;
            this.map = new HashMap<>();
            this.numToItsMaxFreqMap = new HashMap<>();
        }

        public void push(int val) {
            int itsMaxFreq = numToItsMaxFreqMap.getOrDefault(val, 0);
            itsMaxFreq++;

            Stack<Integer> stack = map.get(itsMaxFreq);
            if (stack == null) {
                stack = new Stack<>();
                map.put(itsMaxFreq, stack);
                maxFreq = itsMaxFreq;
            }

            stack.push(val);
            numToItsMaxFreqMap.put(val, itsMaxFreq);
        }

        public int pop() {
            Stack<Integer> stack = map.get(maxFreq);
            int val = stack.pop();
            if(stack.isEmpty()){
                map.remove(maxFreq);
                maxFreq--;
            }

            int itsMaxFreq = numToItsMaxFreqMap.get(val);
            itsMaxFreq--;
            if(itsMaxFreq == 0){
                numToItsMaxFreqMap.remove(val);
            } else {
                numToItsMaxFreqMap.put(val, itsMaxFreq);
            }

            return val;
        }
    }
}
