class Solution {
    public int hIndex(int[] citations) {
        
        int n = citations.length;
        
        if (n == 0) return 0;
        
        int max = citations[n - 1];
        for (int val = max; val >= 0; val--) {
            int r = n - val;
            int l = r - 1;
            
            if (r < 0 || r > n - 1) continue;
            
            if (citations[r] >= val && (l < 0 || (l >= 0 && citations[l] <= val) ) ) return val;
        }
        
        return 0;
    }
}