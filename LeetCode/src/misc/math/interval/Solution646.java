package misc.math.interval;

import java.util.Arrays;

// 646. Maximum Length of Pair Chain
// Greedy
public class Solution646 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (o1, o2) -> o1[1] - o2[1]);
        int res = 1;
        int preEnd = pairs[0][1];
        for(int i = 1; i < pairs.length; i++){
            if(pairs[i][0] > preEnd){
                res++;
                preEnd = pairs[i][1];
            }
        }

        return res;
    }
}

// DP
class Solution646_attempt1 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (o1, o2) -> o1[0] - o2[0]);
        int n = pairs.length;
        int res = 0;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(pairs[j][1] < pairs[i][0]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }

            res = Math.max(res, dp[i]);
        }

        return res;
    }
}