package misc.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 118. Pascal's Triangle
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            int eleNum = i + 1;
            List<Integer> list = new ArrayList<>();
            List<Integer> lastList = res.get(res.size() - 1);
            for (int j  =0; j < eleNum; j++) {
                int a = ((j - 1 < 0) ? 0 : lastList.get(j - 1));
                int b = ((j == lastList.size()) ? 0 : lastList.get(j));
                list.add(a + b);
            }

            res.add(list);
        }

        return res;
    }
}

class Solution118_attempt1 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<Integer> level = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i) {
                    level.add(1);
                } else {
                    List<Integer> lastLevel = res.get(i-1);
                    level.add(lastLevel.get(j-1) + lastLevel.get(j));
                }
            }
            res.add(level);
        }

        return res;
    }
}