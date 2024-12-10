package array_linked_list;

import java.util.Arrays;

// 406. Queue Reconstruction by Height
public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        int[][] res = new int[n][];
        Arrays.sort(people, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        for(int i = 0; i < n; i++){
            int[] pair = people[i];
            int skips = pair[1];
            int height = pair[0];

            int j = 0;
            while(skips > 0){
                if(res[j] == null){
                    skips--;
                } else if(res[j][0] >= height){
                    skips--;
                }

                j++;
            }
            while(res[j] != null){
                j++;
            }

            res[j] = pair;
        }

        return res;
    }
}
