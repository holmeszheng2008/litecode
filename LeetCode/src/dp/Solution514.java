package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 514. Freedom Trail
public class Solution514 {
    private String ring;
    private String key;
    private Integer[][] memo;
    private Map<Character, List<Integer>> charToInexsMap = new HashMap<>();

    public int findRotateSteps(String ring, String key) {
        this.ring = ring;
        this.key = key;

        this.memo = new Integer[ring.length()][key.length()];
        for (int i = 0; i < ring.length(); i++) {
            char c = ring.charAt(i);
            if (!charToInexsMap.containsKey(c)) {
                charToInexsMap.put(c, new ArrayList<>());
            }
            charToInexsMap.get(c).add(i);
        }

        return dp(0, 0);
    }

    private int dp(int i, int j) {
        if (j == key.length()) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int res = Integer.MAX_VALUE;
        for (int k : charToInexsMap.get(key.charAt(j))) {
            int diff = Math.abs(i - k);
            diff = Math.min(diff, ring.length() - diff);
            int next = dp(k, j + 1);
            res = Math.min(res, diff + 1 + next);
        }

        memo[i][j] = res;
        return res;
    }
}


// Wrong, cases goes back and forth
class Solution514_wrong {
    private String ring;
    private String key;
    private Integer[][] memo;

    public int findRotateSteps(String ring, String key) {
        this.ring = ring;
        this.key = key;

        this.memo = new Integer[ring.length()][key.length()];

        return dp(0, 0);
    }

    private int dp(int m, int n) {
        if (n == key.length()) {
            return 0;
        }
        if (m == -1) {
            m = ring.length() - 1;
        }

        if (m == ring.length()) {
            m = 0;
        }
        if (memo[m][n] != null) {
            return memo[m][n];
        }

        int res = Integer.MAX_VALUE;
        if (ring.charAt(m) == key.charAt(n)) {
            res = 1 + dp(m, n + 1);
        } else {
            res = 1 + Math.min(dp(m + 1, n), dp(m - 1, n));
        }

        memo[m][n] = res;
        return res;
    }

}
