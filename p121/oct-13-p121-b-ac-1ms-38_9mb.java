class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        int n = prices.length;
        if (n == 0) return maxProfit;
        
        int maxVal = prices[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            
            maxProfit = Math.max(maxProfit, maxVal - prices[i]);
            maxVal = Math.max(maxVal, prices[i]);
        }
        
        return maxProfit;
    }
}