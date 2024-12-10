package dp;

// 121. Best Time to Buy and Sell Stock
public class Solution121 {
    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < buyPrice) {
                buyPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - buyPrice);
            }
        }

        return maxProfit;
    }
}

class Solution121_attempt1 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int buyPrice = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < buyPrice){
                buyPrice = prices[i];
            } else {
                res = Math.max(res, prices[i] - buyPrice);
            }
        }

        return res;
    }
}