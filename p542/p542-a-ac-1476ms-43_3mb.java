class Solution {
    
    private int[][] dirs = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
    
    private int[][] matrix;
    private int[][] result;
    private int n, m;
    
    public int[][] updateMatrix(int[][] matrix_) {
        
        matrix = matrix_;
        n = matrix.length;
        m = matrix[n - 1].length;
        
        result = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                if (matrix[i][j] != 0) continue;
                    
                for (int k = 0; k < 4; k++) {
                    int row = i + dirs[k][0];
                    int col = j + dirs[k][1];

                    if (row < 0 || row == n || col < 0 || col == m) continue;

                    if (matrix[row][col] == 1) {
                        if (result[row][col] == 0 || result[row][col] > 1) {
                            dfs(row, col, 1);
                        }
                    }
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int r, int c, int val) {
        result[r][c] = val;
        for (int k = 0; k < 4; k++) {
            int row = r + dirs[k][0];
            int col = c + dirs[k][1];

            if (row < 0 || row == n || col < 0 || col == m) continue;
            
            if (matrix[row][col] == 1) {
                if (result[row][col] == 0 || result[row][col] > val + 1) {
                    dfs(row, col, val + 1);
                }
            }
        }
    }
}