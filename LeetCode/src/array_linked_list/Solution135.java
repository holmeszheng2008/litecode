package array_linked_list;

import java.util.Arrays;

// 135. Candy
public class Solution135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left2right= new int[n];
        int[] right2left = new int[n];
        Arrays.fill(left2right, 1);
        Arrays.fill(right2left, 1);

        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]){
                left2right[i] = left2right[i-1] + 1;
            }
        }

        for(int i = n-1; i >= 1; i--){
            if(ratings[i-1] > ratings[i]) {
                right2left[i-1] = right2left[i] + 1;
            }
        }

        int res = 0;
        for(int i = 0; i < n; i++){
            res += Math.max(left2right[i], right2left[i]);
        }

        return res;
    }
}
