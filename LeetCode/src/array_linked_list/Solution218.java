package array_linked_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// 218. The Skyline Problem
public class Solution218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        int[][] points = new int[n + n][2];
        int i = 0;
        for(int[] building : buildings){
            points[i] = new int[]{building[0], building[2]};
            points[i+1] = new int[]{building[1], -building[2]};
            i+=2;
        }
        Arrays.sort(points, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return o2[1] - o1[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        pq.offer(0);
        int preH = -1;

        for(int[] point : points){
            if(point[1] >= 0){
                pq.offer(point[1]);
            } else {
                pq.remove(-point[1]);
            }

            int curH = pq.peek();
            if(preH != curH){
                res.add(Arrays.asList(point[0], curH));

                preH = curH;
            }
        }
        return res;

    }
}


class Solution218_copy {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        int[][] points = new int[n + n][2];
        int i = 0;
        for(int[] b: buildings){
            points[i] = new int[]{b[0], b[2]}; // start point: +height
            points[i + 1] = new int[]{b[1], -b[2]}; // end point: -height
            i += 2;
        }

        //sort points by x coordinate
        Arrays.sort(points, (a, b)->{
            if(a[0] == b[0]){
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });

        // max height on top
        PriorityQueue<Integer> maxH = new PriorityQueue<Integer>((a, b)->{
            return b - a;
        });
        maxH.offer(0);
        List<List<Integer>> res = new ArrayList<>();

        int preH = -1;
        for(int[] p: points){
            if(p[1] > 0){
                maxH.offer(p[1]);
            } else {
                maxH.remove(-p[1]);
            }

            int curH = maxH.peek();
            if(preH == curH) continue;
            preH = curH;
            res.add(Arrays.asList(p[0], curH));
        }
        return res;
    }
}
