class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 0;
        
        int result = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i-1] < prices[i]) {
                r = i;
            } else {
                result += prices[r] - prices[l];
                l = i;
                r = i;
            }
        }
        
        return result + (prices[r] - prices[l]);
    }
}