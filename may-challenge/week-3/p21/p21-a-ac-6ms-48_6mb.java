class Solution {
    public int countSquares(int[][] a) {
        
        int n = a.length;
        int m = a[n-1].length;
            
        int res = 0;
    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                if (a[i][j] == 0) continue;
                
                if (i == 0 || j == 0) {
                    res += a[i][j];
                    continue;
                }
                
                int min = Integer.MAX_VALUE;
                if (a[i-1][j] < min) {
                    min = a[i-1][j];
                }
                if (a[i-1][j-1] < min) {
                    min = a[i-1][j-1];
                }
                if (a[i][j-1] < min) {
                    min = a[i][j-1];
                }
                    
                a[i][j] += min;
                
                res += a[i][j];
            }
        }
        return res;
    }
}