package misc.math;

import java.util.ArrayList;
import java.util.List;

public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> lastLevel = null;

        for(int i = 0; i <= rowIndex; i++){
            List<Integer> level = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    level.add(1);
                } else {
                    level.add(lastLevel.get(j-1) + lastLevel.get(j));
                }
            }

            lastLevel = level;
        }

        return lastLevel;
    }
}
