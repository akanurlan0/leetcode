class Solution {
    public int binaryGap(int n) {
        
        int max = 0;
        int localMax = 0;
        boolean oneDigitIsMet = false;
        
        while (n > 0) {
            
            int b = n & 1;
            
            if (b == 0) {
                localMax++;
            } else {
                if (oneDigitIsMet && localMax > max) {
                    max = localMax;
                }
                localMax = 1;
                oneDigitIsMet = true;
            }
            
            n = n >> 1;
        }

        return max;
        
    }
}