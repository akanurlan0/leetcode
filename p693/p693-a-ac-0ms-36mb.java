class Solution {
    public boolean hasAlternatingBits(int n) {
        
        int previous = -1;
        
        while (n > 0) {
            int b = n & 1;
            if (b == previous) {
                return false;
            }
            previous = b;
            n = n >> 1;
        }
        
        return true;
    }
}