// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        
        int maxProfit = 0;
        int minPrice = prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        
        return maxProfit;
    }
}
