class Solution {
    
    private int[] bits;
    
    public boolean isOneBitCharacter(int[] bits) {
        
        this.bits = bits;
        int n = bits.length;
        
        boolean[] map = new boolean[n];
        for (int i = 0; i < n - 1; i++) {
            boolean b1 = isCorrect(i, i) && ( i - 1 < 0 || map[i - 1] );
            boolean b2 = isCorrect(i-1, i) && ( i - 2 < 0 || map[i - 2] );
            map[i] = b1 || b2;
        }
        
        int i = n-1;
        map[i] = isCorrect(i, i) && ( i - 1 < 0 || map[i - 1] );
        
        return map[i];
    }
    
    private boolean isCorrect(int l, int r) {
        if (r - l == 0) {
            if (bits[l] == 0) return true;
            return false;
        } else {
            if (l < 0) return false;
            if (bits[l] == 1) return true;
            return false;
        }
    }
}