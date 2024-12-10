package data_structure_design_to_satisfy;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

// 352. Data Stream as Disjoint Intervals
public class Solution352 {
    class SummaryRanges {
        private TreeSet<Integer> stream = new TreeSet<>();
        public SummaryRanges() {

        }

        public void addNum(int value) {
            stream.add(value);
        }

        public int[][] getIntervals() {
            List<int[]> res = new ArrayList<>();
            int left = -1, pre = -1;
            for(int num : stream){
                if(left == -1){
                    left = num;
                } else {
                    if(num == pre + 1){

                    } else {
                        res.add(new int[]{left, pre});
                        left = num;
                    }
                }

                pre = num;
            }

            res.add(new int[]{left, pre});

            return res.stream().toArray(int[][]::new);
        }
    }
}
