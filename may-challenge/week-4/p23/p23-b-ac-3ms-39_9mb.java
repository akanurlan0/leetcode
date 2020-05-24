class Solution {
    public int[][] intervalIntersection(int[][] a, int[][] b) {
        
        int n = a.length;
        int m = b.length;
        
        int[][] intersections = new int[n+m][2];
        int len = 0;
        
        int i = 0;
        int j = 0;
        
        while (i < n && j < m) {
            int maxStart = Math.max(a[i][0], b[j][0]);
            int minEnd = Math.min(a[i][1], b[j][1]);

            if (maxStart <= minEnd) {
                intersections[len][0] = maxStart;
                intersections[len][1] = minEnd;
                len++;
            }
            
            if (a[i][1] >= b[j][1]) {
                if (j < m) j++;
            } else {
                if (i < n) i++;
            }
        }
        
        return Arrays.copyOf(intersections, len);
    }
}