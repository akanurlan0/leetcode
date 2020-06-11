class Solution {
    public boolean isPowerOfTwo(int n) {
        
        if (n < 1) return false;
        
        boolean good = true;
        while (n > 0) {
            int r = n & 1;
            n = n >> 1;
            good = good && ( (r == 0) || ( n == 0 && r == 1 ) );
        }
        
        return good;
    }
}