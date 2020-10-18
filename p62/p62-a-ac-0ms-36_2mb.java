class Solution {
    public int uniquePaths(int m, int n) {
        int[][] map = new int[m][n];
        map[0][0] = 1;
        for (int i = 1; i < n; i++) {
            map[0][i] += map[0][i-1];
        }
        for (int j = 1; j < m; j++) {
            map[j][0] += map[j-1][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                map[i][j] += map[i-1][j];
                map[i][j] += map[i][j-1];
            }
        }
        
        return map[m - 1][n - 1];
    }
}