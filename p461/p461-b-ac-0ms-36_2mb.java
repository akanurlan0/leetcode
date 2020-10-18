class Solution {
    public int hammingDistance(int x, int y) {
        
        int xor = x ^ y;
        int distance = 0;
        
        while (xor > 0) {
            int a = xor & 1;
            if (a == 1) distance++;
            xor = xor >> 1;
        }
        
        return distance;
    }
}