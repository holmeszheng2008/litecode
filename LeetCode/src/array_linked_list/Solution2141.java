package array_linked_list;

import java.util.Arrays;

// 2141. Maximum Running Time of N Computers
public class Solution2141 {
    public long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);
        int[] live = Arrays.copyOfRange(batteries, batteries.length - n, batteries.length);

        long extra = 0;
        for(int i = 0; i < batteries.length - n; i++){
            extra += batteries[i];
        }
        long runTime = 0;
        for(int i = 0; i < n-1; i++){
            long nextExtra = extra - ((long)(i+1)) * (live[i+1] - live[i]);
            if(nextExtra >= 0) {
                runTime = live[i+1];
            } else {
                return extra / (i+1) + live[i];
            }

            extra = nextExtra;
        }

        return live[n-1] + extra / n;
    }
}
