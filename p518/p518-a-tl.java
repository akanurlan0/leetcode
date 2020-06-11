class Solution {
    
    private int[] coins;
    
    public int change(int amount, int[] coins) {

        Arrays.sort(coins);
        int n = coins.length;
        
        for (int i = 0; i < n / 2; i++) {
            int tmp = coins[i];
            coins[i] = coins[n - i - 1];
            coins[n - i - 1] = tmp;
        }
        this.coins = coins;
        
        int res = count(amount, 0);
        
        return res;
    }
    
    private int count(int amount, int index) {

        if (index == coins.length) {
            if (amount == 0) {
                return 1;
            }
            return 0;
        }
        
        int res = 0;
        
        int coin = coins[index];
        
        for (int i = 0; i <= amount / coin; i++) {
            res += count(amount - (i * coin), index + 1);
        }
        
        return res;
    }
}