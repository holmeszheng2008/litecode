package dp;

import java.util.Arrays;

// 354. Russian Doll Envelopes
public class Solution354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> {
            return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
        });

        int[] dp = new int[envelopes.length];
        int res = 0;
        for (int i = 0; i < envelopes.length; i++) {
            int preMax = 0;
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    preMax = Math.max(preMax, dp[j]);
                }
            }

            dp[i] = 1 + preMax;
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
