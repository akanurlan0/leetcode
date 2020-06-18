class Solution {
    public int hIndex(int[] citations) {
        
        int n = citations.length;
        
        if (n == 0) return 0;
        
        int max = citations[n - 1];
        
        int l = 0;
        int r = max;
        
        int res = 0;
        
        while (l <= r) {
            
            int m = l + ((r - l) / 2);
            
            int b = n - m;
            int a = b - 1;
            
            if (b < 0) {
                r = m;
                continue;
            }
            
            if (b > n - 1) {
                l = m + 1;
                continue;
            }
            
            if (citations[b] >= m && (a < 0 || (a >= 0 && citations[a] <= m) ) ) {
                res = m;
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        return res;
    }
}