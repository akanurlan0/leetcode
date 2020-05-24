class Solution {
    public int maxProfit(int[] prices) {
        
        int min = Integer.MAX_VALUE;
        int max = min;
        
        int res = 0;
        
        for (int i = 0 ; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                max = min;
            }
            if (prices[i] > max) {
                max = prices[i];
            }
            
            if (res < max - min) {
                res = max - min;
            }
        }
        
        return res;
    }
}