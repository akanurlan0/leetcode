class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int max = 0;
        
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i][i] = heights[i];
            max = Math.max(max, map[i][i]);
        }
        
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n && (i + j < n); i++) {
                map[i][i + j] = Math.min(
                    map[i][i + j - 1],
                    map[i + 1][i + j]
                );
                
                max = Math.max(
                    max,
                    ((i + j) - i + 1) * map[i][i + j]
                );
            }
        }
        
        return max;
    }
}