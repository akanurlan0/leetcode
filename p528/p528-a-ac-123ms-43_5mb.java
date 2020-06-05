class Solution {

    private final int[] w;
    private final int s;
    
    public Solution(int[] w) {
        this.w = w;
        int s = 0;
        for (int i = 0; i < this.w.length; i++) {
            s += this.w[i];
        }
        this.s = s;
    }
    
    public int pickIndex() {
        
        double r = Math.random() * s;
        
        int res = 0;
        
        for (int i = 0; i < w.length; i++) {
            r -= w[i];
            if (r <= 0.0) {
                res = i;
                break;
            }
        }
        
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */