package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 787. Cheapest Flights Within K Stops
public class Solution787 {
    private Map<Integer, List<int[]>> fromToTos = new HashMap<>();
    private Integer[][] memo;
    private int dst;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        for (int[] i : flights) {
            int from = i[0];
            int to = i[1];
            int price = i[2];
            List<int[]> tos = null;
            if (fromToTos.containsKey(from)) {
                tos = fromToTos.get(from);
            } else {
                tos = new ArrayList<>();
                fromToTos.put(from, tos);
            }
            tos.add(new int[] {to, price});
        }

        this.memo = new Integer[n][k + 1];
        this.dst = dst;

        int res = dp(src, k);
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

    private int dp(int src, int k) {
        if (src == dst) {
            return 0;
        }
        if (k == -1) {
            return Integer.MAX_VALUE;
        }

        if (memo[src][k] != null) {
            return memo[src][k];
        }

        List<int[]> tos = fromToTos.get(src);
        int res = Integer.MAX_VALUE;
        if (tos != null) {
            for (int[] toArray : tos) {
                int subRes = dp(toArray[0], k - 1);
                if (subRes != Integer.MAX_VALUE) {
                    res = Math.min(res, subRes + toArray[1]);
                }
            }
        }
        

        memo[src][k] = res;
        return res;
    }
}

class Solution787_attempt1 {
    private Integer[][] memo;
    private List<int[]>[] flightGraph;
    private int dst;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        this.memo = new Integer[n][k+2];
        this.dst = dst;

        flightGraph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            flightGraph[i] = new ArrayList<>();
        }
        for(int i = 0; i < flights.length; i++){
            int[] flight = flights[i];
            flightGraph[flight[0]].add(new int[]{flight[1], flight[2]});
        }

        int res = dp(src, k+1);
        return  (res == Integer.MAX_VALUE) ? -1 : res;
    }

    private int dp(int cityIndex, int stepLeft){
        if(cityIndex == dst && stepLeft >= 0){
            return 0;
        }

        if(stepLeft == 0){
            return Integer.MAX_VALUE;
        }

        if(memo[cityIndex][stepLeft] != null){
            return memo[cityIndex][stepLeft];
        }

        int res = Integer.MAX_VALUE;
        for(int[] flight : flightGraph[cityIndex]){
            int tempRes = dp(flight[0], stepLeft - 1);
            if(tempRes != Integer.MAX_VALUE){
                res = Math.min(res, tempRes + flight[1]);
            }
        }

        memo[cityIndex][stepLeft] = res;
        return res;
    }
}