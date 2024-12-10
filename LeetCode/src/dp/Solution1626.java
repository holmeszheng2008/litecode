package dp;

import java.util.Arrays;

// 1626. Best Team With No Conflicts
public class Solution1626 {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;

        // 0 age, 1 score
        int[][] compositeValues = new int[n][2];
        for(int i = 0; i < n; i++){
            compositeValues[i] = new int[]{ages[i], scores[i]};
        }

        Arrays.sort(compositeValues, (o1, o2) -> {
            if(o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        // 0 ... n-1
        int[] dp = new int[n];

        dp[0] = compositeValues[0][1];
        int ans = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = compositeValues[i][1];
            for(int j = 0; j < i; j++){
                if(compositeValues[j][1] <= compositeValues[i][1]){
                    dp[i] = Math.max(dp[i], dp[j] + compositeValues[i][1]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}


class Solution1626_attempt1 {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] values = new int[n][2];
        for(int i = 0; i < n; i++){
            values[i] = new int[]{ages[i], scores[i]};
        }

        Arrays.sort(values, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        int[] dp = new int[n];
        dp[0] = values[0][1];
        int res = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = values[i][1];
            for(int j = 0; j < i; j++){
                if(values[j][1] <= values[i][1]){
                    dp[i] = Math.max(dp[i], dp[j] + values[i][1]);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}