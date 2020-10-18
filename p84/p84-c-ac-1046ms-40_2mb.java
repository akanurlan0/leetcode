class Solution {
    public int largestRectangleArea(int[] h) {
        int n = h.length;
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            max = Math.max(max, h[i]);
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                
                h[j] = Math.min(h[j], h[j + 1]);
                
                max = Math.max(
                    max,
                    (i + 1) * h[j]
                );
            }
        }
        
        return max;
    }
}