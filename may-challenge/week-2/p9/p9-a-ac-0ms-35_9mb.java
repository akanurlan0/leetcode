class Solution {
    public boolean isPerfectSquare(int num) {
        
        int l = 1;
        int r = num;
        while (l <= r) {
            
            int m = l + ((r - l)/2);
            
            int p = num / m;
            int rem = num % m;
            
            if (p == m && rem == 0) {
                return true;
            }
            
            if (p < m) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        
        return false;
    }
}