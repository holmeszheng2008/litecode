package array_linked_list;

import java.util.Arrays;

// 2144. Minimum Cost of Buying Candies With Discount
public class Solution2144 {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int total = 0;
        for(int i = cost.length - 1; i >= 0;){
            total += cost[i];
            i--;
            if(i >= 0){
                total += cost[i];
            }
            i-=2;
        }

        return total;
    }
}
