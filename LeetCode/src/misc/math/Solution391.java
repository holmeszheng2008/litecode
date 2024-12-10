package misc.math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 391. Perfect Rectangle
public class Solution391 {
    public boolean isRectangleCover(int[][] rectangles) {
        int actualSize = 0;
        Set<List<Integer>> oddVertices = new HashSet<>();
        int xm = Integer.MAX_VALUE, ym = Integer.MAX_VALUE;
        int am = Integer.MIN_VALUE, bm = Integer.MIN_VALUE;
        for(int[] rectangle : rectangles){
            int x = rectangle[0], y = rectangle[1], a = rectangle[2], b = rectangle[3];

            xm = Integer.min(xm, x);
            ym = Integer.min(ym, y);
            am = Integer.max(am, a);
            bm = Integer.max(bm, b);

            actualSize += (a-x) * (b-y);

            Integer[][] vertices = new Integer[][] {
                    {x, y},
                    {x, b},
                    {a, b},
                    {a, y}
            };
            for(Integer[] vertex : vertices){
                List<Integer> list = Arrays.asList(vertex);
                if(oddVertices.contains(list)) {
                    oddVertices.remove(list);
                } else {
                    oddVertices.add(list);
                }
            }
        }

        int expectedSize = (am - xm) * (bm - ym);

        if(actualSize != expectedSize) {
            return false;
        }
        if(oddVertices.size() != 4) {
            return false;
        }

        if (!oddVertices.contains(Arrays.asList(xm, ym))) {
            return false;
        }
        if (!oddVertices.contains(Arrays.asList(xm, bm))) {
            return false;
        }
        if (!oddVertices.contains(Arrays.asList(am, bm))) {
            return false;
        }
        if (!oddVertices.contains(Arrays.asList(am, ym))) {
            return false;
        }

        return true;
    }
}
