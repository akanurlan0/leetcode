class Solution {
    
    private int[] bits;
    
    public boolean isOneBitCharacter(int[] bits) {
        
        this.bits = bits;
        int n = bits.length;
        
        boolean m2 = false;
        boolean m1 = false;
        boolean m0 = false;
        for (int i = 0; i < n - 1; i++) {
            boolean b1 = isCorrect(i, i) && ( i - 1 < 0 || m1 );
            boolean b2 = isCorrect(i-1, i) && ( i - 2 < 0 || m2 );
            m0 = b1 || b2;
            m2 = m1;
            m1 = m0;
        }
        
        int i = n-1;
        m0 = isCorrect(i, i) && ( i - 1 < 0 || m1 );
        
        return m0;
    }
    
    private boolean isCorrect(int l, int r) {
        if (l == r) {
            if (bits[l] == 0) return true;
            return false;
        } else {
            if (l < 0) return false;
            if (bits[l] == 1) return true;
            return false;
        }
    }
}