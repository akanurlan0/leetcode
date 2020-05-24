class Solution {
    public int[][] intervalIntersection(int[][] a, int[][] b) {
        
        int n = a.length;
        int m = b.length;
        
        int[][] intersections = new int[n+m][2];
        int len = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                int maxStart = Math.max(a[i][0], b[j][0]);
                int minEnd = Math.min(a[i][1], b[j][1]);

                if (maxStart <= minEnd) {
                    intersections[len][0] = maxStart;
                    intersections[len][1] = minEnd;
                    len++;
                }
            }
        }
        
        int[][] res = new int[len][2];
        for (int i = 0; i < len; i++) {
            res[i][0] = intersections[i][0];
            res[i][1] = intersections[i][1];
        }
        
        return res;
    }
}