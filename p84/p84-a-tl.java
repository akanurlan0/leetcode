class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int minHeight = heights[i];
                for (int k = i; k <= j; k++) {
                    minHeight = Math.min(minHeight, heights[k]);
                }
                int area = (j - i + 1) * minHeight;
                max = Math.max(max, area);
            }
        }
        
        return max;
    }
}